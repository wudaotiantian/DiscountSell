package androidas.com.discountsell.fragment;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidas.com.discountsell.R;
import androidas.com.discountsell.adapter.MyListView;
import androidas.com.discountsell.adapter.MyListViewAdapter;

/**
 * 9.9包邮界面
 */
public class SecondFragment extends Fragment {
    private View view;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> fragments=new ArrayList<>();//Fragment集合
    private List<String> mTitleDatas=new ArrayList<>();//Tab标题集合
    private List<String> mPopDatas=new ArrayList<>();//pop标题集合
    private MyFragmentPagerAdapter mFragmentPagerAdapter;
    private ImageView mImageView;
    private Context mContext;
    private PopupWindow popupWindow;
    private RelativeLayout relativeLayout;
    private ListView popListView;
    private LinearLayout popLayout;
    //popupWindow里面的数据
    public static final String[]firstData=new String[]{
            "全部","女装","男装","母婴","美食","美妆","鞋包","数码","家居","文本","配饰","中老年"
    };
    public static final Map<String,String[]>map=new HashMap<>();
    static {
        map.put("全部",new String[]{});
        map.put("女装",new String[]{"全部","连衣裙","上衣","防晒衣","半身裙","套装","裤装","睡衣","内衣/袜子","针织衫"});
        map.put("男装",new String[]{"全部","上衣","裤装","套装","睡衣","内衣/袜子"});
        map.put("母婴",new String[]{"全部","童装","童鞋","婴幼用品","玩具/早教","孕妈必备","婴幼服饰"});
        map.put("美食",new String[]{"全部","休闲食品","油粮干货","饮料冲调","营养保健","果蔬生鲜","茶酒"});
        map.put("美妆",new String[]{"全部","彩妆香氛","美甲美发","美容护肤","其他/工具"});
        map.put("鞋包",new String[]{"全部","女鞋","男鞋","女包","男包","家居鞋","功能箱包"});
        map.put("数码",new String[]{"全部","手机周边","电脑配件","生活电器","保健器材"});
        map.put("家居",new String[]{"全部","温馨家纺","厨房烹饪","居家百货","家居饰品","家具/建材","整理收纳","水杯"});
        map.put("文本",new String[]{"全部","办公|学习","户外用品","有车族","运动健身","宠物专区","其它"});
        map.put("配饰",new String[]{"全部","服装配饰","精品首饰","其它配饰","精美手表"});
        map.put("中老年",new String[]{"全部","服装","鞋子","其他"});
    }
    //单例模式
    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //添加视图
        view = inflater.inflate(R.layout.fragment_second,container,false);
        //初始化视图
        initView();
        //1.准备数据源
        //初始化Fragment
        setupData();
        //初始化TabLayout标题
        setupTitleDatas();
        //2.创建适配器
        mFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        //3.关联适配器
        mViewPager.setAdapter(mFragmentPagerAdapter);
        //初始化TabLayout
        mTabLayout.setupWithViewPager(mViewPager);

        //对ImageView进行监听，弹出PopupWindow
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "11111111111", Toast.LENGTH_SHORT).show();
                //弹出窗口布局
                View contentView = LayoutInflater.from(mContext).inflate(R.layout.fragment_freepost_popupwindow, null);
                //创建窗口布局
                popupWindow = new PopupWindow(contentView,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,true);
                //填充内容
                popupWindow.setContentView(contentView);
                popListView = (ListView) contentView.findViewById(R.id.lv_popupwindow_left);
                popLayout = (LinearLayout) contentView.findViewById(R.id.ll_pop);
                MyListView mAdapter=new MyListView(mPopDatas,mContext);
                popListView.setAdapter(mAdapter);
                //在下方显示
                popupWindow.showAsDropDown(relativeLayout);
                popLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
        return view;
    }
    /**
     * 设置Tab标题
     */
    private void setupTitleDatas() {
        mTitleDatas.add("推荐");
        mTitleDatas.add("销量");
        mTitleDatas.add("价格");
        mTitleDatas.add("折扣");
        mTitleDatas.add("最新");

        mPopDatas.add("全部");
        mPopDatas.add("女装");
        mPopDatas.add("男装");
        mPopDatas.add("母婴");
        mPopDatas.add("美食");
        mPopDatas.add("美妆");
        mPopDatas.add("鞋包");
        mPopDatas.add("数码");
        mPopDatas.add("家居");
        mPopDatas.add("文本");
        mPopDatas.add("配饰");
        mPopDatas.add("中老年");
    }
    /**
     * 设置添加Fragment
     */
    private void setupData() {
        fragments.add(RecommendFragment.newInstance());
        fragments.add(SellCountFragment.newInstance());
        fragments.add(PriceFragment.newInstance());
        fragments.add(RebateFragment.newInstance());
        fragments.add(NewestFragment.newInstance());
    }
    /**
     * 初始化视图
     */
    private void initView() {
        //TabLayout
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_free_post);
        //ViewPager
        mViewPager = (ViewPager) view.findViewById(R.id.vp_free_post);
        //初始化相对布局
        relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_title);
        //初始化标题的按钮
        mImageView = (ImageView) view.findViewById(R.id.iv_recommend_title);
    }
    /**
     * 创建适配器
     */
    class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * 获取Fragment的位置
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
        /**
         * 获取Fragment的数量
         * @return
         */
        @Override
        public int getCount() {
            return fragments==null ? 0 : fragments.size();
        }
        /**
         * 获取Fragment的标题
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleDatas.get(position);
        }
    }
}
