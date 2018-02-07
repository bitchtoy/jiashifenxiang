package com.sequoia.vehicle.rental.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaeger.library.StatusBarUtil;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.details.vertical.LeaseDetailsActivity;
import com.sequoia.vehicle.rental.adapter.LeaseMultipleAdapter;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.entities.multiple.DataConverter;
import com.sequoia.vehicle.rental.entities.multiple.FindCarBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion
 */

public class LeaseActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    AppCompatImageView mIvBack;
    @BindView(R.id.tv_search)
    AppCompatTextView mTvSearch;
    @BindView(R.id.iv_filter)
    AppCompatImageView mIvFilter;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.time_lease_layout)
    LinearLayout mTimeLeaseLayout;
    @BindView(R.id.tv_start_time)
    TextView mTvStartTime;
    @BindView(R.id.tv_lease_term)
    TextView mTvLeaseTerm;
    @BindView(R.id.tv_end_time)
    TextView mTvEndTime;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    private FindCarBean mFindCarBean = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lease);
        ButterKnife.bind(this);

        mFindCarBean = (FindCarBean) getIntent().getSerializableExtra("FIND_CAR_TIME");
        if (mFindCarBean != null ) {
            if (mFindCarBean.startTime != null ){
                mTvStartTime.setText(mFindCarBean.startTime);
            }
            if (mFindCarBean.endTime != null){
                mTvEndTime.setText(mFindCarBean.endTime);
            }
            if (mFindCarBean.getDays() >0){
                mTvLeaseTerm.setText(String.format("%d天",mFindCarBean.getDays()));
            }
        } else {
            mTimeLeaseLayout.setVisibility(View.GONE);
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        LeaseMultipleAdapter adapter = new LeaseMultipleAdapter(DataConverter.getLeaseData());
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(LeaseActivity.this, LeaseDetailsActivity.class));
            }
        });
    }

    @Override
    protected void setStatusBarColor() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.tool_bar_color1), 0);
    }


    @OnClick({R.id.iv_back, R.id.tv_search, R.id.iv_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_search:
                break;
            case R.id.iv_filter:
                break;
            default:
                break;
        }
    }
}
