package com.sequoia.vehicle.rental.fragment.balance;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseFragment;

/**
 * @author Administrator.
 * @date 2018/2/6.
 * @funtion 借贷金额
 */

public class LoanAmountFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loan_amount,container,false);
        return view;
    }
}
