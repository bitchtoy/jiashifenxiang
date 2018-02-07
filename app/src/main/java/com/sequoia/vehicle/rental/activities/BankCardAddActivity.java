package com.sequoia.vehicle.rental.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/2/7.
 * @funtion 添加银行卡
 */

public class BankCardAddActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.et_card_name)
    EditText mEtCardName;
    @BindView(R.id.et_bank_card_num)
    EditText mEtBankCardNum;
    @BindView(R.id.et_card_phone)
    EditText mEtCardPhone;
    @BindView(R.id.et_sms)
    EditText mEtSms;
    @BindView(R.id.btn_sms)
    QMUIRoundButton mBtnSms;
    @BindView(R.id.btn_confirm)
    QMUIRoundButton mBtnConfirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_card_add);
        ButterKnife.bind(this);
        initTopBar();
    }

    private void initTopBar() {
        mTopBar.setTitle("添加银行卡");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.btn_sms, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_sms:
                break;
            case R.id.btn_confirm:
                break;
            default:
                break;
        }
    }
}
