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

/**
 * @author Administrator.
 * @date 2018/2/5.
 * @funtion 投资订单详情
 */

public class InvestmentOrderDetailsActivity extends BaseActivity {

    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.investment_layout)
    LinearLayout mInvestmentLayout;
    @BindView(R.id.btn_pay)
    QMUIRoundButton mBtnPay;
    //    @BindView(R.id.btn_delete)
//    QMUIRoundButton mBtnDelete;
    private int mTag = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_order_investment);
        ButterKnife.bind(this);
        initTopBar();
        mTag = getIntent().getIntExtra("TAG", 0);
        initBottomBar();
        mBtnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InvestmentOrderDetailsActivity.this, OrderConfirmationActivity.class);
                intent.putExtra("TAG", 1);
                startActivity(intent);
            }
        });
    }

    private void initBottomBar() {
        switch (mTag) {
            case 0:
                mBtnPay.setVisibility(View.VISIBLE);
                break;
            case 1:
//                mBtnDelete.setVisibility(View.VISIBLE);
                mInvestmentLayout.setVisibility(View.VISIBLE);
                break;
            default:
                mInvestmentLayout.setVisibility(View.VISIBLE);
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
