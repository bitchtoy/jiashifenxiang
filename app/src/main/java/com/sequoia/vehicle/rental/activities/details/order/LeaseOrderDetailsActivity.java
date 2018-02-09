package com.sequoia.vehicle.rental.activities.details.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.OrderConfirmationActivity;
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
    @BindView(R.id.owner_layout)
    LinearLayout mOwnerLayout;
    @BindView(R.id.btn_pay)
    QMUIRoundButton mBtnPay;
    @BindView(R.id.btn_contact_owner)
    QMUIRoundButton mBtnContactOwner;
    //    @BindView(R.id.btn_delete)
//    QMUIRoundButton mBtnDelete;
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
                mBtnPay.setVisibility(View.VISIBLE);
                break;
            case 1:
                mBtnContactOwner.setVisibility(View.VISIBLE);
                break;
            case 2:
//                mBtnDelete.setVisibility(View.VISIBLE);
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


    @OnClick({R.id.btn_pay, R.id.btn_contact_owner})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_pay:
                intent = new Intent(this, OrderConfirmationActivity.class);
                break;
            case R.id.btn_contact_owner:
                break;
            default:
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
