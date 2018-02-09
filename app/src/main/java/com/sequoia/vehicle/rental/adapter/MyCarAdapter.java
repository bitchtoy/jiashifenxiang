package com.sequoia.vehicle.rental.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.ui.recycler.RecyclerViewHolder;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/2/7.
 * @funtion
 */

public class MyCarAdapter extends BaseQuickAdapter<Integer, RecyclerViewHolder> {
    private int tag = -1;

    public MyCarAdapter(@LayoutRes int layoutResId, @Nullable List<Integer> data, int tag) {
        super(layoutResId, data);
        this.tag = tag;
    }

    @Override
    protected void convert(RecyclerViewHolder helper, Integer item) {
        final TextView tvDesc = helper.getView(R.id.tv_order_desc);
        final AppCompatImageView ivOrder = helper.getView(R.id.iv_order);
        final TextView tvCarName = helper.getView(R.id.tv_car_name);
        final TextView tvOrderTime = helper.getView(R.id.tv_order_time);


        helper.addOnClickListener(R.id.tv_see_details);
        helper.addOnClickListener(R.id.tv_repayment);
        helper.addOnClickListener(R.id.tv_vehicle_deposit);
        helper.addOnClickListener(R.id.tv_illegal_deposit);


        tvCarName.setText("上汽大通D10");

        switch (tag) {
            case 0:
                //出租
                helper.setVisible(R.id.tv_vehicle_deposit, true);
                helper.setVisible(R.id.tv_illegal_deposit, true);
                helper.setVisible(R.id.tv_see_details, false);
                tvDesc.setText("获得出租金额：666");
                tvOrderTime.setText("出租天数：15");
                break;
            case 1:
                //抵押
                helper.setVisible(R.id.tv_repayment, true);
                helper.setVisible(R.id.tv_see_details, false);
                tvDesc.setText("获得抵押金额：15w");
                tvOrderTime.setText("还款日期：2018年02月8日");
                break;
            case 2:
                //投资
                tvDesc.setText("投资金额：666");
                tvOrderTime.setText("已获租金：666");
                break;
            case 3:
                //租赁
                tvDesc.setText("已付租金：666");
                tvOrderTime.setText("到期时间：2018年02月8日");
                break;
            case 4:
                //审核
                tvDesc.setText("获得赏金：666");
                tvOrderTime.setText("审核日期：2018年02月8日");
                break;

            default:
                break;
        }
    }
}
