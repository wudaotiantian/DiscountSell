package androidas.com.discountsell.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidas.com.discountsell.R;

/**
 * Created by xwb on 2016/7/22.
 */
public class MyListView extends BaseAdapter {
    private int[]image={R.drawable.icon_withdraw_centcount,R.drawable.icon_withdraw_centcount,
            R.drawable.icon_withdraw_centcount,R.drawable.icon_withdraw_centcount,
            R.drawable.icon_withdraw_centcount,R.drawable.icon_withdraw_centcount,
            R.drawable.icon_withdraw_centcount,R.drawable.icon_withdraw_centcount,
            R.drawable.icon_withdraw_centcount,R.drawable.icon_withdraw_centcount,
            R.drawable.icon_withdraw_centcount,R.drawable.icon_withdraw_centcount,
            R.drawable.icon_withdraw_centcount,R.drawable.icon_withdraw_centcount,
            R.drawable.icon_withdraw_centcount,R.drawable.icon_withdraw_centcount,};
    private List<String> list= new ArrayList<>();
    private Context mContext;
    private LayoutInflater  layoutInflater;
    private ImageView imageView;
    private TextView textView;

    public MyListView(List<String> list,Context mContext) {
        this.list = list;
        layoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View contextView= layoutInflater.inflate(R.layout.layout_four_list,viewGroup,false);
        imageView= (ImageView) contextView.findViewById(R.id.iv_layout_four_list);
        textView= (TextView) contextView.findViewById(R.id.tv_layout_four_list);
        imageView.setImageResource(image[i]);
        textView.setText(list.get(i));
        return contextView;
    }
}
