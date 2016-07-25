package androidas.com.discountsell.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidas.com.discountsell.R;
import androidas.com.discountsell.bean.SearchBean;

/**
 * Created by Administrator on 2016/6/24.
 */
public class SearchAdapter extends BaseAdapter{
    private List<SearchBean.RowsBean> list = null;
    private Context context = null;
    private LayoutInflater inflater;
    public SearchAdapter(List<SearchBean.RowsBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderEvent viewHolderEvent = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.listview_search2_item,parent,false);
            viewHolderEvent  = new ViewHolderEvent();
            viewHolderEvent.tv1 = (TextView) convertView.findViewById(R.id.title_search);

            viewHolderEvent.tv2 = (TextView) convertView.findViewById(R.id.yuanjia_text);
            viewHolderEvent.tv3 = (TextView) convertView.findViewById(R.id.xianjia_text);

            //viewHolderEvent.tv4 = (TextView) convertView.findViewById(R.id.li_6);
            ViewHolderEvent.imageView = (ImageView) convertView.findViewById(R.id.search_image);


            convertView.setTag(viewHolderEvent);
        }else{
            viewHolderEvent = (ViewHolderEvent) convertView.getTag();
        }
        SearchBean.RowsBean e = list.get(position);

        viewHolderEvent.tv1.setText(e.getName());
        viewHolderEvent.tv2.setText(e.getOldPrice()+"");
        viewHolderEvent.tv3.setText(e.getNewPrice()+"");
        Picasso.with(context).load(e.getProductImg()).into(ViewHolderEvent.imageView);



        return convertView;
    }
    static class ViewHolderEvent{
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        //  TextView tv4;
        static ImageView imageView;


    }
}
