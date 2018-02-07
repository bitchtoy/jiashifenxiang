package com.sequoia.vehicle.rental.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import java.util.regex.Pattern;

/**
 * @author Administrator.
 * @date 2018/2/1.
 * @funtion
 */

public class BaseFragment extends Fragment {
    protected Activity mActivity = null;

    private static Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
    private static final Pattern PATTEN = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    public static boolean isNumber(String str,boolean isInteger) {
        if (isInteger) {
            return pattern.matcher(str).matches();
        }else {
            return PATTEN.matcher(str).matches();
        }
    }
}
