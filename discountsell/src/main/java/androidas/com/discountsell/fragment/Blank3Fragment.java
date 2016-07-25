package androidas.com.discountsell.fragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.culiu.mhvp.core.MagicHeaderUtils;
import com.culiu.mhvp.core.tabs.GridViewWithHeaderBaseAdapter;

import java.util.ArrayList;

import androidas.com.discountsell.R;
import androidas.com.discountsell.bean.FirstPageBean;

/**
 * //A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Blank3Fragment extends ListFragment {
    public Blank3Fragment() {
        // Required empty public constructor
    }

    protected void initAdapter() {
        if (mListSomes == null) {
            mListSomes = new ArrayList<>();
        }
        mAdapter = new GridViewWithHeaderBaseAdapter(getActivity()) {
            @Override
            protected void setPaddingAndMargin(View leftView, View rightView, int culumn) {
                super.setPaddingAndMargin(leftView, rightView, culumn);
                int _5dp = MagicHeaderUtils.dp2px(getActivity(), 15f);
                leftView.setPadding(_5dp, 0, _5dp / 2, 0);
                rightView.setPadding(_5dp / 2, 0, _5dp, 0);
            }

            @Override
            public int getItemCount() {
                return mListSomes.size();

            }

            @Override
            protected View getItemView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getActivity()).inflate(R.layout.blank1_fragment_item, null);
                }
                Log.i("tag2", "success: "+mListSomes);

                ImageView iv = (ImageView) convertView.findViewById(R.id.blak1_fragment_imageview);
                TextView tv1 = (TextView) convertView.findViewById(R.id.blank1_fragment_title_textview);
                TextView tv2 = (TextView) convertView.findViewById(R.id.blank1_fragment_price_textview);
                TextView tv3 = (TextView) convertView.findViewById(R.id.small_price_line_textview);
                TextView tv4 = (TextView) convertView.findViewById(R.id.blank1_fragment_tianmao_taobao_textview);
                TextView tv5 = (TextView) convertView.findViewById(R.id.provide_math_textview);
                RelativeLayout relativeLayout = (RelativeLayout) convertView.findViewById(R.id.paixia_relativelayout);
                ImageView iv2 = (ImageView) convertView.findViewById(R.id.icon_taobao_tianmao_imageview);
                View line = (View)convertView.findViewById(R.id.small_price_line);
                tv1.setText(mListSomes.get(position).getTitle());
                tv2.setText(getNewNamble(mListSomes.get(position).getPromotion_price())+"");
                tv3.setText(getNewNamble(mListSomes.get(position).getPrice())+"");
                tv5.setText(mListSomes.get(position).getCommission_cent()+"");
                if(mListSomes.get(position).getApp_isrec().equals("1")){
                    relativeLayout.setVisibility(View.VISIBLE);
                    line.setVisibility(View.GONE);
                }
                Glide.with(getContext()).load(mListSomes.get(position).getPic()).into(iv);
                if(mListSomes.get(position).getSite().equals("天猫")){
                    tv4.setText("天猫");
                    iv2.setImageResource(R.drawable.icon_tianmao);
                }else{
                    tv4.setText("淘宝");
                    iv2.setImageResource(R.drawable.icon_taobao);
                }
//                TextView tv = (TextView) convertView.findViewById(R.id.tv);
//                iv.setImageResource(getItem(position).getDrawableResId());
//                tv.setText(getItem(position).getTitle());
                return convertView;
            }

            @Override
            public FirstPageBean.DataBean.IndexHomeBean.ListBean getItem(int position) {
                return mListSomes.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }
        };
        ((GridViewWithHeaderBaseAdapter) mAdapter).setNumColumns(2);
        mListView.setAdapter(mAdapter);
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


}
