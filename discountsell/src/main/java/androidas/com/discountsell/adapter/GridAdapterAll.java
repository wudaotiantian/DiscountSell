package androidas.com.discountsell.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
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
import androidas.com.discountsell.bean.BeadGridAll;
import androidas.com.discountsell.bean.BeadTitle;

/**
 * Created by xwb on 2016/7/16.
 */
public class GridAdapterAll extends BaseAdapter {
    private List<BeadGridAll.DataBean.ListBean> itemDatas =new ArrayList<>();
    private Context mContext;
    private LayoutInflater layoutInflater;
    public GridAdapterAll(List<BeadGridAll.DataBean.ListBean> itemDatas, Context mContext) {
        this.itemDatas = itemDatas;
        this.mContext = mContext;
        layoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return itemDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return itemDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=layoutInflater.inflate(R.layout.four__click_gridview,viewGroup,false);
        ImageView imageView= (ImageView) view.findViewById(R.id.iv_four_click_grid);
        TextView textTitle= (TextView) view.findViewById(R.id.tv_four_click_grid_title);
        TextView textPorm= (TextView) view.findViewById(R.id.tv_four_click_grid_prom);
        TextView textPrice= (TextView) view.findViewById(R.id.tv_four_click_grid_price);
        TextView textTiao= (TextView) view.findViewById(R.id.tv_four_click_grid_tianmao);
        TextView textIntegal= (TextView) view.findViewById(R.id.tv_four_click_grid_integral);


        textPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        textTitle.setText("[包邮] "+itemDatas.get(i).getTitle());
        textPorm.setText("¥"+getNewNamble(itemDatas.get(i).getPromotion_price()));
        textPrice.setText("¥"+getNewNamble(itemDatas.get(i).getPrice()));
        textTiao.setText(itemDatas.get(i).getSite());

textIntegal.setText("送"+itemDatas.get(i).getCommission_cent()+"集分包");
        Glide.with(mContext).load(itemDatas.get(i).getPic()).into(imageView);
        return view;
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

