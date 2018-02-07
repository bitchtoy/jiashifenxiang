package com.sequoia.vehicle.rental.entities.multiple;

import com.sequoia.vehicle.rental.base.MultipleItemBean;
import com.sequoia.vehicle.rental.ui.recycler.ItemStyle;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion
 */

public class VehicleBean extends MultipleItemBean {

    public String image1;
    public String image2;
    public String title1;
    public String title2;
    public String desc1;
    public String desc2;

    @Override
    public int getItemType() {
        return ItemStyle.MULTIPLE_VEHICLE;
    }
}
