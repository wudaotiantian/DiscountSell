package androidas.com.discountsell.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/7/18.
 */
public class GridFragmentAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] mContents;


    public GridFragmentAdapter(FragmentManager fm,Context mContext,String[] mContents) {
        super(fm);
        this.mContents = mContents;
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContents[position];
    }
}
