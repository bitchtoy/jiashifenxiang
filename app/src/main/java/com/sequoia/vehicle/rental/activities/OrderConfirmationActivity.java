package com.sequoia.vehicle.rental.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/1/31.
 * @funtion
 */

public class OrderConfirmationActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.cb_yu_e)
    CheckBox mCbYuE;
    @BindView(R.id.yu_e_layout)
    LinearLayout mYuELayout;
    @BindView(R.id.tv_rent)
    TextView mTvRent;
    @BindView(R.id.tv_car_deposit)
    TextView mTvCarDeposit;
    @BindView(R.id.tv_car_illegal_deposit)
    TextView mTvCarIllegalDeposit;
    @BindView(R.id.tv_insurance)
    TextView mTvInsurance;
    @BindView(R.id.cb_insurance)
    CheckBox mCbInsurance;
    @BindView(R.id.insurance_layout)
    LinearLayout mInsuranceLayout;
    @BindView(R.id.et_num_points)
    EditText mEtNumPoints;
    @BindView(R.id.tv_num_points)
    TextView mTvNumPoints;
    @BindView(R.id.integral_layout)
    LinearLayout mIntegralLayout;
    @BindView(R.id.lease_layout)
    LinearLayout mLeaseLayout;
    @BindView(R.id.tv_total_money)
    TextView mTvTotalMoney;
    @BindView(R.id.btn_submit_order)
    Button mBtnSubmitOrder;
    private int mTag = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lease_confirmation);
        ButterKnife.bind(this);
        mTag = getIntent().getIntExtra("TAG", 0);
        if (mTag == 0) {
            mLeaseLayout.setVisibility(View.VISIBLE);
        }
        initTopBar();
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle("确认订单");
    }
}
