package com.sequoia.vehicle.rental.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.MyCarDetailsActivity;
import com.sequoia.vehicle.rental.activities.details.order.AuditOrderDetailsActivity;
import com.sequoia.vehicle.rental.activities.details.order.InvestmentOrderDetailsActivity;
import com.sequoia.vehicle.rental.activities.details.order.LeaseOrderDetailsActivity;
import com.sequoia.vehicle.rental.activities.details.order.MortgageOrderDetailsActivity;
import com.sequoia.vehicle.rental.activities.details.order.RentOrderDetailsActivity;
import com.sequoia.vehicle.rental.activities.management.MortgageVehicleActivity;
import com.sequoia.vehicle.rental.adapter.MyCarAdapter;
import com.sequoia.vehicle.rental.base.LazyFragment;
import com.sequoia.vehicle.rental.fragment.order.AuditOrderFragment;
import com.sequoia.vehicle.rental.ui.recycler.BaseDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/2/7.
 * @funtion 审核
 */

public class MyCarFragment extends LazyFragment implements BaseQuickAdapter.OnItemChildClickListener {

    private static final String TAG = "TAG";

    @BindView(R.id.recycler_View)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    private int mTag = -1;

    public static MyCarFragment getInstance(int tag) {
        Bundle bundle = new Bundle();
        bundle.putInt(TAG, tag);
        MyCarFragment fragment = new MyCarFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mTag = bundle.getInt(TAG);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_car, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void initData() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        MyCarAdapter adapter = new MyCarAdapter(R.layout.adapter_my_car_item, list, mTag);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemChildClickListener(this);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mActivity, MyCarDetailsActivity.class);
                intent.putExtra(TAG, mTag);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.tv_see_details:
                break;
            case R.id.tv_repayment:
                break;
            case R.id.tv_vehicle_deposit:
                break;
            case R.id.tv_illegal_deposit:
                break;
            default:
                break;
        }

    }
}
