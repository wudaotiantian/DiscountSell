package androidas.com.discountsell.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidas.com.discountsell.FourDetailsActivity;
import androidas.com.discountsell.R;
import androidas.com.discountsell.adapter.GridAdapterAll;
import androidas.com.discountsell.bean.BeadGridAll;
import androidas.com.discountsell.httplibrary.IOKCallBack;
import androidas.com.discountsell.httplibrary.OkHttpTool;

/**
 * Created by xwb on 2016/7/16.
 */
public class FourFragmentSalse extends Fragment {

    private PullToRefreshGridView gridView;
    final static public String urlStart ="http://appcdn.1zhe.com/android/index_bak.php?v=2.3.5&m=goods&op=index&ac=channel_goods&channel_num=216&page=1&type_num=";
    final static public String urlEnd="&sort_name=volume&sort=desc&picsize=";
    private String tid;
    public static List<Long> mList= new ArrayList<>();
    public static int num=0;
    private List<BeadGridAll.DataBean.ListBean> itemDatas=new ArrayList<>();
    private GridAdapterAll gridAdapter;
    public static FourFragmentSalse newInstance(String tId){
        FourFragmentSalse fourFragmentClick=new FourFragmentSalse();
        Bundle bundle=new Bundle();
        bundle.putString("key",tId);
        fourFragmentClick.setArguments(bundle);
        return fourFragmentClick;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.four_click_grid_vp,container,false);
        gridView= (PullToRefreshGridView) view.findViewById(R.id.gv_four_grid_vp);
        Bundle bundle= getArguments();
        tid=bundle.getString("key");
        itemDatas.clear();
        londData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridAdapter=new GridAdapterAll(itemDatas,getActivity());
        gridView.setAdapter(gridAdapter);
        initListener();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), FourDetailsActivity.class);
                String url=itemDatas.get(i).getPro_url();
                intent.putExtra("path",url);
                startActivity(intent);
            }
        });
    }
    public void initListener() {
        gridView.setMode(PullToRefreshBase.Mode.BOTH);
        gridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<GridView>() {
            @Override
            public void onRefresh(PullToRefreshBase<GridView> refreshView) {
                PullToRefreshBase.Mode currentMode = refreshView.getCurrentMode();
                if (currentMode == PullToRefreshBase.Mode.PULL_FROM_START) {
                    itemDatas.clear();
                    gridView.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
                    gridView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
                    gridView.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
                    // gridView.setLastUpdatedLabel("距离上次更新时间："+friendlyTime(new Date()));
                    refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("距离上次更新时间：" + friendlyTime(new Date()));
                    new android.os.Handler().postDelayed(new Runnable() {
                        public void run() {
                            londData();
                            gridView.onRefreshComplete();
                        }
                    }, 2000);
                } else {
                    //加载更多
                    gridView.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                    gridView.getLoadingLayoutProxy().setPullLabel("上拉加载更多");
                    gridView.getLoadingLayoutProxy().setReleaseLabel("释放开始加载");
                    // gridView.setLastUpdatedLabel("距离上次加载时间："+friendlyTime(new Date()));
                    refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("距离上次加载时间：" + friendlyTime(new Date()));
                    new android.os.Handler().postDelayed(new Runnable() {
                        public void run() {
                            londData();
                            gridView.onRefreshComplete();
                        }
                    }, 2000);
                }
            }
        });
    }
    public void londData(){
        OkHttpTool.newInstance().start(urlStart+tid+urlEnd).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                BeadGridAll beadGridAll=gson.fromJson(result,BeadGridAll.class);
                itemDatas.addAll(beadGridAll.getData().getList());
                gridAdapter.notifyDataSetChanged();
            }
        });

    }
    public void onDestroyView() {
        super.onDestroyView();
        itemDatas.clear();
    }
    public static String friendlyTime(Date time) {
        mList.add(time.getTime());
        int ct = (int)((mList.get(num) - mList.get(num==0?0:num-1))/1000);
        num++;
        if(ct == 0) {
            return "刚刚";
        }

        if(ct > 0 && ct < 60) {
            return +ct + "秒前";
        }

        if(ct >= 60 && ct < 3600) {
            return Math.max(ct / 60,1) + "分钟前";
        }
        if(ct >= 3600 && ct < 86400)
            return ct / 3600 + "小时前";
        if(ct >= 86400 && ct < 2592000){ //86400 * 30
            int day = ct / 86400 ;
            return day + "天前";
        }
        if(ct >= 2592000 && ct < 31104000) { //86400 * 30
            return ct / 2592000 + "月前";
        }
        return ct / 31104000 + "年前";
    }
}