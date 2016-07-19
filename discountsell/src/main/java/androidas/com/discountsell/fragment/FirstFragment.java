package androidas.com.discountsell.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import androidas.com.discountsell.activity.JumpActivity;
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

private List<FirstPageBean.DataBean.IndexTypeBean.ListBean> gridList = new ArrayList<>();
    private HotAdapter hotAdapter;
    private String[] mImgIds;
    private LinearLayout mGallery;
private int i;
    public FirstFragment() {
        // Required empty public constructor
        //woejdhf
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
    @Override
    public void onStart() {
        super.onStart();
        //开始自动滚动
        headerViewHolder.convenientBanner.startTurning(2000);
    }

    @Override
    public void onStop() {
        super.onStop();
        //停止滚动
        headerViewHolder.convenientBanner.stopTurning();
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
        loadGridDatas();
 hotAdapter = new HotAdapter(gridList);
        headerViewHolder.gridView.setHorizontalSpacing(1);
        headerViewHolder.gridView.setVerticalSpacing(1);

headerViewHolder.gridView.setAdapter(hotAdapter);
        headerViewHolder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), JumpActivity.class);
                String title = gridList.get(i).getTitle();
                String id = gridList.get(i).getId();

                intent.putExtra("key",title);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        Log.i("tagada", "setupHeaderView: "+headerViewHolder.gridView);

mImgIds = new String[]{"夏季童装","新款女包","沙滩裤","牛仔短裤","风扇","雪纺衫","泳衣","凉席","防晒霜","遮阳帽","连衣裙","凉鞋","背心"};
        mGallery = (LinearLayout) customLayout.findViewById(R.id.id_gallery);

        for (int i = 0; i < mImgIds.length; i++)
        {

            View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_index_gallery_item,
                  mGallery, false);
//            ImageView img = (ImageView) view
//                    .findViewById(R.id.id_index_gallery_item_image);
//            img.setImageResource(mImgIds[i]);
//            TextView txt = (TextView) view
//                    .findViewById(R.id.id_index_gallery_item_text);
//            txt.setText("some info ");
            TextView textView = (TextView) view.findViewById(R.id.gallery_textview);
            textView.setText(mImgIds[i]);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),mImgIds[finalI],Toast.LENGTH_SHORT).show();



                }
            });
            mGallery.addView(view);

        }

        mMagicHeaderViewPager.addHeaderView(customLayout,screenHeight/3);

    }
    public String getNewNamble(double namble){
        String newNamble = null;
        String s = String.valueOf(namble);

        if(s.substring(s.indexOf(".")+1,s.indexOf(".")+2).equals("0")){
            Log.i("xxxx",""+s.indexOf("."));
            newNamble = s.substring(0,s.indexOf("."));
        }else {
            newNamble=s.substring(0,s.indexOf(".")+2);
        }
        return newNamble;
    }

    private void loadGridDatas() {
   OkHttpTool.newInstance().start(UrlData.FIRSTPAGE_URL+1).callback(new IOKCallBack() {
       @Override
       public void success(String result) {
           Gson gson = new Gson();
           FirstPageBean bean = gson.fromJson(result,FirstPageBean.class);
           gridList.addAll(bean.getData().getIndex_type().getList());
            FirstPageBean.DataBean.IndexTypeBean.ListBean newBean = new FirstPageBean.DataBean.IndexTypeBean.ListBean();
           newBean.setTitle("更多");
           newBean.setApp_picurl("http://imgsrc.baidu.com/forum/w%3D580/sign=d032268e0246f21fc9345e5bc6256b31/bd034f4a20a446230e0fcd179022720e0df3d79b.jpg");
           gridList.add(newBean);
           hotAdapter.notifyDataSetChanged();
       }
   });



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

//
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
    //创建ViewHolder
    class GridViewHolder  {
        public ImageView imageView;
        public TextView textView;
        public GridViewHolder(View itemView) {

            imageView = (ImageView) itemView.findViewById(R.id.grid_item_imageview);
            Log.i("tagitem", "getView:++++ "+imageView);

            textView= (TextView) itemView.findViewById(R.id.grid_item_textview);

        }
    }
    class HotAdapter extends BaseAdapter {
        private List<FirstPageBean.DataBean.IndexTypeBean.ListBean> itemsBeen;
        //private Context context;

        public HotAdapter(List<FirstPageBean.DataBean.IndexTypeBean.ListBean> itemsBeen) {
            this.itemsBeen = itemsBeen;
            //this.context = context;
        }

        @Override
        public int getCount() {
            return itemsBeen == null ? 0 : itemsBeen.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            GridViewHolder viewHodler = null;
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.gridview_image_text_item, parent,false);
                //ImageView imageview = (ImageView) view.findViewById(R.id.grid_item_imageview);
               // Log.i("tagitem", "getView: "+imageview);


                viewHodler = new GridViewHolder(view);
                view.setTag(viewHodler);
            } else {
                viewHodler = (GridViewHolder) view.getTag();
            }
//            if(position==(getCount()-1)){
//                viewHodler.textView.setText("更多");
//                viewHodler.imageView.setImageResource(R.drawable.icon_more);
//            }
          //  if(position<=itemsBeen.size()) {
               // Log.i("tagee", "getView: "+position+""+itemsBeen.size());
                FirstPageBean.DataBean.IndexTypeBean.ListBean items0 = itemsBeen.get(position);
                Log.i("tagpo", "getView: "+position);
                viewHodler.textView.setText(items0.getTitle());
                Log.i("tagee", "getView: "+itemsBeen.size());

                Glide.with(getContext()).load(items0.getApp_picurl()).into(viewHodler.imageView);


//            FirstPageBean.DataBean.IndexTypeBean.ListBean items7 = itemsBeen.get(7);
//            // Log.i("tagitem", "getView: "+items.getTitle());
//            viewHodler.textView.setText(items7.getTitle());
//            Log.i("tagee", "getView: "+itemsBeen.size());
//
//            Glide.with(getContext()).load(items7.getApp_picurl()).into(viewHodler.imageView);


//            }else{
//                viewHodler.textView.setText("更多");
//                viewHodler.imageView.setImageResource(R.drawable.icon_more);
//
//            }
//
//
// Hot.DataBean.ItemsBean items = itemsBeen.get(position);
//            viewHodler.description.setText(items.getData().getName());
//            String url = items.getData().getCover_image_url();
//            Picasso.with(context).load(url).into(viewHodler.iv);
            return view;
        }


    }  }