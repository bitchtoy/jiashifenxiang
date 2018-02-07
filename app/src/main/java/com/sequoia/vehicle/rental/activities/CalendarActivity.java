package com.sequoia.vehicle.rental.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.BaseActivity;
import com.sequoia.vehicle.rental.entities.multiple.FindCarBean;
import com.sequoia.vehicle.rental.ui.MySelectorDecorator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator.
 * @date 2018/2/4.
 * @funtion
 */

public class CalendarActivity extends BaseActivity implements OnDateSelectedListener {
    @SuppressLint("SimpleDateFormat")
    private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.tv_start_time)
    TextView mTvStartTime;
    @BindView(R.id.tv_lease_term)
    TextView mTvLeaseTerm;
    @BindView(R.id.tv_end_time)
    TextView mTvEndTime;
    @BindView(R.id.calendarView)
    MaterialCalendarView mCalendarView;
    @BindView(R.id.btn_con)
    QMUIRoundButton mBtnCon;

    private FindCarBean mFindCarBean = null;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        ButterKnife.bind(this);
        mCalendarView.setShowOtherDates(MaterialCalendarView.SHOW_ALL);
//        mCalendarView.addDecorators(
//                new MySelectorDecorator(this)
//        );
        mFindCarBean = (FindCarBean) getIntent().getSerializableExtra("FIND_CAR_TIME");
        int type = getIntent().getIntExtra("START_END", 0);
        Calendar calendar = Calendar.getInstance();
        if (mFindCarBean == null) {
            mFindCarBean = new FindCarBean();
        } else {
            if (mFindCarBean.startTime != null) {
                mTvStartTime.setText(mFindCarBean.startTime);
            }
            if (mFindCarBean.endTime != null) {
                mTvEndTime.setText(mFindCarBean.endTime);
            }
            if (mFindCarBean.getDays() > 0) {
                mTvLeaseTerm.setText(String.format("%d天", mFindCarBean.getDays()));
            }
        }
        try {
            if (type == 0) {
                mTvStartTime.setSelected(true);
                if (mFindCarBean.endTime != null) {
                    Date end = FORMATTER.parse(mFindCarBean.endTime);
                    mCalendarView.state().edit().setMinimumDate(Calendar.getInstance()).setMaximumDate(end).commit();
                } else {
                    mCalendarView.state().edit().setMinimumDate(Calendar.getInstance()).commit();
                }
            } else {
                mTvEndTime.setSelected(true);
                if (mFindCarBean.startTime != null) {
                    Date start = FORMATTER.parse(mFindCarBean.startTime);
                    mCalendarView.state().edit().setMinimumDate(start).commit();
                } else {
                    mCalendarView.state().edit().setMinimumDate(Calendar.getInstance()).commit();
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mCalendarView.setOnDateChangedListener(this);
        mTopBar.setTitle("请选择租赁时间");
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

        if (mTvStartTime.isSelected()) {
            if (mFindCarBean.endTime != null && getSelectedDatesString().equals(mFindCarBean.endTime)) {
                mCalendarView.clearSelection();
                Toast.makeText(this, "取车时间和还车时间不能是同一天，请重新选择!", Toast.LENGTH_SHORT).show();
                return;
            }
            mTvStartTime.setText(getSelectedDatesString());
            mFindCarBean.startTime = getSelectedDatesString();
        } else if (mTvEndTime.isSelected()) {
            if (mFindCarBean.startTime != null && getSelectedDatesString().equals(mFindCarBean.startTime)) {
                mCalendarView.clearSelection();
                Toast.makeText(this, "取车时间和还车时间不能是同一天，请重新选择!", Toast.LENGTH_SHORT).show();
                return;
            }
            mTvEndTime.setText(getSelectedDatesString());
            mFindCarBean.endTime = getSelectedDatesString();
        }
        if (mFindCarBean.getDays() > 0) {
            mTvLeaseTerm.setText(String.format("%d天", mFindCarBean.getDays()));
        }
    }

    private String getSelectedDatesString() {
        CalendarDay date = mCalendarView.getSelectedDate();
        if (date == null) {
            return "No Selection";
        }
        return FORMATTER.format(date.getDate());
    }

    @OnClick({R.id.tv_start_time, R.id.tv_end_time, R.id.btn_con})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_start_time:
                mTvStartTime.setSelected(true);
                mTvEndTime.setSelected(false);
                mCalendarView.clearSelection();
                try {
                    if (mFindCarBean != null && mFindCarBean.endTime != null) {
                        Date end = FORMATTER.parse(mFindCarBean.endTime);
                        mCalendarView.newState().setMinimumDate(Calendar.getInstance()).setMaximumDate(end).commit();
                    } else {
                        mCalendarView.newState().setMinimumDate(Calendar.getInstance()).commit();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.tv_end_time:
                mTvStartTime.setSelected(false);
                mTvEndTime.setSelected(true);
                try {
                    mTvEndTime.setSelected(true);
                    mCalendarView.clearSelection();
                    if (mFindCarBean != null && mFindCarBean.startTime != null) {
                        Date start = FORMATTER.parse(mFindCarBean.startTime);
                        mCalendarView.newState().setMinimumDate(start).commit();
                    } else {
                        mCalendarView.newState().setMinimumDate(Calendar.getInstance()).commit();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_con:
                Intent intent = new Intent();
                intent.putExtra("FIND_CAR_TIME", mFindCarBean);
                setResult(1000, intent);
                finish();
                break;
            default:
        }
    }
}
