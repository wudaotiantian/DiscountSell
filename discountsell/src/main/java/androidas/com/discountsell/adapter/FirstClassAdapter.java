package androidas.com.discountsell.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidas.com.discountsell.R;
import androidas.com.discountsell.bean.FirstPageBean;
import androidas.com.discountsell.constants.UrlData;
import androidas.com.discountsell.httplibrary.IOKCallBack;
import androidas.com.discountsell.httplibrary.OkHttpTool;
import androidas.com.discountsell.model.FirstClassItem;

/**
 * 一级分类（即左侧菜单）的adapter
 * Created by hanj on 14-9-25.
 */
public class FirstClassAdapter extends BaseAdapter {
    private Context context;
    private List<FirstClassItem> list;
private List<FirstPageBean.DataBean.IndexTypeBean.ListBean> beanList = new ArrayList<>();



    public FirstClassAdapter(Context context, List<FirstClassItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {

        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.left_listview_item, null);
            holder = new ViewHolder();
holder.imageView = (ImageView) convertView.findViewById(R.id.pop_image);

            holder.nameTV = (TextView) convertView.findViewById(R.id.left_item_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //选中和没选中时，设置不同的颜色
        if (position == selectedPosition){
            convertView.setBackgroundResource(R.color.popup_right_bg);
            holder.nameTV.setTextColor(Color.parseColor("#ff9342"));
        }else{
            convertView.setBackgroundResource(R.drawable.selector_left_normal);
            holder.nameTV.setTextColor(Color.parseColor("#7e7e7e"));

        }
        OkHttpTool.newInstance().start(UrlData.FIRSTPAGE_URL).callback(new IOKCallBack() {
            @Override
            public void success(String result) {
                Gson gso = new Gson();
                FirstPageBean bean = gso.fromJson(result,FirstPageBean.class);
                beanList.addAll(bean.getData().getIndex_type().getList());
                Picasso.with(context).load(beanList.get(position).getApp_picurl()).into(holder.imageView);
            }
        });
        holder.nameTV.setText(list.get(position).getName());
        if (list.get(position).getSecondList() != null && list.get(position).getSecondList().size() > 0) {
            holder.nameTV.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_right, 0);
        } else {
            holder.nameTV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }

        return convertView;
    }

    private int selectedPosition = 0;

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    private class ViewHolder {
        TextView nameTV;
        ImageView imageView;
    }
}
