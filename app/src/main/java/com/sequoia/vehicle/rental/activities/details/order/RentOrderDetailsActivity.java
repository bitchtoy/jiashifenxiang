package com.sequoia.vehicle.rental.activities.details.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.management.RentalVehicleActivity;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/2/5.
 * @funtion 出租订单详情
 */

public class RentOrderDetailsActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.tv_vehicle_deposit)
    TextView mTvVehicleDeposit;
    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.tv_confirm)
    TextView mTvConfirm;
    @BindView(R.id.tv_edit)
    TextView mTvEdit;
    @BindView(R.id.tv_illegal_deposit)
    TextView mTvIllegalDeposit;
    @BindView(R.id.lease_layout)
    LinearLayout mLeaseLayout;
    @BindView(R.id.tv_start_time)
    TextView mTvStartTime;
    @BindView(R.id.tv_lease_term)
    TextView mTvLeaseTerm;
    @BindView(R.id.tv_end_time)
    TextView mTvEndTime;
    private int mTag = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_order_rent);
        ButterKnife.bind(this);
        initTopBar();
        mTag = getIntent().getIntExtra("TAG", 0);
        initBottomBar();
    }

    private void initBottomBar() {
        switch (mTag) {
            case 0:
                mTvCancel.setVisibility(View.VISIBLE);
                mTvEdit.setVisibility(View.VISIBLE);
                break;
            case 1:
                mTvCancel.setVisibility(View.VISIBLE);
                mTvConfirm.setVisibility(View.VISIBLE);
                mLeaseLayout.setVisibility(View.VISIBLE);
                break;
            case 2:
                mLeaseLayout.setVisibility(View.VISIBLE);
                mTvVehicleDeposit.setVisibility(View.VISIBLE);
                mTvIllegalDeposit.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    private void initTopBar() {
        mTopBar.setTitle("订单详情");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.tv_vehicle_deposit, R.id.tv_cancel, R.id.tv_confirm, R.id.tv_edit, R.id.tv_illegal_deposit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_vehicle_deposit:
                break;
            case R.id.tv_cancel:
                break;
            case R.id.tv_confirm:
                break;
            case R.id.tv_edit:
                startActivity(new Intent(this, RentalVehicleActivity.class));
                break;
            case R.id.tv_illegal_deposit:
                break;
            default:
                break;
        }
    }
}
