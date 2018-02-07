package com.sequoia.vehicle.rental.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sequoia.vehicle.rental.ui.recycler.RecyclerViewHolder;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/2/7.
 * @funtion
 */

public class AuditorAdapter extends BaseQuickAdapter<Integer,RecyclerViewHolder> {

    public AuditorAdapter(@LayoutRes int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(RecyclerViewHolder helper, Integer item) {

    }
}
