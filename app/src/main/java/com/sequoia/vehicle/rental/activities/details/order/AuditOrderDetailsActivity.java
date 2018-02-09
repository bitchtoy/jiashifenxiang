package com.sequoia.vehicle.rental.activities.details.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.AuditConfirmedActivity;
import com.sequoia.vehicle.rental.activities.AuditVehicleDetailsActivity;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/2/5.
 * @funtion 审核订单详情
 */

public class AuditOrderDetailsActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.btn_audit_completed)
    QMUIRoundButton mBtnAuditCompleted;
    @BindView(R.id.btn_confirm)
    QMUIRoundButton mBtnConfirm;
    @BindView(R.id.lease_layout)
    LinearLayout mLeaseLayout;
    private int mTag = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_order_audit);
        ButterKnife.bind(this);
        initTopBar();
        mTag = getIntent().getIntExtra("TAG", 0);
        initBottomBar();
    }

    private void initBottomBar() {
        switch (mTag) {
            case 0:
                mBtnAuditCompleted.setVisibility(View.VISIBLE);
                break;
            case 1:
                mBtnConfirm.setVisibility(View.VISIBLE);
                break;
            case 2:
                mLeaseLayout.setVisibility(View.VISIBLE);
                break;
            default:
                mLeaseLayout.setVisibility(View.VISIBLE);
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

    @OnClick({R.id.btn_audit_completed, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_audit_completed:
                startActivity(new Intent(this, AuditVehicleDetailsActivity.class));
                break;
            case R.id.btn_confirm:
                startActivity(new Intent(this, AuditConfirmedActivity.class));
                break;
            default:
                break;
        }
    }
}
