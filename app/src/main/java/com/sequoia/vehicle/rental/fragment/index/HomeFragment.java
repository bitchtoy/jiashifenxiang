package com.sequoia.vehicle.rental.fragment.index;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.CalendarActivity;
import com.sequoia.vehicle.rental.activities.InvestorsActivity;
import com.sequoia.vehicle.rental.activities.LeaseActivity;
import com.sequoia.vehicle.rental.activities.OwnersActivity;
import com.sequoia.vehicle.rental.adapter.HomeMultipleAdapter;
import com.sequoia.vehicle.rental.base.BaseFragment;
import com.sequoia.vehicle.rental.entities.multiple.DataConverter;
import com.sequoia.vehicle.rental.entities.multiple.FindCarBean;
import com.sequoia.vehicle.rental.ui.recycler.RecyclerHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator.
 * @date 2018/2/1.
 * @funtion 首页
 */

public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener
        , BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.recycler_View)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    Unbinder unbinder;
    private HomeMultipleAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        RecyclerHandler.create(mRecyclerView, mToolBar, mTvTitle, ContextCompat.getColor(mActivity, R.color.tool_bar_color));
        initData();
        mRefreshLayout.setOnRefreshListener(this);
        return view;
    }

    private void initData() {
        mAdapter = new HomeMultipleAdapter(DataConverter.getHomeData());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 1000);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.tv_city:
                break;
            case R.id.start_layout:
                FindCarBean bean = (FindCarBean) mAdapter.getData().get(position);
                Intent start = new Intent(mActivity, CalendarActivity.class);
                start.putExtra("FIND_CAR_TIME", bean);
                start.putExtra("START_END", 0);
                startActivityForResult(start, 1000);
                break;
            case R.id.end_layout:
                FindCarBean bean1 = (FindCarBean) mAdapter.getData().get(position);
                Intent end = new Intent(mActivity, CalendarActivity.class);
                end.putExtra("START_END", 1);
                end.putExtra("FIND_CAR_TIME", bean1);
                startActivityForResult(end, 1000);
                break;
            case R.id.btn_find_car:
                FindCarBean bean2 = (FindCarBean) mAdapter.getData().get(position);
                Intent lease = new Intent(mActivity, LeaseActivity.class);
                lease.putExtra("FIND_CAR_TIME", bean2);
                startActivity(lease);
                break;
            case R.id.left_layout:
                Intent investors = new Intent(mActivity, InvestorsActivity.class);
                startActivity(investors);
                break;
            case R.id.right_layout:
                Intent owners = new Intent(mActivity, OwnersActivity.class);
                startActivity(owners);
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000 && resultCode == 1000) {
            FindCarBean bean = (FindCarBean) data.getSerializableExtra("FIND_CAR_TIME");
            mAdapter.getData().set(1, bean);
            mAdapter.notifyItemChanged(1);
        }
    }
}
