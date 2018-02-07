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
 * @funtion 车主认证
 */

public class OwnersAuthActivity extends BaseActivity {

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
        setContentView(R.layout.activity_auth_owners);
        ButterKnife.bind(this);
        initTopBar();
        SpannableStringBuilder builder = new SpannableStringBuilder("请确保证件完整，编号、文字、照片均清晰可见");
        builder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_FF5C60)), 5, 16,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvIdCardDesc.setText(builder);
        mTvDrivingDesc.setText(builder);
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle("身份认证");
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