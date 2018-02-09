package com.sequoia.vehicle.rental.fragment.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.OrderConfirmationActivity;
import com.sequoia.vehicle.rental.activities.details.order.AuditOrderDetailsActivity;
import com.sequoia.vehicle.rental.activities.details.order.InvestmentOrderDetailsActivity;
import com.sequoia.vehicle.rental.activities.details.order.LeaseOrderDetailsActivity;
import com.sequoia.vehicle.rental.adapter.order.AuditOrderAdapter;
import com.sequoia.vehicle.rental.adapter.order.LeaseOrderAdapter;
import com.sequoia.vehicle.rental.base.LazyFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/2/5.
 * @funtion 租赁订单
 */

public class LeaseOrderFragment extends LazyFragment implements BaseQuickAdapter.OnItemChildClickListener {
    private static final String TAG = "TAG";

    private int mTag = -1;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView = null;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout = null;
    Unbinder unbinder;

    public static LeaseOrderFragment getInstance(int tag) {
        Bundle bundle = new Bundle();
        bundle.putInt(TAG, tag);
        LeaseOrderFragment fragment = new LeaseOrderFragment();
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
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        unbinder = ButterKnife.bind(this, view);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        return view;
    }

    @Override
    public void initData() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        LeaseOrderAdapter adapter = new LeaseOrderAdapter(R.layout.adapter_order_lease_item, list, mTag);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (mTag == 0) {

                }
                Intent intent = new Intent(mActivity, LeaseOrderDetailsActivity.class);
                intent.putExtra(TAG, mTag);
                startActivity(intent);
            }
        });
        adapter.setOnItemChildClickListener(this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

        switch (view.getId()) {
            case R.id.tv_delete:
                break;
            case R.id.tv_cancel:
                break;
            case R.id.tv_pay:
                Intent intent0 = new Intent(mActivity, OrderConfirmationActivity.class);
                startActivity(intent0);
                break;
            case R.id.tv_see_details:
                Intent intent = new Intent(mActivity, LeaseOrderDetailsActivity.class);
                intent.putExtra(TAG, mTag);
                startActivity(intent);
                break;
            case R.id.tv_contact_owner:
                break;
            default:
                break;
        }
    }
}
