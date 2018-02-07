package com.sequoia.vehicle.rental.activities.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.ui.edittext.EditTextWithDel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/1/25.
 * @funtion
 */

public class ModifyActivity extends BaseActivity {
    public static final String MODIFY = "MODIFY";
    public static final String NICKNAME = "NICKNAME";
    public static final String MOBILE = "MOBILE";
    public static final String PASSWORD = "PASSWORD";
    @BindView(R.id.et_nickname)
    EditTextWithDel mEtNickname;
    private String mModify = null;
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.nickname_layout)
    LinearLayout mNicknameLayout;
    @BindView(R.id.et_mobile)
    AppCompatEditText mEtMobile;
    @BindView(R.id.tv_sms)
    TextView mTvSms;
    @BindView(R.id.et_sms)
    AppCompatEditText mEtSms;
    @BindView(R.id.mobile_layout)
    LinearLayout mMobileLayout;
    @BindView(R.id.et_password)
    AppCompatEditText mEtPassword;
    @BindView(R.id.et_re_password)
    AppCompatEditText mEtRePassword;
    @BindView(R.id.password_layout)
    LinearLayout mPasswordLayout;
    @BindView(R.id.btn_modify)
    QMUIRoundButton mBtnModify;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        ButterKnife.bind(this);
        mModify = getIntent().getStringExtra(MODIFY);
        if (mModify.equals(NICKNAME)) {
            mNicknameLayout.setVisibility(View.VISIBLE);
            mTopBar.setTitle("修改昵称");
            final String nickname = getIntent().getStringExtra(NICKNAME);
            mEtNickname.setHint(nickname);
        } else if (mModify.equals(MOBILE)) {
            mMobileLayout.setVisibility(View.VISIBLE);
            mTopBar.setTitle("修改手机号");
        } else if (mModify.equals(PASSWORD)) {
            mMobileLayout.setVisibility(View.VISIBLE);
            mPasswordLayout.setVisibility(View.VISIBLE);
            mTopBar.setTitle("修改密码");
        }
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.tv_sms, R.id.btn_modify})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_sms:
                break;
            case R.id.btn_modify:
                break;
            default:
                break;
        }
    }
}
