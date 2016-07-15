package androidas.com.discountsell.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.culiu.mhvp.core.InnerScrollerContainer;
import com.culiu.mhvp.core.OuterPagerAdapter;
import com.culiu.mhvp.core.OuterScroller;

import androidas.com.discountsell.fragment.Blank1Fragment;
import androidas.com.discountsell.fragment.Blank2Fragment;
import androidas.com.discountsell.fragment.Blank3Fragment;
import androidas.com.discountsell.fragment.Blank4Fragment;
import androidas.com.discountsell.fragment.Blank5Fragment;

/**
 * @author Xavier-S
 * @date 2015.10.08 20:33
 */
public class DemoPagerAdapter extends FragmentPagerAdapter implements OuterPagerAdapter{
    private Blank1Fragment fragment1;
    private Blank2Fragment fragment2;
    private Blank3Fragment fragment3;
    private Blank4Fragment fragment4;
    private Blank5Fragment fragment5;
    /****    OuterPagerAdapter methods   ****/
    private OuterScroller mOuterScroller;

    @Override
    public void setOuterScroller(OuterScroller outerScroller) {
        mOuterScroller = outerScroller;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO: Make sure to put codes below in your PagerAdapter's instantiateItem()
        // cuz Fragment has some weird life cycle.
        InnerScrollerContainer fragment =
                (InnerScrollerContainer) super.instantiateItem(container, position);

        if (null != mOuterScroller) {
            fragment.setOuterScroller(mOuterScroller, position);
        }
        return fragment;
    }
    /****  OuterPagerAdapter methods End   ****/


    /************************ Test data *********************/
    public DemoPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    protected CharSequence[] mTitles = {"推荐", "销量", "价格", "折扣", "最新"/*, "page 5", "page 6"*/};

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public final Fragment getItem(int position) {
        if (position == 1) {
            return new Blank2Fragment();
        } else if (position == 2) {
            return new Blank3Fragment();
        }else if (position==3){
            return new Blank4Fragment();
        }else if (position==4){
            return new Blank5Fragment();
        }
        return new Blank1Fragment();

    }


    }



