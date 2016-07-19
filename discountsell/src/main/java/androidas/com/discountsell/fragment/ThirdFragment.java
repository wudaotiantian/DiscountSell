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
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import androidas.com.discountsell.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {
    private View view;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> fragments=new ArrayList<>();//Fragment集合
    private List<String> mTitleDatas=new ArrayList<>();//Tab标题集合
    private MyFragmentPagerAdapter mFragmentPagerAdapter;
    private Context mContext;
    //单例
    public static ThirdFragment newInstance() {
        ThirdFragment fragment = new ThirdFragment();
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
        view = inflater.inflate(R.layout.fragment_third,container,false);
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
        return view;
    }

    /**
     * 设置标题
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
        fragments.add(RecommendFragment2.newInstance());
        fragments.add(SellCountFragment2.newInstance());
        fragments.add(PriceFragment2.newInstance());
        fragments.add(RebateFragment2.newInstance());
        fragments.add(NewestFragment2.newInstance());
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
        //relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_title);
        //初始化标题的按钮
        //mImageView = (ImageView) view.findViewById(R.id.iv_recommend_title);
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
