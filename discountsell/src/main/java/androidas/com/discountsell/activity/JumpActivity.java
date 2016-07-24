package androidas.com.discountsell.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidas.com.discountsell.R;
import androidas.com.discountsell.adapter.FirstClassAdapter;
import androidas.com.discountsell.adapter.GridFragmentAdapter;
import androidas.com.discountsell.adapter.MyViewPager;
import androidas.com.discountsell.adapter.SecondClassAdapter;
import androidas.com.discountsell.bean.FirstPageBean;
import androidas.com.discountsell.constants.UrlData;
import androidas.com.discountsell.httplibrary.IOKCallBack;
import androidas.com.discountsell.httplibrary.OkHttpTool;
import androidas.com.discountsell.model.FirstClassItem;
import androidas.com.discountsell.model.SecondClassItem;
import androidas.com.discountsell.myfragments.AFragment;
import androidas.com.discountsell.myfragments.BFragment;
import androidas.com.discountsell.myfragments.CFragment;
import androidas.com.discountsell.myfragments.DFragment;
import androidas.com.discountsell.myfragments.EFragment;
import androidas.com.discountsell.utils.ScreenUtils;

public class JumpActivity extends AppCompatActivity {
    private ArrayList<String> mTabList = new ArrayList<>();
    private ArrayList<View>mViewList = new ArrayList<>();
    private RadioButton radioButton;
    private TextView tv1;
    private TextView tv2;
    private String id;
private TabLayout tabLayout;
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
    private GridView gridView;
    private TextView textView;
    private ImageView imageTitle;
    private ImageView imageBack;
    private ViewPager viewPager;
    private List<Fragment> mFragment=new ArrayList<>();
    private List<String> mTitle=new ArrayList<>();
    private FragmentTransaction transaction;
    private String name;
    private String tId;
    private FragmentManager frag;
    private MyViewPager myViewPager;
    private RadioButton radioRecomment;
    private RadioButton radioSales;
    private RadioButton radioPrice;
    private RadioButton radioDiscount;
    private RadioButton radioNewest;
    private RadioGroup radioGroup;
    private AFragment fourFragmentRecomment;
    private BFragment fourFragmentSalse;
    private CFragment fourFragmentPrice;
    private DFragment fourFragmentDiscount;
    private EFragment fourFragmentNewest;
    private int num=0;
    private View darkView;
    private Animation animIn;
    private Animation animOut;
    /**左侧一级分类的数据*/
    private List<FirstClassItem> firstList;
    /**右侧二级分类的数据*/
    private List<SecondClassItem> secondList;

    /**使用PopupWindow显示一级分类和二级分类*/
    private PopupWindow popupWindow;

