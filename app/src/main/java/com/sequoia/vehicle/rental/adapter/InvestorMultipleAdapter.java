package com.sequoia.vehicle.rental.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.MultipleItemBean;
import com.sequoia.vehicle.rental.entities.HorizontalBean;
import com.sequoia.vehicle.rental.entities.multiple.BannerBean;
import com.sequoia.vehicle.rental.entities.multiple.BulletinBean;
import com.sequoia.vehicle.rental.entities.multiple.VerticalBean;
import com.sequoia.vehicle.rental.ui.banner.BannerCreator;
import com.sequoia.vehicle.rental.ui.recycler.DivideItemDecoration;
import com.sequoia.vehicle.rental.ui.recycler.ItemStyle;
import com.sequoia.vehicle.rental.ui.recycler.RecyclerViewHolder;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion
 */

public class InvestorMultipleAdapter extends BaseMultiItemQuickAdapter<MultipleItemBean, RecyclerViewHolder> {
    /**
     * 确保初始化一次Banner，防止重复Item加载
     */
    private boolean mIsInitBanner = false;
    /**
     * 设置图片加载策略
     */
    private static final RequestOptions RECYCLER_OPTIONS = new RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate();

    public InvestorMultipleAdapter(List<MultipleItemBean> data) {
        super(data);
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
        addItemType(ItemStyle.MULTIPLE_BANNER, R.layout.adapter_multiple_banner);
        addItemType(ItemStyle.MULTIPLE_INVESTOR, R.layout.adapter_multiple_investor);
        addItemType(ItemStyle.MULTIPLE_FOOT, R.layout.adapter_multiple_foot);
    }

    @Override
    protected void convert(RecyclerViewHolder helper, MultipleItemBean item) {
        switch (helper.getItemViewType()) {
            case ItemStyle.MULTIPLE_BANNER:
                if (!mIsInitBanner) {
                    ConvenientBanner<Integer> banner = helper.getView(R.id.banner_item);
                    BannerBean bannerBean = (BannerBean) item;
                    BannerCreator.setDefault(banner, bannerBean.banner, null);
                    mIsInitBanner = true;
                }
                break;
            case ItemStyle.MULTIPLE_INVESTOR:
                break;
            case ItemStyle.MULTIPLE_FOOT:
                break;
            default:
                break;
        }
    }
}
