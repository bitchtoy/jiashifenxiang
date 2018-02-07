package com.sequoia.vehicle.rental.activities.management;

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
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.ui.edittext.EditTextWatcher;
import com.sequoia.vehicle.rental.ui.picker.PickerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/1/30.
 * @funtion
 */

public class RentalVehicleActivity extends BaseActivity  {
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.tv_attr)
    TextView mTvAttr;
    @BindView(R.id.et_attr)
    EditText mEtAttr;
    @BindView(R.id.et_driving_name)
    EditText mEtDrivingName;
    @BindView(R.id.et_rent)
    EditText mEtRent;
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
    @BindView(R.id.tv_driving)
    TextView mTvDriving;
    @BindView(R.id.iv_choose_driving)
    ImageView mIvChooseDriving;
    @BindView(R.id.tv_car)
    TextView mTvCar;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.btn_submit)
    QMUIRoundButton mBtnSubmit;
    private TimePickerView mTimePickerView = null;
    private OptionsPickerView mOptionsPickerView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_vehicle);
        ButterKnife.bind(this);
        initTextView();
        initTopBar();
        mEtRent.addTextChangedListener(new EditTextWatcher());
        mEtMileage.addTextChangedListener(new EditTextWatcher());
    }


    @OnClick({R.id.tv_attr, R.id.tv_car_model, R.id.tv_years, R.id.tv_car_location, R.id.iv_choose_driving, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_attr:
                if (mOptionsPickerView == null) {
                    mOptionsPickerView = PickerView.createLicensePlatePicker(this);
                }
                mOptionsPickerView.show(mTvAttr);
                break;
            case R.id.tv_car_model:
                break;
            case R.id.tv_years:
                if (mTimePickerView == null) {
                    mTimePickerView = PickerView.createTimePickerView(this);
                }
                mTimePickerView.show(mTvYears);
                break;
            case R.id.tv_car_location:
                break;
            case R.id.iv_choose_driving:
                break;
            case R.id.btn_submit:

                break;
            default:
                break;
        }
    }


    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle("出租车辆");
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
