package com.sequoia.vehicle.rental.activities.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/1/30.
 * @funtion 设置
 */

public class SettingActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.iv_avatar)
    QMUIRadiusImageView mIvAvatar;
    @BindView(R.id.avatar_layout)
    LinearLayout mAvatarLayout;
    @BindView(R.id.tv_nickname)
    TextView mTvNickname;
    @BindView(R.id.nickname_layout)
    LinearLayout mNicknameLayout;
    @BindView(R.id.tv_gender)
    TextView mTvGender;
    @BindView(R.id.gender_layout)
    LinearLayout mGenderLayout;
    @BindView(R.id.mobile_layout)
    LinearLayout mMobileLayout;
    @BindView(R.id.password_layout)
    LinearLayout mPasswordLayout;
    @BindView(R.id.tv_about)
    TextView mTvAbout;
    @BindView(R.id.tv_feedback)
    TextView mTvFeedback;
    @BindView(R.id.btn_sign_out)
    QMUIRoundButton mBtnSignOut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initTopBar();

    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle("个人设置");
    }


    @OnClick({R.id.avatar_layout, R.id.nickname_layout, R.id.gender_layout
            , R.id.mobile_layout, R.id.password_layout
            , R.id.tv_about, R.id.tv_feedback, R.id.btn_sign_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.avatar_layout:

                break;
            case R.id.nickname_layout:
                Intent nickname = new Intent(this, ModifyActivity.class);
                nickname.putExtra(ModifyActivity.MODIFY, ModifyActivity.NICKNAME);
                nickname.putExtra(ModifyActivity.NICKNAME, mTvNickname.getText().toString().trim());
                startActivity(nickname);
                break;
            case R.id.gender_layout:
                break;
            case R.id.mobile_layout:
                Intent mobile = new Intent(this, ModifyActivity.class);
                mobile.putExtra(ModifyActivity.MODIFY, ModifyActivity.MOBILE);
                startActivity(mobile);
                break;
            case R.id.password_layout:
                Intent password = new Intent(this, ModifyActivity.class);
                password.putExtra(ModifyActivity.MODIFY, ModifyActivity.PASSWORD);
                startActivity(password);
                break;
            case R.id.tv_about:
                break;
            case R.id.tv_feedback:
                break;
            case R.id.btn_sign_out:
                break;
            default:
                break;
        }
    }

}
