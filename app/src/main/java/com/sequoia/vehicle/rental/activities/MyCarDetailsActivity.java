package com.sequoia.vehicle.rental.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/2/7.
 * @funtion 我的车辆详情
 */

public class MyCarDetailsActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.investment_layout)
    LinearLayout mInvestmentLayout;
    @BindView(R.id.lease_layout)
    LinearLayout mLeaseLayout;
    @BindView(R.id.rental_layout)
    LinearLayout mRentalLayout;
    @BindView(R.id.mortgage_layout)
    LinearLayout mMortgageLayout;
    @BindView(R.id.audit_layout)
    LinearLayout mAuditLayout;
    private int mTag = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_my_car);
        ButterKnife.bind(this);
        mTag = getIntent().getIntExtra("TAG", 0);
        initTopBar();

        switch (mTag) {
            case 0:
                mMortgageLayout.setVisibility(View.VISIBLE);
                break;
            case 1:
                mRentalLayout.setVisibility(View.VISIBLE);
                break;
            case 2:
                mLeaseLayout.setVisibility(View.VISIBLE);
                break;
            case 3:
                mInvestmentLayout.setVisibility(View.VISIBLE);
                break;
            case 4:
                mAuditLayout.setVisibility(View.VISIBLE);
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
}
