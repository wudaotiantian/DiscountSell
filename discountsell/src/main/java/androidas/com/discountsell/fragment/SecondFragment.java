package androidas.com.discountsell.fragment;
import android.content.Context;
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
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidas.com.discountsell.R;

/**
 * 9.9包邮界面
 */
public class SecondFragment extends Fragment {
    private View view;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> fragments=new ArrayList<>();//Fragment集合
    private List<String> mTitleDatas=new ArrayList<>();//Tab标题集合
    private MyFragmentPagerAdapter mFragmentPagerAdapter;
    private ImageView mImageView;
    private Context mContext;
    private PopupWindow popupWindow;
    private RelativeLayout relativeLayout;
    //popupWindow里面的数据
    Map<String,List<String>>map=new HashMap<>();
    List<String>allList=new ArrayList<>();//全部item
    List<String>nvzhuangList=new ArrayList<>();//女装item
    List<String>nanzhuangList=new ArrayList<>();//男装item
    List<String>muyingList=new ArrayList<>();//母婴item
    List<String>meishiList=new ArrayList<>();//美食item
    List<String>meizhuangList=new ArrayList<>();//美妆item
    List<String>xiebaoList=new ArrayList<>();//鞋包item
    List<String>shumaList=new ArrayList<>();//数码item
    List<String>jiajuList=new ArrayList<>();//家居item
    List<String>wenbenList=new ArrayList<>();//文本item
    List<String>peishiList=new ArrayList<>();//配饰item
    List<String>zhonglaonianList=new ArrayList<>();//中老年item
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
                popupWindow = new PopupWindow(mContext);
                //填充内容
                popupWindow.setContentView(contentView);
                //在下方显示
                popupWindow.showAsDropDown(relativeLayout);
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
        //往popupWindow里面的List填充值
        map.put("全部",allList);
        map.put("女装",nvzhuangList);
        map.put("",nanzhuangList);
        map.put("全部",muyingList);
        map.put("全部",meishiList);
        map.put("全部",meizhuangList);
        map.put("全部",xiebaoList);
        map.put("全部",shumaList);
        map.put("全部",jiajuList);
        map.put("全部",wenbenList);
        map.put("全部",allList);
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
