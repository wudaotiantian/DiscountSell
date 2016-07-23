package androidas.com.discountsell;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.method.BaseKeyListener;
import android.transition.Transition;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidas.com.discountsell.adapter.MyListView;
import androidas.com.discountsell.adapter.MyViewPager;
import androidas.com.discountsell.fragment.FourFragmentDiscount;
import androidas.com.discountsell.fragment.FourFragmentNewest;
import androidas.com.discountsell.fragment.FourFragmentPrice;
import androidas.com.discountsell.fragment.FourFragmentRecomment;
import androidas.com.discountsell.fragment.FourFragmentSalse;
/**
 * Created by xwb on 2016/7/14.
 */
public class FourClick extends AppCompatActivity {

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
    private String[]Id={"all_type_goods","27","29","11","26","14","12","8","10","13","33","32"};
    private FragmentManager frag;
    private MyViewPager myViewPager;
    private RadioButton radioRecomment;
    private RadioButton radioSales;
    private RadioButton radioPrice;
    private RadioButton radioDiscount;
    private RadioButton radioNewest;
    private RadioGroup radioGroup;
    private FourFragmentRecomment fourFragmentRecomment;
    private FourFragmentSalse fourFragmentSalse;
    private FourFragmentPrice fourFragmentPrice;
    private FourFragmentDiscount fourFragmentDiscount;
    private FourFragmentNewest fourFragmentNewest;
    private int num=0;
    private DrawerLayout drawerLayout;
    private LinearLayout linearLayout;
    private PopupWindow mPopWindow;
    private ListView listView;
    private LinearLayout mLinearLayout;
    private View rootview;
    private Animation transtoLeftAnim;
    private Animation nimation;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_click_activity);
        intiView();
        nimation=AnimationUtils.loadAnimation(FourClick.this,R.anim.ss);
        showPopupWindow();
        Intent intent=getIntent();
        name=intent.getStringExtra("myKey");
        tId=intent.getStringExtra("myId");
        textView.setText(name+"—"+"品牌特卖");
        mFragment.clear();
        getFragmentDate();
        iniAdapter();
        bindAdapter();
        onClicdd();
        radioRecomment.setChecked(true);
        initClic();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("androidxx", "onStart: ");
    }

    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(FourClick.this).inflate(R.layout.layout_four, null);
        mPopWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mPopWindow.setContentView(contentView);
        listView= (ListView) contentView.findViewById(R.id.lv_four_layout);
        mLinearLayout= (LinearLayout) contentView.findViewById(R.id.ll_four_layout);
        getTitleData();
        MyListView myAdapter=new MyListView(mTitle,FourClick.this);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(FourClick.this,FourClick.class);
                intent.putExtra("myKey",mTitle.get(i));
                intent.putExtra("myId",Id[i]);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                mPopWindow.dismiss();
            }
        });
        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopWindow.dismiss();
            }
        });
        rootview = LayoutInflater.from(FourClick.this).inflate(R.layout.four_click_activity, null);

    }
    public void onClicdd(){
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        imageTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopWindow.showAsDropDown(findViewById(R.id.rl_four_click_activity));
               mPopWindow.setAnimationStyle(9);

            }
        });
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
        linearLayout= (LinearLayout) findViewById(R.id.ll_four_click_activity);
        drawerLayout= (DrawerLayout) findViewById(R.id.dl_four_click_activity);
        viewPager= (ViewPager) findViewById(R.id.vp_four_click_activity);
        textView= (TextView) findViewById(R.id.tv_four_click_title);
        radioGroup = (RadioGroup) findViewById(R.id.rg_four_click_activity);
        radioRecomment= (RadioButton) findViewById(R.id.bt_four_click_recomment);
        radioSales= (RadioButton) findViewById(R.id.bt_four_click_sales);
        radioPrice= (RadioButton) findViewById(R.id.bt_four_click_price);
        radioDiscount= (RadioButton) findViewById(R.id.bt_four_click_discount);
        radioNewest=(RadioButton)findViewById(R.id.bt_four_click_newest);
        imageTitle= (ImageView) findViewById(R.id.iv_four_click_check);
        imageBack= (ImageView) findViewById(R.id.iv_four_click_back);
    }


    public void getFragmentDate() {
        mFragment.add(fourFragmentRecomment.newInstance(tId));
        mFragment.add(fourFragmentSalse.newInstance(tId));
        mFragment.add(fourFragmentPrice.newInstance(tId));
        mFragment.add(fourFragmentDiscount.newInstance(tId));
        mFragment.add(fourFragmentNewest.newInstance(tId));
    }
    public void iniAdapter(){

        myViewPager=new MyViewPager(getSupportFragmentManager(),mFragment);

    }
    public void bindAdapter(){
        viewPager.setAdapter(myViewPager);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_four_click_recomment:
                viewPager.setCurrentItem(0);
                break;
            case R.id.bt_four_click_sales:
                viewPager.setCurrentItem(1);
                break;
            case R.id.bt_four_click_price:
                viewPager.setCurrentItem(2);
                break;
            case R.id.bt_four_click_discount:
                viewPager.setCurrentItem(3);
                break;
            case R.id.bt_four_click_newest:
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

}

