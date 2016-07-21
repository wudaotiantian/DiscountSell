package androidas.com.discountsell.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import androidas.com.discountsell.R;
import androidas.com.discountsell.adapter.HeaderAdapterV;
import androidas.com.discountsell.adapter.RecyclerAdapter;
import androidas.com.discountsell.bean.BeanSale;
import androidas.com.discountsell.canstant.UtlConfig;
import androidas.com.discountsell.httplibrary.IOKCallBack;
import androidas.com.discountsell.httplibrary.OkHttpTool;
import androidas.com.discountsell.line.HorizontalDividerItemDecoration;
import androidas.com.discountsell.line.VerticalDividerItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FourFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecyclerView;
    private List<String> mTitle= new ArrayList<>();
    private List<BeanSale.DataBean.ListBeanV> items=new ArrayList<>();
    private List<BeanSale.DataBean.ListBeanV.GoodsListBean> dataItems=new ArrayList<>();
    private Context mContext;
    private RecyclerAdapter recyclerAdapter;
    private View headerView;
    private XRecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;


    public FourFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment FourFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FourFragment newInstance() {
        FourFragment fragment = new FourFragment();
        Bundle args = new Bundle();
       // args.putString(ARG_PARAM1, param1);
       // args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
        mContext=getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_four, container, false);
        recyclerView = (XRecyclerView) view.findViewById(R.id.rv_fragment_four);
        getRlData();
        getTitleData();

        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new android.os.Handler().postDelayed(new Runnable() {
                    public void run() {
                        recyclerView.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                for (int i=0;i<3;i++){
                    if (i==2){

                        return;
                    }
                    new android.os.Handler().postDelayed(new Runnable() {
                        public void run() {
                            getRlData();
                          recyclerView.loadMoreComplete();
                        }
                    }, 1000);
                }


            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).size(20).build());
        recyclerAdapter=new RecyclerAdapter(items,mContext,mTitle);
        recyclerView.setAdapter(recyclerAdapter);


    }

    public void getTitleData(){
        mTitle.add("全部");
        mTitle.add("女装");
        mTitle.add("男装");
        mTitle.add("母婴");
        mTitle.add("美食");
        mTitle.add("美妆");
        mTitle.add("鞋包");
        mTitle.add("数码");
        mTitle.add("家具");
        mTitle.add("文体");
        mTitle.add("配饰");
        mTitle.add("中老年");


    }
    public void getRlData(){

        OkHttpTool.newInstance().start(UtlConfig.URL_SALE).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson=new Gson();
                BeanSale beanSale=gson.fromJson(result,BeanSale.class);
                Log.i("xxxxx","xxxxxxx"+beanSale);
                items.addAll(beanSale.getData().getListV());
                recyclerAdapter.notifyDataSetChanged();
            }
        });
    }





}
