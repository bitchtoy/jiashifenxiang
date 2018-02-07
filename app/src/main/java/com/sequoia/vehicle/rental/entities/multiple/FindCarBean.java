package com.sequoia.vehicle.rental.entities.multiple;

import android.annotation.SuppressLint;

import com.sequoia.vehicle.rental.base.MultipleItemBean;
import com.sequoia.vehicle.rental.ui.recycler.ItemStyle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion
 */

public class FindCarBean extends MultipleItemBean {

    @SuppressLint("SimpleDateFormat")
    private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    public String startTime;
    public String endTime;
    private long days = 0;

    public long getDays() {
        if (startTime == null || endTime == null) {
            return 0;
        }
        Calendar calendar = new GregorianCalendar();
        try {
            Date start = FORMATTER.parse(startTime);
            Date end = FORMATTER.parse(endTime);
            days = (end.getTime() - start.getTime()) / (60 * 60 * 1000 * 24);
            return days;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

    }
    @Override
    public int getItemType() {
        return ItemStyle.MULTIPLE_FIND_CAR;
    }
}
