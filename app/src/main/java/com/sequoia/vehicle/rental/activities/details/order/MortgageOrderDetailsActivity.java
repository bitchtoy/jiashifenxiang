package com.sequoia.vehicle.rental.activities.details.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.AuditorVerticalActivity;
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
    @BindView(R.id.tv_delete)
    TextView mTvDelete;
    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.tv_edit)
    TextView mTvEdit;

    @BindView(R.id.tv_choose_auditor)
    TextView mTvChooseAuditor;
    @BindView(R.id.tv_repayment)
    TextView mTvRepayment;
    @BindView(R.id.tv_confirm)
    TextView mTvConfirm;
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
                mTvCancel.setVisibility(View.VISIBLE);
                mTvEdit.setVisibility(View.VISIBLE);
                break;
            case 1:
                mTvCancel.setVisibility(View.VISIBLE);
                mTvChooseAuditor.setVisibility(View.VISIBLE);
                break;
            case 2:
                mTvConfirm.setVisibility(View.VISIBLE);
                break;
            case 3:
                mTvDelete.setVisibility(View.VISIBLE);
                mTvRepayment.setVisibility(View.VISIBLE);
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

    @OnClick({R.id.tv_delete, R.id.tv_cancel, R.id.tv_edit, R.id.tv_choose_auditor, R.id.tv_repayment, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_delete:
                break;
            case R.id.tv_cancel:
                break;
            case R.id.tv_edit:
                startActivity(new Intent(MortgageOrderDetailsActivity.this, MortgageVehicleActivity.class));
                break;
            case R.id.tv_choose_auditor:
                startActivity(new Intent(MortgageOrderDetailsActivity.this, AuditorVerticalActivity.class));
                break;
            case R.id.tv_repayment:
                break;
            case R.id.tv_confirm:
                break;
            default:
                break;
        }
    }
}
