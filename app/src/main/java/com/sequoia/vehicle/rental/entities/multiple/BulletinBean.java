package com.sequoia.vehicle.rental.entities.multiple;

import com.sequoia.vehicle.rental.base.MultipleItemBean;
import com.sequoia.vehicle.rental.ui.recycler.ItemStyle;

import java.util.ArrayList;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion
 */

public class BulletinBean extends MultipleItemBean {

    public ArrayList<String> bulletin;

    @Override
    public int getItemType() {
        return ItemStyle.MULTIPLE_BULLETIN;
    }
}
