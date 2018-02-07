package com.sequoia.vehicle.rental.entities.multiple;

import com.sequoia.vehicle.rental.base.MultipleItemBean;
import com.sequoia.vehicle.rental.ui.recycler.ItemStyle;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion
 */

public class InvestorBean extends MultipleItemBean {
    @Override
    public int getItemType() {
        return ItemStyle.MULTIPLE_INVESTOR;
    }
}
