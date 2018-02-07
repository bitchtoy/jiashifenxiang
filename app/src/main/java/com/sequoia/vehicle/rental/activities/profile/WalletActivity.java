package com.sequoia.vehicle.rental.activities.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/1/31.
 * @funtion 我的钱包
 */

public class WalletActivity extends BaseActivity {
    public static final String WALLET_TAG = "WALLET_TAG";

    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.tv_yu_e)
    TextView mTvYuE;
    @BindView(R.id.tv_withdrawals)
    TextView mTvWithdrawals;
    @BindView(R.id.tv_recharge)
    TextView mTvRecharge;
    @BindView(R.id.tv_loan)
    TextView mTvLoan;
    @BindView(R.id.tv_investment)
    TextView mTvInvestment;
    @BindView(R.id.tv_details)
    TextView mTvDetails;
    @BindView(R.id.tv_bank_card)
    TextView mTvBankCard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);
        initTopBar();
        SpannableString builder = new SpannableString("￥0.0");
        builder.setSpan(new RelativeSizeSpan(2.0f), 1, builder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvYuE.setText(builder);

    }

    private void initTopBar() {
        mTopBar.setTitle("我的钱包");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @OnClick({R.id.tv_withdrawals, R.id.tv_recharge, R.id.tv_loan, R.id.tv_investment, R.id.tv_details, R.id.tv_bank_card})
    public void onViewClicked(View view) {
        Intent intent = new Intent(this, BalanceActivity.class);
        switch (view.getId()) {
            case R.id.tv_withdrawals:
                intent.putExtra(WALLET_TAG, 0);
                break;
            case R.id.tv_recharge:
                intent.putExtra(WALLET_TAG, 1);
                break;
            case R.id.tv_loan:
                intent.putExtra(WALLET_TAG, 2);
                break;
            case R.id.tv_investment:
                intent.putExtra(WALLET_TAG, 3);
                break;
            case R.id.tv_details:
                intent.putExtra(WALLET_TAG, 4);
                break;
            case R.id.tv_bank_card:
                intent.putExtra(WALLET_TAG, 5);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
