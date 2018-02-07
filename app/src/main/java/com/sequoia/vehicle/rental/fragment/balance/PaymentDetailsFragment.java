package com.sequoia.vehicle.rental.fragment.balance;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.adapter.PayRecordPagerAdapter;
import com.sequoia.vehicle.rental.base.BaseFragment;
import com.sequoia.vehicle.rental.fragment.record.ExpensesRecordFragment;
import com.sequoia.vehicle.rental.fragment.record.RechargeRecordFragment;
import com.sequoia.vehicle.rental.fragment.record.WithdrawalsRecordFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/2/6.
 * @funtion 支付明细
 */

public class PaymentDetailsFragment extends BaseFragment {
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_details, container, false);
        unbinder = ButterKnife.bind(this, view);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ExpensesRecordFragment());
        fragments.add(new RechargeRecordFragment());
        fragments.add(new WithdrawalsRecordFragment());
        String[] title = {"消费记录", "充值记录", "提现记录"};
        mViewPager.setAdapter(new PayRecordPagerAdapter(getChildFragmentManager(), fragments, title));
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
