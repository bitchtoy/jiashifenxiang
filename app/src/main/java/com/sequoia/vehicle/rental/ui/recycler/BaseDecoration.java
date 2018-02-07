package com.sequoia.vehicle.rental.ui.recycler;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * @author weber
 * @date 2017/11/7
 * @function
 */

public class BaseDecoration extends DividerItemDecoration {

    private BaseDecoration(int start, int end, @ColorInt int color, int size) {
        setDividerLookup(new DividerLookupImpl(start, end, color, size));
    }

    public static BaseDecoration create(int start, int end, @ColorInt int color, int size) {
        return new BaseDecoration(start, end, color, size);
    }
}
