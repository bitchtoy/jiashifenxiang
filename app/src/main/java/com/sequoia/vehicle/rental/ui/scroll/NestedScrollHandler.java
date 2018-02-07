package com.sequoia.vehicle.rental.ui.scroll;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * @author Administrator.
 * @date 2018/1/30.
 * @funtion
 */

public class NestedScrollHandler implements NestedScrollView.OnScrollChangeListener {
    private final NestedScrollView NEST_SCROLL_VIEW;
    private final Toolbar TOOL_BAR;
    private final TextView TEXT_VIEW;
    private final int HEIGHT = 150;
    private final int COLOR;

    private NestedScrollHandler(NestedScrollView view, Toolbar toolbar, TextView textView, @ColorInt int color) {
        this.NEST_SCROLL_VIEW = view;
        this.TOOL_BAR = toolbar;
        this.TEXT_VIEW = textView;
        this.COLOR = color;
        this.NEST_SCROLL_VIEW.setOnScrollChangeListener(this);
    }

    public static NestedScrollHandler create(NestedScrollView view, Toolbar toolbar, TextView textView, @ColorInt int color) {
        return new NestedScrollHandler(view, toolbar, textView, color);
    }

    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrollY < HEIGHT) {
            TEXT_VIEW.setVisibility(View.GONE);
            TOOL_BAR.setBackgroundColor(colorAlpha(COLOR, 0f));
        } else if (scrollY > HEIGHT) {
            TEXT_VIEW.setVisibility(View.VISIBLE);
            TOOL_BAR.setBackgroundColor(colorAlpha(COLOR, 1.0f));
        }
    }

    /**
     * 根据百分比改变颜色透明度
     */
    public int colorAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }
}
