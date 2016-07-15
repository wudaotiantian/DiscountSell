package androidas.com.discountsell.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.culiu.mhvp.core.MagicHeaderUtils;
import com.culiu.mhvp.core.MagicHeaderViewPager;
import com.culiu.mhvp.core.tabs.com.astuetz.PagerSlidingTabStrip;

import androidas.com.discountsell.R;
import androidas.com.discountsell.adapter.DemoPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    private MagicHeaderViewPager mMagicHeaderViewPager;
    //private DemoPagerAdapter mPagerAdapter;



    private Context mContext;
    private DemoPagerAdapter mPagerAdapter;


    public FirstFragment() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//           if (getArguments() != null) {
//                mParam2 = getArguments().getString(ARG_PARAM2);
//        }     mParam1 = getArguments().getString(ARG_PARAM1);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_first, container, false);

        mMagicHeaderViewPager = new MagicHeaderViewPager(getContext()) {
            @Override
            protected void initTabsArea(LinearLayout container) {
                ViewGroup tabsArea = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.layout_tabs1, null);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        MagicHeaderUtils.dp2px(getContext(), 52));
                container.addView(tabsArea, lp);
                PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) tabsArea.findViewById(R.id.tabs);
                pagerSlidingTabStrip.setTextColor(Color.BLACK);
                pagerSlidingTabStrip.setBackgroundColor(Color.WHITE);
pagerSlidingTabStrip.setAllCaps(true);
                int screenWidth = MagicHeaderUtils.getScreenWidth(getContext());
                int screenHeight = MagicHeaderUtils.getScreenHeight(getContext());
                pagerSlidingTabStrip.setTextSize(16);
                DisplayMetrics dm = getResources().getDisplayMetrics();
                double x = Math.pow(screenWidth/ dm.xdpi, 2);
                double y = Math.pow(screenHeight / dm.ydpi, 2);
                double screenInches = Math.sqrt(x + y);
                pagerSlidingTabStrip.setTextColorResource(R.color.tabcolor2);
                pagerSlidingTabStrip.setTabPaddingLeftRight((int)screenWidth/14);
                // TODO: These two methods must be called to let magicHeaderViewPager know who is stable area and tabs.
                setTabsArea(tabsArea);
                setPagerSlidingTabStrip(pagerSlidingTabStrip);


            }
        };
        Log.i("tag11", "onCreateView: "+mMagicHeaderViewPager);
        LinearLayout mhvpParent = (LinearLayout) view.findViewById(R.id.mhvp_parent);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        mhvpParent.addView(mMagicHeaderViewPager, lp);
        mPagerAdapter = new DemoPagerAdapter(getFragmentManager());

        //  TODO: Use this method instead of those of PagerSlidingTabStrip or ViewPager.
        mMagicHeaderViewPager.setPagerAdapter(mPagerAdapter);

        // call this if needed
        mMagicHeaderViewPager.setTabOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        // Then you can do anything like before:)

        // add your custom Header content
        initCustomHeader();

        return view;
    }

    private void initCustomHeader() {
        ImageView iv = new ImageView(getContext());
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
       // Drawable drawable = getResources().getDrawable(RandomPic.getInstance().getPicResId());
        //iv.setImageDrawable(R.drawable.background_tab);
        iv.setImageResource(R.drawable.upgrade_1);
        int height = MagicHeaderUtils.getScreenHeight(getContext());
        int hihi = height/5;
        mMagicHeaderViewPager.addHeaderView(iv, hihi);

    }


}
