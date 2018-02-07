package com.sequoia.vehicle.rental.adapter.order;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.ui.recycler.RecyclerViewHolder;

import java.util.List;

import butterknife.BindView;

/**
 * @author Administrator.
 * @date 2018/2/5.
 * @funtion
 */

public class MortgageOrderAdapter extends BaseQuickAdapter<Integer, RecyclerViewHolder> {


    private int tag = 0;
    public MortgageOrderAdapter(@LayoutRes int layoutResId, @Nullable List<Integer> data,int tag) {
        super(layoutResId, data);
        this.tag = tag;
    }

    @Override
    protected void convert(RecyclerViewHolder helper, Integer item) {
        final AppCompatImageView ivOrder = helper.getView(R.id.iv_order);
        final TextView mTvOrderNumber = helper.getView(R.id.tv_order_number);
        final TextView mTvCarName = helper.getView(R.id.tv_car_name);
        final TextView mTvCarDesc = helper.getView(R.id.tv_car_desc);


        mTvOrderNumber.setText(String.format("订单标号：%d", 54564664));
        mTvCarName.setText(String.format("%s", "保时捷"));
        mTvCarDesc.setText(String.format("%s万km | %sT%s | %d", "2.2", "3.0", "自动", 2016));

        helper.addOnClickListener(R.id.tv_delete);
        helper.addOnClickListener(R.id.tv_cancel);
        helper.addOnClickListener(R.id.tv_edit);
        helper.addOnClickListener(R.id.tv_see_details);
        helper.addOnClickListener(R.id.tv_choose_auditor);
        helper.addOnClickListener(R.id.tv_confirm);
        helper.addOnClickListener(R.id.tv_repayment);

        switch (tag) {
            case 0:
                helper.setVisible(R.id.tv_cancel,true);
                helper.setVisible(R.id.tv_edit,true);
                break;
            case 1:
                helper.setVisible(R.id.tv_cancel,true);
                helper.setVisible(R.id.tv_choose_auditor,true);
                break;
            case 2:
                helper.setVisible(R.id.tv_confirm,true);
                break;
            case 3:
                helper.setVisible(R.id.tv_delete,true);
                helper.setVisible(R.id.tv_repayment,true);
                break;
            default:
                break;
        }
    }
}

