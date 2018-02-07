package com.sequoia.vehicle.rental.activities.details.order;

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
 * @funtion 租赁订单详情
 */

public class LeaseOrderDetailsActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.tv_delete)
    TextView mTvDelete;
    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.tv_pay)
    TextView mTvPay;
    @BindView(R.id.tv_contact_owner)
    TextView mTvContactOwner;
    @BindView(R.id.tv_start_time)
    TextView mTvStartTime;
    @BindView(R.id.tv_lease_term)
    TextView mTvLeaseTerm;
    @BindView(R.id.tv_end_time)
    TextView mTvEndTime;
    @BindView(R.id.owner_layout)
    LinearLayout mOwnerLayout;
    private int mTag = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_order_lease);
        ButterKnife.bind(this);
        initTopBar();
        mTag = getIntent().getIntExtra("TAG", 0);
        initBottomBar();
    }

    private void initBottomBar() {
        switch (mTag) {
            case 0:
                mTvCancel.setVisibility(View.VISIBLE);
                mTvPay.setVisibility(View.VISIBLE);
                break;
            case 1:
                mTvCancel.setVisibility(View.VISIBLE);
                mTvContactOwner.setVisibility(View.VISIBLE);
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

    @OnClick({R.id.tv_delete, R.id.tv_cancel, R.id.tv_pay, R.id.tv_contact_owner})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_delete:
                break;
            case R.id.tv_cancel:
                break;
            case R.id.tv_pay:
                break;
            case R.id.tv_contact_owner:
                break;
            default:
                break;
        }
    }
}
