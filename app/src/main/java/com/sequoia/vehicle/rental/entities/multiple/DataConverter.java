package com.sequoia.vehicle.rental.entities.multiple;

import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.MultipleItemBean;
import com.sequoia.vehicle.rental.entities.HorizontalBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion
 */

public class DataConverter {
    public static ArrayList<MultipleItemBean> getHomeData() {
        ArrayList<MultipleItemBean> list = new ArrayList<>();
        ArrayList<Integer> ba = new ArrayList<>();

        ba.add(R.drawable.rent_bg_banner);
        ba.add(R.drawable.test);

        BannerBean bannerBean = new BannerBean();
        bannerBean.banner = ba;
        list.add(bannerBean);
        list.add(new FindCarBean());
        list.add(new VehicleBean());
        ArrayList<String> bb = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            bb.add("感谢大家关注嘉时分享app，我们将于2018年4月02日正式上线！我们将于2018年4月02日正式上线！");
        }
        BulletinBean bulletinBean = new BulletinBean();
        bulletinBean.bulletin = bb;
        list.add(bulletinBean);
        List<HorizontalBean> been0 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            HorizontalBean bean = new HorizontalBean(0,"￥799/日", "￥999万", "可获租金￥8888元/元", "河北石家庄");
            been0.add(bean);
        }
        list.add(new VerticalBean(0, "省心优选", been0));
        List<HorizontalBean> been1 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            HorizontalBean bean = new HorizontalBean(1,"￥799/日", "￥999万", "可获租金￥8888元/元", "河北石家庄");
            been1.add(bean);
        }
        list.add(new VerticalBean(1, "投资优选", been1));
        list.add(new FootBean());
        return list;
    }

    public static ArrayList<MultipleItemBean> getHomeData2() {
        ArrayList<MultipleItemBean> list = new ArrayList<>();
        ArrayList<Integer> ba = new ArrayList<>();

        ba.add(R.drawable.rent_bg_banner);
        ba.add(R.drawable.test);

        BannerBean bannerBean = new BannerBean();
        bannerBean.banner = ba;
        list.add(bannerBean);
        list.add(bannerBean);
        list.add(new FindCarBean());
        list.add(new VehicleBean());
        ArrayList<String> bb = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            bb.add("感谢大家关注嘉时分享app，我们将于2018年4月02日正式上线！");
        }
        BulletinBean bulletinBean = new BulletinBean();
        bulletinBean.bulletin = bb;
        list.add(bulletinBean);
        List<HorizontalBean> been0 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            HorizontalBean bean = new HorizontalBean(0,"￥799/日", "￥999万", "可获租金￥8888元/元", "河北石家庄");
            been0.add(bean);
        }
        list.add(new VerticalBean(0, "省心优选", been0));
        List<HorizontalBean> been1 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            HorizontalBean bean = new HorizontalBean(1,"￥799/日", "￥999万", "可获租金￥8888元/元", "河北石家庄");
            been1.add(bean);
        }
        list.add(new VerticalBean(1, "投资优选", been1));
        list.add(new FootBean());
        return list;
    }


    public static ArrayList<MultipleItemBean> getAuditData() {
        ArrayList<MultipleItemBean> list = new ArrayList<>();
        list.add(new AuditBean());
        list.add(new AuditBean());
        list.add(new AuditBean());
        list.add(new AuditBean());
        list.add(new AuditBean());
        list.add(new AuditBean());
        list.add(new AuditBean());
        list.add(new AuditBean());
        list.add(new AuditBean());
        list.add(new AuditBean());
        list.add(new FootBean());
        return list;
    }

    public static ArrayList<MultipleItemBean> getInvestorData() {
        ArrayList<MultipleItemBean> list = new ArrayList<>();
        ArrayList<Integer> ba = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ba.add(R.drawable.banner_touzi);
        }
        BannerBean bannerBean = new BannerBean();
        bannerBean.banner = ba;
        list.add(bannerBean);
        list.add(new InvestorBean());
        list.add(new InvestorBean());
        list.add(new InvestorBean());
        list.add(new InvestorBean());
        list.add(new InvestorBean());
        list.add(new InvestorBean());
        list.add(new InvestorBean());
        list.add(new InvestorBean());
        list.add(new InvestorBean());
        list.add(new InvestorBean());
        list.add(new InvestorBean());
        list.add(new FootBean());
        return list;
    }

    public static ArrayList<MultipleItemBean> getLeaseData() {
        ArrayList<MultipleItemBean> list = new ArrayList<>();
        list.add(new LeaseBean());
        list.add(new LeaseBean());
        list.add(new LeaseBean());
        list.add(new LeaseBean());
        list.add(new LeaseBean());
        list.add(new LeaseBean());
        list.add(new LeaseBean());
        list.add(new LeaseBean());
        list.add(new FootBean());
        return list;
    }
}
