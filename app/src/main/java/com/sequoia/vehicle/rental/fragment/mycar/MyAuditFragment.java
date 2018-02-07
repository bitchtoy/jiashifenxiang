package com.sequoia.vehicle.rental.fragment.mycar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.LazyFragment;

/**
 * @author Administrator.
 * @date 2018/2/7.
 * @funtion 审核
 */

public class MyAuditFragment extends LazyFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_audit, container, false);
        return view;

    }

    @Override
    public void initData() {

    }
}
