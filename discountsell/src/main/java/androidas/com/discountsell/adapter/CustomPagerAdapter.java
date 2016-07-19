package androidas.com.discountsell.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/19.
 */
public class CustomPagerAdapter extends PagerAdapter {
    private ArrayList<View> mViewList;
    private ArrayList<String>mTabList;
    public CustomPagerAdapter(ArrayList<View>viewList,ArrayList<String>tabList)
    {
        this.mTabList = tabList;
        this.mViewList = viewList;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.remove(position));
    }


    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabList.get(position);
    }
}
