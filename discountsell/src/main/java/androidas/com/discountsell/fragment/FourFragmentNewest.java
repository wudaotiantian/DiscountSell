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
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
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
public class FourFragmentNewest extends Fragment {

    private PullToRefreshGridView gridView;
    final static public String urlStart ="http://appcdn.1zhe.com/android/index_bak.php?v=2.3.5&m=goods&op=index&ac=channel_goods&channel_num=216&page=1&type_num=";
    final static public String urlEnd="&sort_name=time&sort=desc&picsize=";
    private String tid;
    private List<BeadGridAll.DataBean.ListBean> itemDatas=new ArrayList<>();
    private GridAdapterAll gridAdapter;
    public static FourFragmentNewest newInstance(String tId){
        FourFragmentNewest fourFragmentClick=new FourFragmentNewest();
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

    public void londData(){
        if (itemDatas!=null&&itemDatas.isEmpty()==false){
            return;
        }
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
}