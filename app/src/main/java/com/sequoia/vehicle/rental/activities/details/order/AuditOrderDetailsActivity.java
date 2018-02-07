package com.sequoia.vehicle.rental.activities.details.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
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
    @BindView(R.id.tv_delete)
    TextView mTvDelete;
    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.tv_audit_completed)
    TextView mTvAuditCompleted;

    @BindView(R.id.tv_confirm)
    TextView mTvConfirm;
    @BindView(R.id.owner_layout)
    LinearLayout mOwnerLayout;
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
                mTvCancel.setVisibility(View.VISIBLE);
                mTvAuditCompleted.setVisibility(View.VISIBLE);
                break;
            case 1:
                mTvCancel.setVisibility(View.VISIBLE);
                mTvConfirm.setVisibility(View.VISIBLE);
                break;
            case 2:
                mTvDelete.setVisibility(View.VISIBLE);

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

    @OnClick({R.id.tv_delete, R.id.tv_cancel, R.id.tv_audit_completed, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_delete:
                break;
            case R.id.tv_cancel:
                break;
            case R.id.tv_audit_completed:
                startActivity(new Intent(AuditOrderDetailsActivity.this, UploadCarDetailsActivity.class));
                break;
            case R.id.tv_confirm:
                break;
            default:
                break;
        }
    }
}
