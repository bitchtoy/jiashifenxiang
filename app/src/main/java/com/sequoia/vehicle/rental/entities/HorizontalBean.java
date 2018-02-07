package com.sequoia.vehicle.rental.entities;

/**
 * @author Administrator.
 * @date 2018/1/30.
 * @funtion
 */

public class HorizontalBean {
    public int tag;
    public String rent;
    public String totalMoney;
    public String totalRent;
    public String address;

    public HorizontalBean(int tag, String rent, String totalMoney, String totalRent, String address) {
        this.tag = tag;
        this.rent = rent;
        this.totalMoney = totalMoney;
        this.totalRent = totalRent;
        this.address = address;
    }
}
