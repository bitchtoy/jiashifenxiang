package com.sequoia.vehicle.rental.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator.
 * @date 2018/2/6.
 * @funtion
 */

public class AuditVehicleDetailsActivity extends BaseActivity {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.btn_submit)
    QMUIRoundButton mBtnSubmit;
    @BindView(R.id.tv_attr)
    TextView mTvAttr;
    @BindView(R.id.et_attr)
    EditText mEtAttr;
    @BindView(R.id.et_driving_name)
    EditText mEtDrivingName;
    @BindView(R.id.et_mobile)
    EditText mEtMobile;
    @BindView(R.id.tv_car_model)
    TextView mTvCarModel;
    @BindView(R.id.tv_years)
    TextView mTvYears;
    @BindView(R.id.et_province)
    EditText mEtProvince;
    @BindView(R.id.et_city)
    EditText mEtCity;
    @BindView(R.id.et_mileage)
    EditText mEtMileage;
    @BindView(R.id.tv_car_location)
    TextView mTvCarLocation;
    @BindView(R.id.rb_no)
    RadioButton mRbNo;
    @BindView(R.id.rn_yes)
    RadioButton mRnYes;
    @BindView(R.id.rg)
    RadioGroup mRg;
    @BindView(R.id.et_last_money)
    EditText mEtLastMoney;
    @BindView(R.id.loan_layout)
    LinearLayout mLoanLayout;
    @BindView(R.id.tv_driving)
    TextView mTvDriving;
    @BindView(R.id.iv_choose_driving)
    ImageView mIvChooseDriving;
    @BindView(R.id.tv_car)
    TextView mTvCar;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_upload_car);
        ButterKnife.bind(this);
        mTopBar.setTitle("审核车辆");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initTextView();
    }

    private void initTextView() {
        String[] mText = {"添加图片 行驶证照片", "添加图片 车辆照片"};
        List<TextView> views = new ArrayList<>();
        views.add(mTvDriving);
        views.add(mTvCar);
        for (int i = 0; i < 2; i++) {
            SpannableString builder = new SpannableString(mText[i]);
            builder.setSpan(new RelativeSizeSpan(1.5f), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.color_666666)), 5, builder.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(new UnderlineSpan(), 5, builder.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            views.get(i).setText(builder);
        }
    }
}
