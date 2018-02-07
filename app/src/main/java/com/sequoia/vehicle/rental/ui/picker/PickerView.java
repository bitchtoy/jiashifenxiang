package com.sequoia.vehicle.rental.ui.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.sequoia.vehicle.rental.ui.picker.bean.LicensePlatePickerBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator.
 * @date 2018/1/23.
 * @funtion
 */

public class PickerView {

    private static final String[] PROVINCE = {"京", "津", "冀", "沪", "渝", "豫", "云", "辽", "黑", "湘", " 皖", "鲁", "新", "苏", "浙", "赣", " 鄂", "桂", "甘", "晋", "蒙", "陕", "吉", "闽", "贵", "粤", "青", "藏", "川", "宁", "琼"};
    private static final String[] LETTER = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    @SuppressLint("SimpleDateFormat")
    public static TimePickerView createTimePickerView(Context context) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Calendar selectedDate = Calendar.getInstance();

        Calendar startDate = Calendar.getInstance();
        startDate.set(2000, 0, 1);
        TimePickerView pvTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                if (v != null) {
                    TextView tv = (TextView) v;
                    tv.setText(simpleDateFormat.format(date));
                }
            }
        })
                .setType(new boolean[]{true, false, false, false, false, false})
                .setCancelText("取消")
                .setSubmitText("完成")
                .setContentSize(16)
                .setTitleSize(16)
                .setTitleText("购车年份")
                .setTitleColor(Color.parseColor("#333333"))
                .setSubmitColor(Color.parseColor("#FF5C60"))
                .setTitleBgColor(Color.WHITE)
                .setCancelColor(Color.parseColor("#FF5C60"))
                .setDate(selectedDate)
                .setRangDate(startDate, selectedDate)
                .setLabel("", "", "", "", "", "")
                .build();
        return pvTime;
    }

    @SuppressWarnings("unchecked")
    public static OptionsPickerView createLicensePlatePicker(final Context context) {
        final List<LicensePlatePickerBean> provinces = new ArrayList<>();
        final List<LicensePlatePickerBean> letters = new ArrayList<>();
        for (int i = 0; i < PROVINCE.length; i++) {
            LicensePlatePickerBean bean = new LicensePlatePickerBean();
            bean.name = PROVINCE[i].trim();
            provinces.add(bean);
        }
        for (int i = 0; i < LETTER.length; i++) {
            LicensePlatePickerBean bean = new LicensePlatePickerBean();
            bean.name = LETTER[i].trim();
            letters.add(bean);
        }

        OptionsPickerView mPickerView = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                if (v != null) {
                    TextView tv = (TextView) v;
                    tv.setText(String.format("%s%s", provinces.get(options1).name, letters.get(options2).name));
                }
            }
        })
                .setCancelText("取消")
                .setSubmitText("完成")
                .setTitleSize(16)
                .setTitleText("车牌")
                .setTitleColor(Color.parseColor("#333333"))
                .setSubmitColor(Color.parseColor("#FF5C60"))
                .setTitleBgColor(Color.WHITE)
                .setCancelColor(Color.parseColor("#FF5C60"))
                //默认选中项
                .setSelectOptions(0, 0)
                //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isCenterLabel(false)
                .setLabels("", "", "")
                //设置外部遮罩颜色
                .setBackgroundId(0x66000000)
                .build();
        mPickerView.setNPicker(provinces, letters, null);
        return mPickerView;
    }

}
