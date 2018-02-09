package com.sequoia.vehicle.rental.activities.details.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.AuditorVerticalActivity;
import com.sequoia.vehicle.rental.activities.OrderConfirmationActivity;
import com.sequoia.vehicle.rental.activities.management.MortgageVehicleActivity;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/2/5.
 * @funtion 抵押订单详情
 */

public class MortgageOrderDetailsActivity extends BaseActivity {

    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.lease_layout)
    LinearLayout mLeaseLayout;
    @BindView(R.id.btn_edit)
    QMUIRoundButton mBtnEdit;
    @BindView(R.id.btn_confirm)
    QMUIRoundButton mBtnConfirm;
    @BindView(R.id.btn_choose_auditor)
    QMUIRoundButton mBtnChooseAuditor;
    @BindView(R.id.btn_repayment)
    QMUIRoundButton mBtnRepayment;
    private int mTag = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_order_mortgage);
        ButterKnife.bind(this);
        initTopBar();
        mTag = getIntent().getIntExtra("TAG", 0);
        initBottomBar();

    }

    private void initBottomBar() {
        switch (mTag) {
            case 0:
                mBtnEdit.setVisibility(View.VISIBLE);
                break;
            case 1:
                mBtnChooseAuditor.setVisibility(View.VISIBLE);
                break;
            case 2:
                mBtnConfirm.setVisibility(View.VISIBLE);
                break;
            case 3:
                mLeaseLayout.setVisibility(View.VISIBLE);
                mBtnRepayment.setVisibility(View.VISIBLE);
                break;
            default:
                mLeaseLayout.setVisibility(View.VISIBLE);
                mBtnRepayment.setVisibility(View.VISIBLE);
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

    @OnClick({R.id.btn_edit, R.id.btn_confirm, R.id.btn_choose_auditor, R.id.btn_repayment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_edit:
                startActivity(new Intent(MortgageOrderDetailsActivity.this, MortgageVehicleActivity.class));
                break;
            case R.id.btn_confirm:
                break;
            case R.id.btn_choose_auditor:
                startActivity(new Intent(MortgageOrderDetailsActivity.this, AuditorVerticalActivity.class));
                break;
            case R.id.btn_repayment:
                Intent intent = new Intent(MortgageOrderDetailsActivity.this, OrderConfirmationActivity.class);
                intent.putExtra("TAG", 1);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
