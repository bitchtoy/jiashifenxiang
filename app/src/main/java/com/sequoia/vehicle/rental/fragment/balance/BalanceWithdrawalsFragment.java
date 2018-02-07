package com.sequoia.vehicle.rental.fragment.balance;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/2/6.
 * @funtion 余额提现
 */

public class BalanceWithdrawalsFragment extends BaseFragment {
    @BindView(R.id.tv_yu_e)
    TextView mTvYuE;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_balance_withdrawals, container, false);
        unbinder = ButterKnife.bind(this, view);
        SpannableString builder = new SpannableString("￥0.0");
        builder.setSpan(new RelativeSizeSpan(2.0f), 1, builder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvYuE.setText(builder);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
