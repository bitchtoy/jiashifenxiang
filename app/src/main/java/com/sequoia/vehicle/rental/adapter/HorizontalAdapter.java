package com.sequoia.vehicle.rental.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.entities.HorizontalBean;
import com.sequoia.vehicle.rental.ui.recycler.RecyclerViewHolder;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/1/19.
 * @funtion
 */

public class HorizontalAdapter extends BaseQuickAdapter<HorizontalBean, RecyclerViewHolder> {

    public HorizontalAdapter(@LayoutRes int layoutResId, @Nullable List<HorizontalBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(RecyclerViewHolder helper, HorizontalBean item) {
        if (item.tag == 0) {
            helper.setText(R.id.rent, item.rent);
            helper.setText(R.id.address, item.address);
        } else {
            helper.setText(R.id.rent, item.totalMoney);
            helper.setText(R.id.address, item.totalRent);
        }
    }
}
