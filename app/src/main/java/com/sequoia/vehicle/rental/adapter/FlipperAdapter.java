package com.sequoia.vehicle.rental.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sequoia.vehicle.rental.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/1/18.
 * @funtion
 */

public class FlipperAdapter extends BaseAdapter {

    private Context mContext = null;
    private LayoutInflater mInflater = null;
    private List<String> mList = null;


    public FlipperAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FlipperViewHolder holder = null;
        if (convertView == null) {
            holder = new FlipperViewHolder();
            convertView = mInflater.inflate(R.layout.adapter_view_flipper_item, parent, false);
            holder.tv = convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        //对于listview，注意添加这一行，即可在item上使用高度
//            AutoUtils.autoSize(convertView);
        } else {
            holder = (FlipperViewHolder) convertView.getTag();
        }
        holder.tv.setText(mList.get(position));
        return convertView;
    }

    private class FlipperViewHolder {
        TextView tv;
    }
}
