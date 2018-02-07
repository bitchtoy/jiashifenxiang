package com.sequoia.vehicle.rental.activities.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.activities.BankCardAddActivity;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.base.BaseFragment;
import com.sequoia.vehicle.rental.fragment.balance.BalanceWithdrawalsFragment;
import com.sequoia.vehicle.rental.fragment.balance.BankCardFragment;
import com.sequoia.vehicle.rental.fragment.balance.InvestmentAmountFragment;
import com.sequoia.vehicle.rental.fragment.balance.LoanAmountFragment;
import com.sequoia.vehicle.rental.fragment.balance.PaymentDetailsFragment;
import com.sequoia.vehicle.rental.fragment.balance.RechargeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/2/6.
 * @funtion
 */

public class BalanceActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.content_layout)
    FrameLayout mContentLayout;
    private int mWalletTag = -1;
    private String[] mTitle = {"余额提现", "充值", "借贷金额", "投资金额", "支付明细", "我的银行卡"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        ButterKnife.bind(this);
        mWalletTag = getIntent().getIntExtra(WalletActivity.WALLET_TAG, 0);
        initTopBar();
        initFragment();
    }

    private void initFragment() {
        BaseFragment fragment = null;
        switch (mWalletTag) {
            case 0:
                fragment = new BalanceWithdrawalsFragment();
                break;
            case 1:
                fragment = new RechargeFragment();
                break;
            case 2:
                fragment = new LoanAmountFragment();
                break;
            case 3:
                fragment = new InvestmentAmountFragment();
                break;
            case 4:
                fragment = new PaymentDetailsFragment();
                break;
            case 5:
                fragment = new BankCardFragment();
                break;
            default:
                break;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_layout, fragment)
                .commit();
    }

    private void initTopBar() {
        mTopBar.setTitle(mTitle[mWalletTag]);
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (mWalletTag == 5) {
            Button button = mTopBar.addRightTextButton(R.string.bank_card_add, R.id.bank_card_add);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(BalanceActivity.this, BankCardAddActivity.class));
                }
            });
            button.setTextColor(ContextCompat.getColor(this, R.color.color_666666));

        }
    }
}
