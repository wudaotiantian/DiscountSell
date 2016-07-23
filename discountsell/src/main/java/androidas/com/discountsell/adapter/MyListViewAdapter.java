package androidas.com.discountsell.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidas.com.discountsell.R;
import androidas.com.discountsell.bean.RecommendInfo;

/**
 * Created by my on 2016/7/16.
 */
public class MyListViewAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater mInflater;
    private List<RecommendInfo.DataBean.ListBean> mData=new ArrayList<>();

    public MyListViewAdapter(Context context,List<RecommendInfo.DataBean.ListBean> data) {
        mInflater=LayoutInflater.from(context);
        this.mData = data;
        this.mContext=context;
    }

    @Override
    public int getCount() {
        return mData==null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        convertView = mInflater.inflate(R.layout.recommend_listview_item, viewGroup,false);
        //初始化Item里面的视图
        //商品图片
        ImageView productPic = (ImageView) convertView.findViewById(R.id.iv_recommend);
        //网络获取商品图片
        Glide.with(mContext).load(mData.get(position).getPic()).into(productPic);
        //商品名
        TextView productTitle = (TextView) convertView.findViewById(R.id.tv_recommend_baoyou);
        String title = mData.get(position).getTitle();
        productTitle.setText("[包邮]"+title);
        //商品现在的价格
        TextView productPromotionPrice = (TextView) convertView.findViewById(R.id.tv_recommend_now_price);
        double promotion_price = mData.get(position).getPromotion_price();
        productPromotionPrice.setText("¥"+promotion_price);
        //商品原来的价格
        TextView productPrice = (TextView) convertView.findViewById(R.id.tv_recommend_before_price);
        double price = mData.get(position).getPrice();
        productPrice.setText("¥"+price);
        //在TextView中间画线
        productPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        //商品的标签（天猫或淘宝）
        TextView productSite = (TextView) convertView.findViewById(R.id.tv_recommend_tianmao_or_taobao);
        String site = mData.get(position).getSite();
        productSite.setText(site);
        //商品送集分宝
        TextView productCommissionCent = (TextView) convertView.findViewById(R.id.tv_recommend_jifenbao);
        int commission_cent = mData.get(position).getCommission_cent();
        productCommissionCent.setText("送"+commission_cent+"集分宝");
        return convertView;
    }
}