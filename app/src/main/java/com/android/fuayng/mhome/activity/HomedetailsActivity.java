package com.android.fuayng.mhome.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.ABaseTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.android.fuayng.mhome.R;
import com.android.fuayng.mhome.adapter.HomeListAdapter;
import com.android.fuayng.mhome.base.BaseActivity;
import com.android.fuayng.mhome.bean.LieBiaoBean;
import com.android.fuayng.mhome.utils.NetworkImageHolderView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：SYC on 2017/3/24 13:07
 * 类名：
 * 用途：
 */

public class HomedetailsActivity extends BaseActivity implements OnItemClickListener {
    // 控制ToolBar的变量
    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.7f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;

    private static final int ALPHA_ANIMATIONS_DURATION = 150;
    @BindView(R.id.toolbar_lin)
    LinearLayout toolbarLin;
    @BindView(R.id.main_iv_placeholder)
    ImageView mainIvPlaceholder;

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;
    @BindView(R.id.main_ll_title_container)
    LinearLayout mLlTitleContainer;
    @BindView(R.id.main_fl_title)
    FrameLayout mFlTitleContainer;
    @BindView(R.id.main_abl_app_bar)
    AppBarLayout mAblAppBar;
    @BindView(R.id.main_tv_toolbar_title)
    TextView mTvToolbarTitle;
    @BindView(R.id.main_tb_toolbar)
    Toolbar mTbToolbar;
    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;//顶部广告栏控件
    private List<String> networkImages;
    private String[] images = {"http://www.fortune-sun.com/upload/201608/1471498485.jpg",
            "http://www.fortune-sun.com/upload/201608/1471498540.jpg",
            "http://www.fortune-sun.com/upload/201608/1471498245.jpg",
    };
    private ArrayList<String> transformerList = new ArrayList<String>();

    @BindView(R.id.liebiao_lv)
    ListView liebiaoLv;
    private List<LieBiaoBean> mList = new ArrayList<>();
    private LieBiaoBean lieBiaoBean;
    private HomeListAdapter liebiapAdapter;

    @Override
    protected void initSetView(Bundle savedInstanceState) {
        setContentView(R.layout.acticity_homedetails);
        ButterKnife.bind(this);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView() {
        mTbToolbar.setTitle("");
        // AppBar的监听
        mAblAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int maxScroll = appBarLayout.getTotalScrollRange();
                float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
                handleAlphaOnTitle(percentage);
                handleToolbarTitleVisibility(percentage);
            }
        });

        initParallaxValues(); // 自动滑动效果
        networkImages = Arrays.asList(images);
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, networkImages).setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                //.setOnPageChangeListener(this)//监听翻页事件
                .setOnItemClickListener(this);
        //动画效果
        transformerList.add(StackTransformer.class.getSimpleName());

        liebiapAdapter = new HomeListAdapter(this, mList);
        liebiaoLv.setAdapter(liebiapAdapter);
        liebiaoLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivity(HomedetailsActivity.class);
            }
        });

    }


    @Override
    protected void initListener() {
        mainIvPlaceholder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        lieBiaoBean = new LieBiaoBean();
        lieBiaoBean.setImgurl("http://www.shboloni.com/d/file/contents/2015/11/564e7ce07270e.jpg");
        lieBiaoBean.setPrice("50万");
        lieBiaoBean.setTitle("精装房屋");
        mList.add(lieBiaoBean);
        LieBiaoBean lieBiaoBean1 = new LieBiaoBean();
        lieBiaoBean1.setImgurl("http://www.shboloni.com/d/file/contents/2015/11/564e7ce07270e.jpg");
        lieBiaoBean1.setPrice("50万");
        lieBiaoBean1.setTitle("精装房屋");
        mList.add(lieBiaoBean1);
        LieBiaoBean lieBiaoBean2 = new LieBiaoBean();
        lieBiaoBean2.setImgurl("http://www.shboloni.com/d/file/contents/2015/11/564e7ce07270e.jpg");
        lieBiaoBean2.setPrice("50万");
        lieBiaoBean2.setTitle("精装房屋");
        mList.add(lieBiaoBean2);
        LieBiaoBean lieBiaoBean3 = new LieBiaoBean();
        lieBiaoBean3.setImgurl("http://www.shboloni.com/d/file/contents/2015/11/564e7ce07270e.jpg");
        lieBiaoBean3.setPrice("50万");
        lieBiaoBean3.setTitle("精装房屋");
        mList.add(lieBiaoBean3);
        LieBiaoBean lieBiaoBean4 = new LieBiaoBean();
        lieBiaoBean4.setImgurl("http://www.shboloni.com/d/file/contents/2015/11/564e7ce07270e.jpg");
        lieBiaoBean4.setPrice("50万");
        lieBiaoBean4.setTitle("精装房屋");
        mList.add(lieBiaoBean4);
    }

    // 设置自动滑动的动画效果
    private void initParallaxValues() {
        CollapsingToolbarLayout.LayoutParams petDetailsLp =
                (CollapsingToolbarLayout.LayoutParams) convenientBanner.getLayoutParams();

        CollapsingToolbarLayout.LayoutParams petBackgroundLp =
                (CollapsingToolbarLayout.LayoutParams) convenientBanner.getLayoutParams();

        petDetailsLp.setParallaxMultiplier(0.9f);
        petBackgroundLp.setParallaxMultiplier(0.3f);

        convenientBanner.setLayoutParams(petDetailsLp);
        mFlTitleContainer.setLayoutParams(petBackgroundLp);
    }

    // 处理ToolBar的显示
    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {
            if (!mIsTheTitleVisible) {
                startAlphaAnimation(mTvToolbarTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mTbToolbar.setVisibility(View.VISIBLE);
                toolbarLin.setVisibility(View.GONE);
                mIsTheTitleVisible = true;
            }
        } else {
            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTvToolbarTitle, ALPHA_ANIMATIONS_DURATION, View.GONE);
                toolbarLin.setVisibility(View.VISIBLE);
                mTbToolbar.setVisibility(View.GONE);
                mIsTheTitleVisible = false;
            }
        }
    }

    // 控制Title的显示
    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(mLlTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }
        } else {
            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mLlTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    // 设置渐变的动画
    public static void startAlphaAnimation(View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }


    @Override
    public void onItemClick(int position) {
        String transforemerName = transformerList.get(0);
        try {
            Class cls = Class.forName("com.ToxicBakery.viewpager.transforms." + transforemerName);
            ABaseTransformer transforemer = (ABaseTransformer) cls.newInstance();
            convenientBanner.getViewPager().setPageTransformer(true, transforemer);
            convenientBanner.setScrollDuration(1200);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Fragment.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(2000);
    }

    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        convenientBanner.stopTurning();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
