package androidas.com.discountsell.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import java.util.List;

import androidas.com.discountsell.DetailsActivity;
import androidas.com.discountsell.R;
import androidas.com.discountsell.adapter.MyListViewAdapter;
import androidas.com.discountsell.bean.RecommendInfo;
import androidas.com.discountsell.canstant.UtlConfig;
import androidas.com.discountsell.httplibrary.IOKCallBack;
import androidas.com.discountsell.httplibrary.OkHttpTool;

/**
 * Created by my on 2016/7/16.
 * 9.9包邮-推荐界面
 */
public class RecommendFragment extends Fragment{
    private GridView mRecommendGridView;
    private List<RecommendInfo.DataBean.ListBean> recommendDatas=new ArrayList<>();
    private MyListViewAdapter adapter;
    private Context mContext;
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
        mRecommendGridView= (GridView) view.findViewById(R.id.gv_recommend);
        //加载网络数据
        laodListViewDatas();
        //对GrideView设置监听
        mRecommendGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private String pro_url;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mContext, "1111111111", Toast.LENGTH_SHORT).show();
                //获取详情页面的URL
                pro_url = recommendDatas.get(i).getPro_url();
                //跳转Activity并且将详情页面的URL传过去
                Intent intent=new Intent();
                intent.setClass(getActivity(),DetailsActivity.class);
                intent.putExtra("detailUrl",pro_url);
                startActivity(intent);
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
}