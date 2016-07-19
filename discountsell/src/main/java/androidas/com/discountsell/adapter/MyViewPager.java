package androidas.com.discountsell.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by xwb on 2016/7/16.
 */
public class MyViewPager extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    public MyViewPager(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments ==null? 0:fragments.size();
    }

}
