package com.sequoia.vehicle.rental.adapter;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.sequoia.vehicle.rental.R;
import com.sequoia.vehicle.rental.base.MultipleItemBean;
import com.sequoia.vehicle.rental.entities.multiple.BannerBean;
import com.sequoia.vehicle.rental.ui.banner.BannerCreator;
import com.sequoia.vehicle.rental.ui.recycler.ItemStyle;
import com.sequoia.vehicle.rental.ui.recycler.RecyclerViewHolder;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/2/2.
 * @funtion
 */

public class LeaseMultipleAdapter extends BaseMultiItemQuickAdapter<MultipleItemBean, RecyclerViewHolder> {
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

    public LeaseMultipleAdapter(List<MultipleItemBean> data) {
        super(data);
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
        addItemType(ItemStyle.MULTIPLE_LEASE, R.layout.adapter_multiple_lease);
        addItemType(ItemStyle.MULTIPLE_FOOT, R.layout.adapter_multiple_foot);
    }

    @Override
    protected void convert(RecyclerViewHolder helper, MultipleItemBean item) {
        switch (helper.getItemViewType()) {

            case ItemStyle.MULTIPLE_LEASE:
                break;
            case ItemStyle.MULTIPLE_FOOT:
                break;
            default:
                break;
        }
    }
}
