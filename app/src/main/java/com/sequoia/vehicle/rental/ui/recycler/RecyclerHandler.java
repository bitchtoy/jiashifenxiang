package com.sequoia.vehicle.rental.ui.recycler;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * @author Administrator.
 * @date 2018/1/30.
 * @funtion
 */

public class RecyclerHandler extends RecyclerView.OnScrollListener {

    private final Toolbar TOOL_BAR;
    private final TextView TEXT_VIEW;
    private final int COLOR;
    private int slideHeight = 0;

    private RecyclerHandler(RecyclerView recyclerView, Toolbar toolbar, TextView textView, @ColorInt int color) {
        this.TOOL_BAR = toolbar;
        this.TEXT_VIEW = textView;
        this.COLOR = color;
        recyclerView.addOnScrollListener(this);

    }

    public static RecyclerHandler create(RecyclerView recyclerView, Toolbar toolbar, TextView textView, @ColorInt int color) {
        return new RecyclerHandler(recyclerView, toolbar, textView, color);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        final int height = recyclerView.getLayoutManager().getChildAt(0).getHeight();
        slideHeight += dy;
        if (slideHeight == 0) {
            if (TEXT_VIEW != null) {
                TEXT_VIEW.setVisibility(View.GONE);
            }
            TOOL_BAR.setBackgroundColor(colorAlpha(COLOR, 0f));
        } else if (slideHeight < height) {
            if (TEXT_VIEW != null) {
                TEXT_VIEW.setVisibility(View.VISIBLE);
            }
            TOOL_BAR.setBackgroundColor(colorAlpha(COLOR, Math.abs(slideHeight * 1.0f) / height));
        } else if (slideHeight > height) {
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
