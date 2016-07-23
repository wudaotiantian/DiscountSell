package androidas.com.discountsell.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidas.com.discountsell.R;
import androidas.com.discountsell.adapter.CustomPagerAdapter;
import androidas.com.discountsell.adapter.GridFragmentAdapter;

public class JumpActivity extends AppCompatActivity {
    private ArrayList<String> mTabList = new ArrayList<>();
    private ArrayList<View>mViewList = new ArrayList<>();
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView tv1;
    private TextView tv2;
    private String id;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] mContents;
    private GridFragmentAdapter adapter;
    private View view1;
    private RelativeLayout relativeLayout;
    private View view2;
    private View view3;
    private View view4;
    private View view5;
    private View view6;
    private View view7;
    private View view8;
    private View view9;
    private View view10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        // radioGroup = (RadioGroup) findViewById(R.id.fir_grid_rg);
       // radioButton = (RadioButton) findViewById(R.id.rb_1);
        view1 = LayoutInflater.from(JumpActivity.this).inflate(R.layout.radio_viewpager_item,null);
        view2 = LayoutInflater.from(JumpActivity.this).inflate(R.layout.radio_viewpager_item,relativeLayout,false);
        view3= LayoutInflater.from(JumpActivity.this).inflate(R.layout.radio_viewpager_item,relativeLayout,false);
        view4 = LayoutInflater.from(JumpActivity.this).inflate(R.layout.radio_viewpager_item,relativeLayout,false);
        view5 = LayoutInflater.from(JumpActivity.this).inflate(R.layout.radio_viewpager_item,relativeLayout,false);
        view6 = LayoutInflater.from(JumpActivity.this).inflate(R.layout.radio_viewpager_item,relativeLayout,false);
        view7 = LayoutInflater.from(JumpActivity.this).inflate(R.layout.radio_viewpager_item,relativeLayout,false);
        view8 = LayoutInflater.from(JumpActivity.this).inflate(R.layout.radio_viewpager_item,relativeLayout,false);
        view9 = LayoutInflater.from(JumpActivity.this).inflate(R.layout.radio_viewpager_item,relativeLayout,false);
        view10 = LayoutInflater.from(JumpActivity.this).inflate(R.layout.radio_viewpager_item,relativeLayout,false);

        tv1 = (TextView) findViewById(R.id.fir_grid_textview);
        tv2 = (TextView) findViewById(R.id.toorbar_content_textview);
        Intent intent = getIntent();
        String title = intent.getStringExtra("key");
         id = intent.getStringExtra("id");
        tv1.setText(title);
        tv2.setText("全部 ");
        relativeLayout = (RelativeLayout) findViewById(R.id.radio_viewpager_rl);
        tabLayout = (TabLayout) findViewById(R.id.fir_hor_scroll);
       // viewPager = (ViewPager) findViewById(R.id.fir_grid_viewpager);
//        Drawable drawable =getResources().getDrawable(R.drawable.icon_asc);
//        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
//
//        radioButton.setCompoundDrawables(null,null,drawable,null);
        mContents = new String[]{"全部","连衣裙","上衣","防晒衣","半身裙","套装","裤装","睡衣","内衣/袜子","针织衫"};
       // tabLayout.addView(view1);
mTabList.add("全部");
        mTabList.add("连衣裙");
        mTabList.add("上衣");
        mTabList.add("防晒衣");
        mTabList.add("半身裙");
        mTabList.add("套装");
        mTabList.add("裤装");
        mTabList.add("睡衣");
        mTabList.add("内衣/袜子");
        mTabList.add("针织衫");
        CustomPagerAdapter adapter = new CustomPagerAdapter(mViewList,mTabList);
        tabLayout.setTabsFromPagerAdapter(adapter);
//        //adapter = new GridFragmentAdapter(JumpActivity.this,mContents);
//        tabLayout.addTab(tabLayout.newTab().setText(mContents[0]));
//        tabLayout.addTab(tabLayout.newTab().setText(mContents[1]));
//        tabLayout.addTab(tabLayout.newTab().setText(mContents[2]));
//        tabLayout.addTab(tabLayout.newTab().setText(mContents[3]));
//        tabLayout.addTab(tabLayout.newTab().setText(mContents[4]));
//        tabLayout.addTab(tabLayout.newTab().setText(mContents[5]));
//        tabLayout.addTab(tabLayout.newTab().setText(mContents[6]));
//        tabLayout.addTab(tabLayout.newTab().setText(mContents[7]));
//        tabLayout.addTab(tabLayout.newTab().setText(mContents[8]));
//        tabLayout.addTab(tabLayout.newTab().setText(mContents[9]));


    }
}
