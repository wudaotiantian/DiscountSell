package androidas.com.discountsell.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidas.com.discountsell.R;

/**
 * Created by xwb on 2016/7/13.
 */
public class HeaderAdapterV extends BaseAdapter {

    private List<String> mTitle=new ArrayList<>();
    private Context mContext;
    private LayoutInflater layoutInflater;

    public HeaderAdapterV(Context mContext, List<String> mTitle) {
        this.mContext = mContext;
        this.mTitle = mTitle;
        layoutInflater=LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return mTitle.size();
    }

    @Override
    public Object getItem(int i) {
        return mTitle.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=layoutInflater.inflate(R.layout.four_header_grid,viewGroup,false);
        TextView textView= (TextView) view.findViewById(R.id.tv_four_header_grid);
        textView.setText(mTitle.get(i));
        return view;
    }
}

