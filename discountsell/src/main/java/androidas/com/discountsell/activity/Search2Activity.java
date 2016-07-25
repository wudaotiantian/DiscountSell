package androidas.com.discountsell.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidas.com.discountsell.R;
import androidas.com.discountsell.adapter.SearchAdapter;
import androidas.com.discountsell.bean.SearchBean;
import androidas.com.discountsell.constants.UrlData;
import androidas.com.discountsell.http.HttpUtil;
import androidas.com.discountsell.http.IRequestCallBack;

public class Search2Activity extends AppCompatActivity {

    private ListView lv;
    private List<SearchBean.RowsBean> list = new ArrayList<>();
    private SearchAdapter adapter;
    private String encode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);
        initView();
        initData();
        initAdapter();
        lv.setAdapter(adapter);
    }


    private void initAdapter() {
        adapter = new SearchAdapter(list,Search2Activity.this);
    }

    private void initData() {
        Intent intent = getIntent();
        String et = intent.getStringExtra("key");
        try {
            encode = URLEncoder.encode(et, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("ckey",encode);

        if(!et.isEmpty()){
            HttpUtil.requestPost1(UrlData.SEARCH3, "ckey=" + et, new IRequestCallBack() {
                @Override
                public void onSuccess(String result) {
                    Gson gson = new Gson();
                    Log.i("ttt", "onSuccess: "+result);
                    SearchBean sb = gson.fromJson(result,SearchBean.class);
                    list.addAll(sb.getRows());
                    adapter.notifyDataSetChanged();
                }
            });
//            OkHttpTool.newInstance().start(UrlData.SEARCH3).post(stringStringHashMap).callback(new IOKCallBack() {
//                @Override
//                public void success(String result) {
//                    Gson gson = new Gson();
//                    Log.i("ttt", "onSuccess: "+result);
//                    SearchBean sb = gson.fromJson(result,SearchBean.class);
//                    list.addAll(sb.getRows());
//                    adapter.notifyDataSetChanged();
//                }
//            });
        }

    }

    private void initView() {
        lv = (ListView) findViewById(R.id.serch2_listview);
    }
}
