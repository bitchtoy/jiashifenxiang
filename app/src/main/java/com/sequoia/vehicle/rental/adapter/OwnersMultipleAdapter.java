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

public class OwnersMultipleAdapter extends BaseMultiItemQuickAdapter<MultipleItemBean, RecyclerViewHolder> {
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

    public OwnersMultipleAdapter(List<MultipleItemBean> data) {
        super(data);
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
        addItemType(ItemStyle.MULTIPLE_BANNER, R.layout.adapter_multiple_banner);
        addItemType(ItemStyle.MULTIPLE_FIND_CAR, R.layout.adapter_multiple_find_car);
        addItemType(ItemStyle.MULTIPLE_VEHICLE, R.layout.adapter_multiple_vehicle);
        addItemType(ItemStyle.MULTIPLE_BULLETIN, R.layout.adapter_multiple_bulletin);
        addItemType(ItemStyle.MULTIPLE_VERTICAL, R.layout.adapter_multiple_vertical);
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
            case ItemStyle.MULTIPLE_FIND_CAR:
                helper.addOnClickListener(R.id.tv_city);
                helper.addOnClickListener(R.id.tv_start_time);
                helper.addOnClickListener(R.id.tv_end_time);
                helper.addOnClickListener(R.id.btn_find_car);
                break;
            case ItemStyle.MULTIPLE_VEHICLE:
                helper.addOnClickListener(R.id.left_layout);
                helper.addOnClickListener(R.id.right_layout);
                break;
            case ItemStyle.MULTIPLE_BULLETIN:
                final BulletinBean bulletinBean = (BulletinBean) item;
                final AdapterViewFlipper flipper = helper.getView(R.id.bulletin_flipper);
                final FlipperAdapter flipperAdapter = new FlipperAdapter(mContext, bulletinBean.bulletin);
                flipper.setAdapter(flipperAdapter);
                flipper.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                });
                break;
            case ItemStyle.MULTIPLE_VERTICAL:

                VerticalBean verticalBean = (VerticalBean) item;
                TextView tv = helper.getView(R.id.title);
                tv.setText(verticalBean.title);
                final RecyclerView recyclerView = helper.getView(R.id.recycler_View);


                LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                recyclerView.setLayoutManager(manager);

                HorizontalAdapter horizontalAdapter =
                        new HorizontalAdapter(R.layout.adapter_horizontal_item, verticalBean.mHorizontalBeen);

                recyclerView.setAdapter(horizontalAdapter);
                recyclerView.addItemDecoration(new DivideItemDecoration());
                horizontalAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        HorizontalBean bean = (HorizontalBean) adapter.getData().get(position);
//                        if (bean.tag == 0) {
//                            mContext.startActivity(new Intent(mContext, LeaseDetailsActivity.class));
//                        } else {
//                            mContext.startActivity(new Intent(mContext, InvestorDetailsActivity.class));
//                        }
                    }
                });
                break;
            case ItemStyle.MULTIPLE_FOOT:
                break;
            default:
                break;
        }
    }
}
