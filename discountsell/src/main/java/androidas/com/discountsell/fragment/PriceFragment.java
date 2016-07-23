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
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

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

/**
 * Created by my on 2016/7/18.
 * 9.9包邮-价格界面
 */
public class PriceFragment extends Fragment {
    private PullToRefreshGridView mRecommendGridView;
    private List<RecommendInfo.DataBean.ListBean> recommendDatas=new ArrayList<>();
    private static List<Long>timeList=new ArrayList<>();//刷新时间集合
    private static int num;
    private MyListViewAdapter adapter;
    private Context mContext;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mRecommendGridView.onRefreshComplete();
        }
    };
    public static PriceFragment newInstance() {
        PriceFragment fragment = new PriceFragment();
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
        //设置刷新加载
        mRecommendGridView.setMode(PullToRefreshBase.Mode.BOTH);
        mRecommendGridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<GridView>() {
            @Override
            public void onRefresh(PullToRefreshBase<GridView> refreshView) {
                PullToRefreshBase.Mode currentMode = refreshView.getCurrentMode();
                //刷新界面
                if (currentMode== PullToRefreshBase.Mode.PULL_FROM_START){
                    //数据清理
                    recommendDatas.clear();
                    mRecommendGridView.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
                    mRecommendGridView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
                    mRecommendGridView.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
                    refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("距离上次刷新时间"+friendlyTime(new Date()));
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //加载数据
                            laodListViewDatas();
                            //刷新完毕
                            mRecommendGridView.onRefreshComplete();
                        }
                    },2000);
                }else{
                    //加载更多
                    mRecommendGridView.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                    mRecommendGridView.getLoadingLayoutProxy().setPullLabel("上拉加载更多");
                    mRecommendGridView.getLoadingLayoutProxy().setReleaseLabel("释放开始加载");
                    refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("距离上次加载时间"+friendlyTime(new Date()));
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //加载数据
                            laodListViewDatas();
                            //刷新完毕
                            mRecommendGridView.onRefreshComplete();
                        }
                    },2000);
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupListView();
    }

    private void setupListView() {
        //2.创建适配器
        adapter=new MyListViewAdapter(mContext,recommendDatas);
        //3.关联适配器
        mRecommendGridView.setAdapter(adapter);
    }

    private void laodListViewDatas() {
        OkHttpTool.newInstance().start(UtlConfig.SECOND_PAGE_PRICE_URL).callback(new IOKCallBack() {
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
    //销毁视图数据
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recommendDatas.clear();
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
