package com.sequoia.vehicle.rental.activities.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/1/31.
 * @funtion 认证
 */

public class AuthActivity extends BaseActivity {

    public static final String AUTH_TYPE = "AUTH_TYPE";
    public static final int ID_CARD_AUTH = 0;
    public static final int DRIVER_AUTH = 1;
    public static final int DRIVING_AUTH = 2;
    private int mAuthType = -1;
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.et_card_num)
    EditText mEtCardNum;
    @BindView(R.id.tv_id_card_desc)
    TextView mTvIdCardDesc;
    @BindView(R.id.iv_id_card_positive)
    ImageView mIvIdCardPositive;
    @BindView(R.id.iv_id_card_opposite)
    ImageView mIvIdCardOpposite;
    @BindView(R.id.card_layout)
    LinearLayout mCardLayout;
    @BindView(R.id.id_card_layout)
    LinearLayout mIdCardLayout;
    @BindView(R.id.tv_driver_desc)
    TextView mTvDriverDesc;
    @BindView(R.id.iv_choose_driver)
    ImageView mIvChooseDriver;
    @BindView(R.id.drive_layout)
    LinearLayout mDriveLayout;
    @BindView(R.id.tv_driving_desc)
    TextView mTvDrivingDesc;
    @BindView(R.id.iv_choose_driving)
    ImageView mIvChooseDriving;
    @BindView(R.id.driving_layout)
    LinearLayout mDrivingLayout;
    @BindView(R.id.btn_submit)
    QMUIRoundButton mBtnSubmit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        mAuthType = getIntent().getIntExtra(AUTH_TYPE, 0);
        initTopBar();
        SpannableStringBuilder builder = new SpannableStringBuilder("请确保证件完整，编号、文字、照片均清晰可见");
        builder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_FF5C60)), 5, 16,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvIdCardDesc.setText(builder);
        mTvDriverDesc.setText(builder);
        mTvDrivingDesc.setText(builder);
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (mAuthType == ID_CARD_AUTH) {
            mTopBar.setTitle("身份证认证");
            mIdCardLayout.setVisibility(View.VISIBLE);
        } else if (mAuthType == DRIVER_AUTH) {
            mTopBar.setTitle("驾驶证认证");
            mDriveLayout.setVisibility(View.VISIBLE);
        } else if (mAuthType == DRIVING_AUTH) {
            mTopBar.setTitle("行驶证认证");
            mDrivingLayout.setVisibility(View.VISIBLE);
        } else {
            finish();
        }
    }


    @OnClick({R.id.iv_id_card_positive, R.id.iv_id_card_opposite, R.id.iv_choose_driving, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_id_card_positive:
                break;
            case R.id.iv_id_card_opposite:
                break;
            case R.id.iv_choose_driving:
                break;
            case R.id.btn_submit:
                break;
            default:
                break;
        }
    }
}