    /**左侧和右侧两个ListView*/
    private ListView leftLV, rightLV;
    private ArrayList<SecondClassItem> secondList1;
    private FirstClassAdapter firstAdapter;
    private SecondClassAdapter secondAdapter;

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
        String title = intent.getStringExtra("key1");
         id = intent.getStringExtra("key");
        Log.i("tagid", "onCreate: "+id);
        tv1.setText(title);
        tv2.setText("全部 ");
//        relativeLayout = (RelativeLayout) findViewById(R.id.radio_viewpager_rl);
       // tabLayout = (TabLayout) findViewById(R.id.fir_hor_scroll);
       // viewPager = (ViewPager) findViewById(R.id.fir_grid_viewpager);
//        Drawable drawable =getResources().getDrawable(R.drawable.icon_asc);
//        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
//
//        radioButton.setCompoundDrawables(null,null,drawable,null);
        mContents = new String[]{"全部","连衣裙","上衣","防晒衣","半身裙","套装","裤装","睡衣","内衣/袜子","针织衫"};
       // tabLayout.addView(view1);
//mTabList.add("全部");
//        mTabList.add("连衣裙");
//        mTabList.add("上衣");
//        mTabList.add("防晒衣");
//        mTabList.add("半身裙");
//        mTabList.add("套装");
//        mTabList.add("裤装");
//        mTabList.add("睡衣");
//        mTabList.add("内衣/袜子");
//        mTabList.add("针织衫");
//        CustomPagerAdapter adapter = new CustomPagerAdapter(mViewList,mTabList);
//        tabLayout.setTabsFromPagerAdapter(adapter);
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
intiView();
        mFragment.clear();
        getFragmentDate();
        iniAdapter();
        bindAdapter();
        radioRecomment.setChecked(true);
        initClic();
    }


    public void getNumber(){
        if(radioPrice.isChecked()==true){
            if(num==0){
                Drawable drawable =getResources().getDrawable(R.drawable.icon_desc);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                radioPrice.setCompoundDrawables(null,null,drawable,null);
                num=1;
            }else if(num==1){
                Drawable drawable=getResources().getDrawable(R.drawable.icon_asc);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                radioPrice.setCompoundDrawables(null,null,drawable,null);
                num=0;
            }
        }else {
            Drawable drawable=getResources().getDrawable(R.drawable.ass);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            radioPrice.setCompoundDrawables(null,null,drawable,null);
            num=0;
        }

    }

    public void initClic(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i("xuwenbin","xxxxx");
            }

            @Override
            public void onPageSelected(int position) {
                Log.i("xuwenbin","xxxxx");
                setDotsEnable(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("xuwenbin","xxxxx");

            }
        });
    }

    public void intiView() {
        viewPager= (ViewPager) findViewById(R.id.radio_viewpager_rl);
        //textView= (TextView) findViewById(R.id.tv_four_click_title);
        radioGroup = (RadioGroup) findViewById(R.id.rg1);
        radioRecomment= (RadioButton) findViewById(R.id.rb_1);
        radioSales= (RadioButton) findViewById(R.id.rb_2);
        radioPrice= (RadioButton) findViewById(R.id.rb_3);
        radioDiscount= (RadioButton) findViewById(R.id.rb_4);
        radioNewest=(RadioButton)findViewById(R.id.rb_5);
        imageTitle= (ImageView) findViewById(R.id.btn_list_imageview);
        imageBack= (ImageView) findViewById(R.id.logo_back);
        darkView = findViewById(R.id.main_darkview);

        animIn = AnimationUtils.loadAnimation(this, R.anim.fade_in_anim);
        animOut = AnimationUtils.loadAnimation(this, R.anim.fade_out_anim);
        firstList = new ArrayList<FirstClassItem>();
        //1
         secondList1 = new ArrayList<SecondClassItem>();
        secondList1.add(new SecondClassItem("全部"));
        secondList1.add(new SecondClassItem( "连衣裙"));
        secondList1.add(new SecondClassItem("上衣"));
        secondList1.add(new SecondClassItem("防晒衣"));
        secondList1.add(new SecondClassItem( "半身裙"));
        secondList1.add(new SecondClassItem( "套装"));
        secondList1.add(new SecondClassItem( "裤装"));
        secondList1.add(new SecondClassItem("睡衣"));
        secondList1.add(new SecondClassItem( "内衣/袜子"));
        secondList1.add(new SecondClassItem( "针织衫"));
        OkHttpTool.newInstance().start(UrlData.FIRSTPAGE_URL).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                FirstPageBean bean = gson.fromJson(result,FirstPageBean.class);
                for(int i = 0;i<bean.getData().getIndex_type().getList().size();i++){
                firstList.add(new FirstClassItem(bean.getData().getIndex_type().getList().get(i).getTitle(), secondList1));
                    Log.i("tagshu", "success: "+firstList.size() );


                }
                initPopup();
              //  firstList.addAll(firstList);
                firstAdapter.notifyDataSetChanged();
                secondAdapter.notifyDataSetChanged();
                Log.i("tagshu", "success: "+firstList.size() );

            }
        });




        imageTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    popupWindow.showAsDropDown(findViewById(R.id.main_div_line));
                    popupWindow.setAnimationStyle(1);
                    //背景变暗
                    darkView.startAnimation(animIn);
                    darkView.setVisibility(View.VISIBLE);
                }
            }
        });



    }

    private void initPopup() {
        popupWindow = new PopupWindow(this);
        View view = LayoutInflater.from(this).inflate(R.layout.popup_layout, null);
        leftLV = (ListView) view.findViewById(R.id.pop_listview_left);
        rightLV = (ListView) view.findViewById(R.id.pop_listview_right);

        popupWindow.setContentView(view);
        popupWindow.setBackgroundDrawable(new PaintDrawable());
        popupWindow.setFocusable(true);

        popupWindow.setHeight(ScreenUtils.getScreenH(this) * 1 / 3);
        popupWindow.setWidth(ScreenUtils.getScreenW(this));

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                darkView.startAnimation(animOut);
                darkView.setVisibility(View.GONE);

                leftLV.setSelection(0);
                rightLV.setSelection(0);
            }
        });


        //为了方便扩展，这里的两个ListView均使用BaseAdapter.如果分类名称只显示一个字符串，建议改为ArrayAdapter.
        //加载一级分类
          firstAdapter = new FirstClassAdapter(this, firstList);
        leftLV.setAdapter(firstAdapter);

        //加载左侧第一行对应右侧二级分类
        secondList = new ArrayList<SecondClassItem>();
        secondList.addAll(firstList.get(0).getSecondList());
         secondAdapter = new SecondClassAdapter(this, secondList);
        rightLV.setAdapter(secondAdapter);

        //左侧ListView点击事件
        leftLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //二级数据
                List<SecondClassItem> list2 = firstList.get(position).getSecondList();
                //如果没有二级类，则直接跳转
                if (list2 == null || list2.size() == 0) {
                    popupWindow.dismiss();

                   // int firstId = firstList.get(position).getId();
                    //String selectedName = firstList.get(position).getName();
                    //handleResult(firstId, -1, selectedName);
                    return;
                }

                FirstClassAdapter adapter = (FirstClassAdapter) (parent.getAdapter());
                //如果上次点击的就是这一个item，则不进行任何操作
                if (adapter.getSelectedPosition() == position){
                    return;
                }

                //根据左侧一级分类选中情况，更新背景色
                adapter.setSelectedPosition(position);
                adapter.notifyDataSetChanged();

                //显示右侧二级分类
                updateSecondListView(list2, secondAdapter);
            }
        });

        //右侧ListView点击事件
        rightLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //关闭popupWindow，显示用户选择的分类

                Intent intent = new Intent(JumpActivity.this, JumpActivity.class);
                String title1 ="全部";
                String id1 = "27";

                intent.putExtra("key1",title1);
                intent.putExtra("key",id1);
                startActivity(intent);


               // popupWindow.dismiss();

               // int firstPosition = firstAdapter.getSelectedPosition();
               // int firstId = firstList.get(firstPosition).getId();
                //int secondId = firstList.get(firstPosition).getSecondList().get(position).getId();
                //String selectedName = firstList.get(firstPosition).getSecondList().get(position)
                 //       .getName();
                //handleResult(firstId, secondId, selectedName);
            }
        });
    }


    public void getFragmentDate() {
        mFragment.add(fourFragmentRecomment.newInstance(id));
        mFragment.add(fourFragmentSalse.newInstance(id));
        mFragment.add(fourFragmentPrice.newInstance(id));
        mFragment.add(fourFragmentDiscount.newInstance(id));
        mFragment.add(fourFragmentNewest.newInstance(id));
    }
    public void iniAdapter(){

        myViewPager=new MyViewPager(getSupportFragmentManager(),mFragment);

    }
    public void bindAdapter(){
        viewPager.setAdapter(myViewPager);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rb_1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rb_2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rb_3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.rb_4:
                viewPager.setCurrentItem(3);
                break;
            case R.id.rb_5:
                viewPager.setCurrentItem(4);
                break;
            default:
                break;
        }
        getNumber();

    }
    private void setDotsEnable(int position) {

//        RadioButton childAt = (RadioButton) radioGroup.getChildAt(position);
//        childAt.setChecked(true);

        switch (position) {
            case 0:
                radioRecomment.setChecked(true);
                radioSales.setChecked(false);
                radioPrice.setChecked(false);
                radioDiscount.setChecked(false);
                radioNewest.setChecked(false);
                break;
            case 1:
                radioRecomment.setChecked(false);
                radioSales.setChecked(true);
                radioPrice.setChecked(false);
                radioDiscount.setChecked(false);
                radioNewest.setChecked(false);
                break;
            case 2:
                radioRecomment.setChecked(false);
                radioSales.setChecked(false);
                radioPrice.setChecked(true);
                radioDiscount.setChecked(false);
                radioNewest.setChecked(false);
                break;
            case 3:
                radioRecomment.setChecked(false);
                radioSales.setChecked(false);
                radioPrice.setChecked(false);
                radioDiscount.setChecked(true);
                radioNewest.setChecked(false);
                break;
            case 4:
                radioRecomment.setChecked(false);
                radioSales.setChecked(false);
                radioPrice.setChecked(false);
                radioDiscount.setChecked(false);
                radioNewest.setChecked(true);
                break;
            default:
                break;
        }
        getNumber();
    }


    //刷新右侧ListView
    private void updateSecondListView(List<SecondClassItem> list2,
                                      SecondClassAdapter secondAdapter) {
        secondList.clear();
        secondList.addAll(list2);
        secondAdapter.notifyDataSetChanged();
    }

    //处理点击结果
    private void handleResult(int firstId, int secondId, String selectedName){
        String text = "first id:" + firstId + ",second id:" + secondId;
        Toast.makeText(JumpActivity.this, text, Toast.LENGTH_SHORT).show();

        //mainTab1TV.setText(selectedName);
    }
}
