package androidas.com.discountsell;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidas.com.discountsell.adapter.GridAdapter;
import androidas.com.discountsell.bean.BeadTitle;
import androidas.com.discountsell.httplibrary.IOKCallBack;
import androidas.com.discountsell.httplibrary.OkHttpTool;

/**
 * Created by xwb on 2016/7/15.
 */
public class FourGridActivity extends AppCompatActivity{
    private String mTitle;
    private String mTid;
    private String urlStart="http://appcdn.1zhe.com/android/index_bak.php?v=2.3.5&m=goods&op=index&ac=brand_goods_inner&brand_id=";
    private String urlEnd="&page=1&picsize=";
    private List<BeadTitle.DataBean.ListBeanV.ProductsBean.ListBean> listBeen=new ArrayList<>();
    private GridView myGridView;
    private TextView textView;
    private GridAdapter gridAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_click_title_activity);
        Intent intent=getIntent();
        mTitle=intent.getStringExtra("myTitle");
        mTid=intent.getStringExtra("myTid");
        intview();
        getRlData();
        iniAdapter();
        binAdapter();

    }
    public void intview(){
        myGridView= (GridView) findViewById(R.id.gv_four_title_activty);
        myGridView.setHorizontalSpacing(10);
        myGridView.setVerticalSpacing(10);
        textView= (TextView) findViewById(R.id.tv_four_title_activity);
        textView.setText(mTitle);
    }

    public void getRlData(){
        OkHttpTool.newInstance().start(urlStart+mTid+urlEnd).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Log.i("xxmmmmm",""+result);
                Gson gson=new Gson();
                BeadTitle beadTitle=gson.fromJson(result,BeadTitle.class);
                listBeen.addAll(beadTitle.getData().getListV().getProducts().getList());
                Log.i("xxmmmmm",""+beadTitle.getData().getListV().getProducts().getList());
                listBeen.size();
                gridAdapter.notifyDataSetChanged();

            }
        });
    }
    public void iniAdapter(){
        gridAdapter =new GridAdapter(listBeen,FourGridActivity.this);
    }
    public void binAdapter(){
        myGridView.setAdapter(gridAdapter);
    }

}
