package androidas.com.discountsell;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidas.com.discountsell.adapter.MyViewPager;
import androidas.com.discountsell.fragment.FourFragmentDiscount;
import androidas.com.discountsell.fragment.FourFragmentNewest;
import androidas.com.discountsell.fragment.FourFragmentPrice;
import androidas.com.discountsell.fragment.FourFragmentRecomment;
import androidas.com.discountsell.fragment.FourFragmentSalse;

/**
 * Created by xwb on 2016/7/14.
 */
public class FourClick extends AppCompatActivity{

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
    private FourFragmentRecomment fourFragmentRecomment;
    private FourFragmentSalse fourFragmentSalse;
    private FourFragmentPrice fourFragmentPrice;
    private FourFragmentDiscount fourFragmentDiscount;
    private FourFragmentNewest fourFragmentNewest;
    private int num=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_click_activity);
        intiView();
        Intent intent=getIntent();
        name=intent.getStringExtra("myKey");
        tId=intent.getStringExtra("myId");
        textView.setText(name+"—"+"品牌特卖");
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

