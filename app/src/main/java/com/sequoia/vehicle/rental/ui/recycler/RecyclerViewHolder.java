package com.sequoia.vehicle.rental.ui.recycler;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 傅令杰
 *
 * @author Administrator
 */

public class RecyclerViewHolder extends BaseViewHolder {

    private RecyclerViewHolder(View view) {
        super(view);
        AutoUtils.auto(view);
    }

    public static RecyclerViewHolder create(View view) {
        return new RecyclerViewHolder(view);
    }
}
