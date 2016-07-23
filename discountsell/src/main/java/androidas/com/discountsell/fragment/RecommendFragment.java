package androidas.com.discountsell.fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidas.com.discountsell.DetailsActivity;
import androidas.com.discountsell.R;
import androidas.com.discountsell.adapter.MyListViewAdapter;
import androidas.com.discountsell.bean.RecommendInfo;
import androidas.com.discountsell.canstant.UtlConfig;
import androidas.com.discountsell.httplibrary.IOKCallBack;
import androidas.com.discountsell.httplibrary.OkHttpTool;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
/**
 * Created by my on 2016/7/16.
 * 9.9包邮-推荐界面
 */
public class RecommendFragment extends Fragment {
    private PullToRefreshGridView mRecommendGridView;
    private List<RecommendInfo.DataBean.ListBean> recommendDatas=new ArrayList<>();//请求网络数据的集合
    private static List<Long>timeList=new ArrayList<>();//下拉刷新的时间集合
    private static int num=0;
    private MyListViewAdapter adapter;
    private Context mContext;
    //使用Handle来处理子线程发来的消息
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //刷新完毕
            mRecommendGridView.onRefreshComplete();
        }
    };
    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        //获取ListView视图
        mRecommendGridView= (PullToRefreshGridView) view.findViewById(R.id.gv_recommend);
        //加载网络数据
        recommendDatas.clear();
        laodListViewDatas();
        //对GrideView设置监听
        mRecommendGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private String title;
            private String pro_url;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mContext, "1111111111", Toast.LENGTH_SHORT).show();
                //获取详情页面的URL
                pro_url = recommendDatas.get(i).getPro_url();
                //获取详情页面的商品名
                title = recommendDatas.get(i).getTitle();
                //跳转Activity并且将详情页面的URL传过去
                Intent intent=new Intent();
                intent.setClass(getActivity(),DetailsActivity.class);
                intent.putExtra("detailUrl",pro_url);
                intent.putExtra("detailTitle",title);
                startActivity(intent);
            }
        });
        //设置上拉加载更多，下拉刷新
        mRecommendGridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                //下拉刷新
                //子线程操作耗时刷新任务
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //刷新视图
                        try {
                            Thread.sleep(2000);
                            //刷新视图完毕
                            mRecommendGridView.onRefreshComplete();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //给主线程发送消息，参数0表示立即发送，不延迟
                        handler.sendEmptyMessage(0);
                    }
                }).start();
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                //上拉加载
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //加载更多任务
                        try {
                            Thread.sleep(2000);
                            //加载后续网址
                            laodListViewDatas();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //给主线程发消息
                        handler.sendEmptyMessage(0);
                    }
                }).start();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupListView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //前面的数据清理
        recommendDatas.clear();
    }

    private void setupListView() {
        //2.创建适配器
        adapter=new MyListViewAdapter(mContext,recommendDatas);
        //设置刷新的时间文本
        mRecommendGridView.setMode(PullToRefreshBase.Mode.BOTH);
        mRecommendGridView.setLastUpdatedLabel("距离上次刷新时间："+friendlyTime(new Date()));
        //3.关联适配器
        mRecommendGridView.setAdapter(adapter);
    }
    //ListView加载网络数据
    private void laodListViewDatas() {
        OkHttpTool.newInstance().start(UtlConfig.SECOND_PAGE_RECOMMEND_URL).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                RecommendInfo recommendInfo=gson.fromJson(result,RecommendInfo.class);
                //获取所有的推荐的页面的信息
                recommendDatas.addAll( recommendInfo.getData().getList());
                //通知适配器更新视图
                adapter.notifyDataSetChanged();
            }
        });
    }
    public static String friendlyTime(Date time){
        timeList.add(time.getTime());//从网络获取目前时间
        int currentTime = (int) ((timeList.get(num) - timeList.get(num == 0 ? 0 : num - 1)) / 1000);
        num++;
        //判断年月日时分秒
        if (currentTime == 0) {
            return "刚刚";
        }
        if (0<currentTime&&currentTime<60) {
            return currentTime/60+"分"
                    +currentTime%60+"秒前";
        }
        if (60<=currentTime&&currentTime<3600) {
            return currentTime/3600+"小时"
                    +(currentTime%3600)/60+"分"
                    +currentTime%60+"秒前";
        }
        if (3600<=currentTime&&currentTime<86400) {
            return currentTime/86400+"天"
                    +(currentTime%86400)/3600 +"小时"
                    +((currentTime%86400)%3600)/60+"分"
                    +currentTime%86400+"秒前";
        }
        if (0<currentTime&&currentTime<60) {
            return currentTime+"秒前";
        }
        if (0<currentTime&&currentTime<60) {
            return currentTime+"秒前";
        }
        return currentTime/259200+"月";
    }
}
