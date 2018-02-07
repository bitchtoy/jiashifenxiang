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
 * @date 2018/2/2.
 * @funtion
 */

public class AuditorAutoActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_card_num)
    EditText mEtCardNum;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.tv_id_card_desc)
    TextView mTvIdCardDesc;
    @BindView(R.id.iv_id_card_positive)
    ImageView mIvIdCardPositive;
    @BindView(R.id.iv_id_card_opposite)
    ImageView mIvIdCardOpposite;
    @BindView(R.id.card_layout)
    LinearLayout mCardLayout;
    @BindView(R.id.tv_driver_desc)
    TextView mTvDriverDesc;
    @BindView(R.id.iv_choose_driver)
    ImageView mIvChooseDriver;
    @BindView(R.id.driver_layout)
    LinearLayout mDriverLayout;
    @BindView(R.id.btn_submit)
    QMUIRoundButton mBtnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_auditor);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        SpannableStringBuilder builder = new SpannableStringBuilder("请确保证件完整，编号、文字、照片均清晰可见");
        builder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_FF5C60)), 5, 16,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvIdCardDesc.setText(builder);
        mTvDriverDesc.setText(builder);
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle("审核员认证");
    }

    @OnClick({R.id.iv_id_card_positive, R.id.iv_id_card_opposite, R.id.iv_choose_driver, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_id_card_positive:
                break;
            case R.id.iv_id_card_opposite:
                break;
            case R.id.iv_choose_driver:
                break;
            case R.id.btn_submit:
                break;
            default:
                break;
        }
    }
}
