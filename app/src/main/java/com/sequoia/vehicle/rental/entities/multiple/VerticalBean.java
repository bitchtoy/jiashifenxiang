package com.sequoia.vehicle.rental.entities.multiple;

import com.sequoia.vehicle.rental.base.MultipleItemBean;
import com.sequoia.vehicle.rental.entities.HorizontalBean;
import com.sequoia.vehicle.rental.ui.recycler.ItemStyle;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion
 */

public class VerticalBean extends MultipleItemBean {
    public String title;
    public int tag;
    public List<HorizontalBean> mHorizontalBeen;

    public VerticalBean(int tag,String title, List<HorizontalBean> been) {
        this.tag = tag;
        this.title = title;
        this.mHorizontalBeen = been;
    }

    @Override
    public int getItemType() {
        return ItemStyle.MULTIPLE_VERTICAL;
    }
}
