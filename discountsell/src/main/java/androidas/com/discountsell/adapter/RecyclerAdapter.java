package androidas.com.discountsell.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidas.com.discountsell.FourClick;
import androidas.com.discountsell.FourGridActivity;
import androidas.com.discountsell.MainActivity;
import androidas.com.discountsell.R;
import androidas.com.discountsell.bean.BeanSale;
import androidas.com.discountsell.canstant.MyGridView;
import androidas.com.discountsell.fragment.FourFragment;

/**
 * Created by xwb on 2016/7/12.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public TextView textTitle;
    public TextView textDiscount;
    public TextView textNumble;
    public TextView textTime;
    public ImageView imageTitle;
    public ImageView imageLeft;
    public ImageView imageContent;
    public ImageView imageRight;
    public Context mContext;
    private BeanSale mBeanSale;
    private List<BeanSale.DataBean.ListBeanV> items=new ArrayList<>();
    private List<String> mTitle=new ArrayList<>();
    public static final int HEADER_VIEW = 0;
    public int numl=0;
    public RecyclerAdapter( List<BeanSale.DataBean.ListBeanV> items, Context mContext, List<String> mTitle) {
        this.items = items;
        this.mContext = mContext;
        this.mTitle=mTitle;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return HEADER_VIEW;
        }
        return position;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==HEADER_VIEW){
            View view=LayoutInflater.from(mContext).inflate(R.layout.four_header_item,parent,false);
            return new MyViewHolder(view);
        }

        View view=LayoutInflater.from(mContext).inflate(R.layout.four_fangment_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(position==HEADER_VIEW){
            HeaderAdapterV headerAdapterV=new HeaderAdapterV(mContext,mTitle);
            holder.myGridView.setAdapter(headerAdapterV);
            return;
        }
        Glide.with(mContext).load(items.get(position-1).getBrand_logo()).into(holder.imageTitle);
        Glide.with(mContext).load(items.get(position-1).getGoods_list().getList().get(0).getPic()).into(holder.imageLeft);
        Glide.with(mContext).load(items.get(position-1).getGoods_list().getList().get(1).getPic()).into(holder.imageContent);
        Glide.with(mContext).load(items.get(position-1).getGoods_list().getList().get(2).getPic()).into(holder.imageRight);
        holder.textTitle.setText(items.get(position-1).getTitle());
        holder.textDiscount.setText(items.get(position-1).getBrand_discount()+"特价");
        holder.textNumble.setText("共"+items.get(position-1).getTotal()+"款");
        holder.textTime.setText(items.get(position-1).getBrand_end_time());


        holder.textLeftPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.textCenterPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.textRightPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.textLeftaProm.setText("¥"+getNewNamble(items.get(position-1).getGoods_list().getList().get(0).getPromotion_price()));
        holder.textLeftPrice.setText("¥"+getNewNamble(items.get(position-1).getGoods_list().getList().get(0).getPrice()));
        holder.textCenterProm.setText("¥"+getNewNamble(items.get(position-1).getGoods_list().getList().get(1).getPromotion_price()));
        holder.textCenterPrice.setText("¥"+getNewNamble(items.get(position-1).getGoods_list().getList().get(1).getPrice()));
        holder.textRightProm.setText("¥"+getNewNamble(items.get(position-1).getGoods_list().getList().get(2).getPromotion_price()));
        holder.textRightPrice.setText("¥"+getNewNamble(items.get(position-1).getGoods_list().getList().get(2).getPrice()));
        getClick(holder.imageLeft,position-1,numl=1);
        getClick(holder.imageContent,position-1,numl=2);
        getClick(holder.imageRight,position-1,numl=3);
        getClick(holder.linearLayoutTitle,position-1,numl=4);
        getClick(holder.linearLayoutBottom,position-1,numl=5);

    }
    public void getClick(View view, final int num,final int numl){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Intent mIntent=new Intent(mContext, FourGridActivity.class);
                mIntent.putExtra("myTitle",items.get(num).getTitle());
                mIntent.putExtra("myTid",items.get(num).getTid());

                switch (numl){
                    case 1:

                        intent.setData(Uri.parse(items.get(num).getGoods_list().getList().get(0).getPro_url()));
                        mContext.startActivity(intent);
                        break;
                    case 2:
                        intent.setData(Uri.parse(items.get(num).getGoods_list().getList().get(1).getPro_url()));
                        mContext.startActivity(intent);
                        break;
                    case 3:

                        intent.setData(Uri.parse(items.get(num).getGoods_list().getList().get(2).getPro_url()));
                        mContext.startActivity(intent);
                        break;
                    case 4:
                        mContext.startActivity(mIntent);

                        break;
                    case 5:

                        mContext.startActivity(mIntent);
                        break;
                    default:
                        break;

                }
            }
        });
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

    @Override
    public int getItemCount() {

        return items.size()+1;
    }
}
class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textTitle;
    public TextView textDiscount;
    public TextView textNumble;
    public TextView textTime;
    public ImageView imageTitle;
    public ImageView imageLeft;
    public ImageView imageContent;
    public ImageView imageRight;
    public LinearLayout linearLayoutTitle;
    public LinearLayout linearLayoutBottom;
    public MyGridView myGridView;
    public TextView textLeftPrice;
    public TextView textLeftaProm;
    public TextView textCenterPrice;
    public TextView textCenterProm;
    public TextView textRightPrice;
    public TextView textRightProm;

    public MyViewHolder(View itemView) {
        super(itemView);
        textTitle= (TextView) itemView.findViewById(R.id.tv_four_item_title);
        textDiscount= (TextView) itemView.findViewById(R.id.tv_four_item_discount);
        textNumble= (TextView) itemView.findViewById(R.id.tv_four_item_numble);
        textTime= (TextView) itemView.findViewById(R.id.tv_four_item_time);
        imageTitle=(ImageView) itemView.findViewById(R.id.iv_four_item_title);
        imageLeft=(ImageView) itemView.findViewById(R.id.iv_four_item_left);
        imageContent= (ImageView) itemView.findViewById(R.id.iv_four_item_center);
        imageRight= (ImageView) itemView.findViewById(R.id.iv_four_item_right);
        linearLayoutTitle= (LinearLayout) itemView.findViewById(R.id.ll_four_item_title);
        linearLayoutBottom= (LinearLayout) itemView.findViewById(R.id.ll_four_item_bottom);
        myGridView= (MyGridView) itemView.findViewById(R.id.gv_four_header);
        textLeftaProm= (TextView) itemView.findViewById(R.id.tv_four_item_left_prom);
        textLeftPrice= (TextView) itemView.findViewById(R.id.tv_four_item_left_price);
        textCenterProm= (TextView) itemView.findViewById(R.id.tv_four_item_center_prom);
        textCenterPrice= (TextView) itemView.findViewById(R.id.tv_four_item_center_price);
        textRightProm= (TextView) itemView.findViewById(R.id.tv_four_item_right_prom);
        textRightPrice= (TextView) itemView.findViewById(R.id.tv_four_item_right_price);


    }


}

