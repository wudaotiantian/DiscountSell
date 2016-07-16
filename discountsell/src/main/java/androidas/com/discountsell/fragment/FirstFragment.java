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
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.culiu.mhvp.core.MagicHeaderUtils;
import com.culiu.mhvp.core.MagicHeaderViewPager;
import com.culiu.mhvp.core.tabs.com.astuetz.PagerSlidingTabStrip;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidas.com.discountsell.R;
import androidas.com.discountsell.adapter.DemoPagerAdapter;
import androidas.com.discountsell.bean.FirstPageBean;
import androidas.com.discountsell.constants.UrlData;
import androidas.com.discountsell.httplibrary.IOKCallBack;
import androidas.com.discountsell.httplibrary.OkHttpTool;

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


private List<FirstPageBean.DataBean.IndexBannerBean.ListBean> imageDatas = new ArrayList<>();
    private Context mContext;
    private DemoPagerAdapter mPagerAdapter;
    private View customLayout;
    private HeaderViewHolder headerViewHolder;


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
//pagerSlidingTabStrip.setAllCaps(true);
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
        setupHeaderView();

        return view;
    }

    private void  setupHeaderView() {
//        ImageView iv = new ImageView(getContext());
//        iv.setScaleType(ImageView.ScaleType.FIT_XY);
//       // Drawable drawable = getResources().getDrawable(RandomPic.getInstance().getPicResId());
//        //iv.setImageDrawable(R.drawable.background_tab);
//        iv.setImageResource(R.drawable.upgrade_1);
//        int height = MagicHeaderUtils.getScreenHeight(getContext());
//        int hihi = height/5;
//        mMagicHeaderViewPager.addHeaderView(iv, hihi);

        customLayout = LayoutInflater.from(getContext()).inflate(R.layout.wellchosen_header_view, null);
        headerViewHolder = new HeaderViewHolder(customLayout);
        int screenHeight = MagicHeaderUtils.getScreenHeight(getContext());
        //customLayout.setMinimumHeight(1/3);
        loadBannerDatas();//动态加载数据
        setupBanner(headerViewHolder);



        mMagicHeaderViewPager.addHeaderView(customLayout,screenHeight);

    }
    class HeaderViewHolder {

        //@BindView(R.id.header_view_rv)
        HorizontalScrollView horizontalScrollView;
        //@BindView(R.id.header_view_cb)
        ConvenientBanner convenientBanner;
GridView gridView;
        public HeaderViewHolder(View headerView) {
           // ButterKnife.bind(this,headerView);
            convenientBanner = (ConvenientBanner) headerView.findViewById(R.id.header_view_cb);
             gridView = (GridView) headerView.findViewById(R.id.header_view_gv);
            horizontalScrollView = (HorizontalScrollView) headerView.findViewById(R.id.header_view_rv);
        }
    }
    private void loadBannerDatas() {
//        HttpUtil.requestGet(ApiConstants.BANNER_URL, new IRequestCallBack() {
//            @Override
//            public void onSuccess(String result) {
//                Gson gson = new Gson();
//                BannerInfo bannerInfo = gson.fromJson(result, BannerInfo.class);
//                if(imageDatas!=null&&!imageDatas.isEmpty()){
//                    return;
//                }
//                imageDatas.addAll(bannerInfo.getData().getBanners());
//                headerViewHolder.convenientBanner.getViewPager().getAdapter().notifyDataSetChanged();
//                setupBanner(headerViewHolder);
//                headerViewHolder.convenientBanner.setOnItemClickListener(new OnItemClickListener() {
//                    @Override
//                    public void onItemClick(int position) {
//                        Intent intent = new Intent(mContext, BannerActivity.class);
//                        intent.putExtra("id",imageDatas.get(position).getTarget_id());
//                        intent.putExtra("title",imageDatas.get(position).getTarget().getTitle());
//                        startActivity(intent);
//                    }
//                });
//            }
//        });
        OkHttpTool.newInstance().start(UrlData.FIRSTPAGE_URL+1).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gson = new Gson();
                FirstPageBean pageBean = gson.fromJson(result, FirstPageBean.class);
                if (imageDatas != null && !imageDatas.isEmpty()) {
                    return;
                }
                imageDatas.addAll(pageBean.getData().getIndex_banner().getList());
                headerViewHolder.convenientBanner.getViewPager().getAdapter().notifyDataSetChanged();
                setupBanner(headerViewHolder);
                headerViewHolder.convenientBanner.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(getContext(), "nihao", Toast.LENGTH_SHORT).show();
                    }
//                        Intent intent = new Intent(mContext, BannerActivity.class);
//                        intent.putExtra("id",imageDatas.get(position).getTarget_id());
//                        intent.putExtra("title",imageDatas.get(position).getTarget().getTitle());
//                        startActivity(intent);


                });

            }
        });}
            private void setupBanner(HeaderViewHolder headerViewHolder) {

                headerViewHolder.convenientBanner.setPages(new CBViewHolderCreator<HeaderBannerViewHolder>() {
                    @Override
                    public HeaderBannerViewHolder createHolder() {
                        return new HeaderBannerViewHolder();
                    }
                }, imageDatas)
                        .setPointViewVisible(true);
                //.setPageIndicator(new int[]{R.drawable.btn_check_disabled_nightmode,R.drawable.btn_check_normal})
                //.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);


            }

            class HeaderBannerViewHolder implements Holder<FirstPageBean.DataBean.IndexBannerBean.ListBean> {
                ImageView imageView;

                @Override
                public View createView(Context context) {
                    imageView = new ImageView(context);

//            View view = LayoutInflater.from(context).inflate(R.layout.banner_image,layout,true);
//
//            imageView = (ImageView) view.findViewById(R.id.banner_image);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return imageView;
                }

                @Override
                public void UpdateUI(Context context, int position, FirstPageBean.DataBean.IndexBannerBean.ListBean data) {
//            imageView.setImageResource(data.getImage_url());
                    Glide.with(getContext()).load(data.getApp_subject_indexpic()).into(imageView);
                }
            }


        }