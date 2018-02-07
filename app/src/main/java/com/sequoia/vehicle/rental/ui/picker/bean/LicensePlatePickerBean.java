package com.sequoia.vehicle.rental.ui.picker.bean;

import com.bigkoo.pickerview.model.IPickerViewData;

/**
 * @author Administrator.
 * @date 2018/1/23.
 * @funtion
 */

public class LicensePlatePickerBean implements IPickerViewData {

    public String name;

    @Override
    public String getPickerViewText() {
        return name;
    }
}
