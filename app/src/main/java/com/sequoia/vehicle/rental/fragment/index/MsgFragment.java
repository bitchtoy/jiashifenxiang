package com.sequoia.vehicle.rental.fragment.index;

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
 * @date 2018/2/1.
 * @funtion 消息
 */

public class MsgFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_msg,container,false);
        return view;
    }
}
