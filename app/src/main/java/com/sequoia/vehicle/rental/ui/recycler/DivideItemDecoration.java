package com.sequoia.vehicle.rental.ui.recycler;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author Administrator.
 * @date 2018/1/21.
 * @funtion
 */

public class DivideItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //因为适配的原因具体的数值会改变
        //所以取每个item的getPaddingRight()
        //设定的recyclerView 的左右的距离是getPaddingRight 的1.5倍
        //所以左的就是1.5倍而最后一个item已经有1倍的偏移 再只需偏移0.5

        //该View在整个RecyclerView中位置。
        int padding = view.getPaddingRight();

        int pos = parent.getChildAdapterPosition(view);
        if (pos == 0) {
            outRect.left = (int) (padding * 1.5d);
        }
        if (pos == parent.getAdapter().getItemCount() - 1) {
            outRect.right = (int) (padding / 2.0);
        }
    }
}