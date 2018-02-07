package com.sequoia.vehicle.rental.ui.recycler;

import com.choices.divider.Divider;
import com.choices.divider.DividerItemDecoration;

/**
 * @author weber
 * @date 2017/11/7
 * @function
 */

public class DividerLookupImpl implements DividerItemDecoration.DividerLookup {
    private final int COLOR;
    private final int SIZE;
    private final int START;
    private final int END;

    public DividerLookupImpl(int marginStart, int marginEnd, int color, int size) {
        this.COLOR = color;
        this.SIZE = size;
        this.START = marginStart;
        this.END = marginEnd;
    }

    @Override
    public Divider getVerticalDivider(int position) {
        return new Divider
                .Builder()
                .size(SIZE)
                .color(COLOR)
                .margin(START, END)
                .build();
    }

    @Override
    public Divider getHorizontalDivider(int position) {
        return new Divider
                .Builder()
                .margin(START, END)
                .size(SIZE)
                .color(COLOR)
                .build();
    }
}
