package com.android.fuayng.mhome.fargment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.ABaseTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.android.fuayng.mhome.R;
import com.android.fuayng.mhome.activity.HomedetailsActivity;
import com.android.fuayng.mhome.adapter.HomeListAdapter;
import com.android.fuayng.mhome.base.BaseFragment;
import com.android.fuayng.mhome.bean.LieBiaoBean;
import com.android.fuayng.mhome.utils.NetworkImageHolderView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：SYC on 2017/3/24 09:40
 * 类名：首页的Fragment
 * 用途：
 */

public class Homefargment extends BaseFragment implements OnItemClickListener, ViewPager.OnPageChangeListener, View.OnClickListener {
    @BindView(R.id.xin_tv)
    TextView xinTv;
    @BindView(R.id.er_tv)
    TextView erTv;
    @BindView(R.id.zu_tv)
    TextView zuTv;
    private GridView homeGridview;

    private ArrayList<Integer> localImages = new ArrayList<>();
    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;//顶部广告栏控件
    private List<String> networkImages;
    private String[] images = {"http://www.fortune-sun.com/upload/201608/1471498485.jpg",
            "http://www.fortune-sun.com/upload/201608/1471498540.jpg",
            "http://www.fortune-sun.com/upload/201608/1471498245.jpg",
    };
    private ListView listView;
    private ArrayAdapter transformerArrayAdapter;
    //四个标签图封装一个图片数组
    private int[] icon = {R.mipmap.icon_buy, R.mipmap.icon_order,
            R.mipmap.icon_rent, R.mipmap.icon_upload};
    private String[] iconName = {"BUY", "RENT", "ORDER", "UPLOAD"};
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    private ArrayList<String> transformerList = new ArrayList<String>();
    @BindView(R.id.liebiao_lv)
    ListView liebiaoLv;
    private List<LieBiaoBean> mList = new ArrayList<>();
    private LieBiaoBean lieBiaoBean;
    private HomeListAdapter liebiapAdapter;

    @Override
    protected int initXML() {
        return R.layout.home_fragment;
    }

    @Override
    protected void init() {
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

    @Override
    protected void initView() {
        xinTv.setFocusable(true);
        xinTv.setFocusableInTouchMode(true);
        xinTv.requestFocus();
        liebiapAdapter = new HomeListAdapter(getActivity(), mList);
        liebiaoLv.setAdapter(liebiapAdapter);
        liebiaoLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    openActivity(HomedetailsActivity.class);
            }
        });
    }

    @Override
    protected void initData() {
        //xin_tv.s

        homeGridview = (GridView) mView.findViewById(R.id.home_gridview);
        networkImages = Arrays.asList(images);

        convenientBanner.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
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

        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"image", "text"};
        int[] to = {R.id.home_icon, R.id.home_textview};
        sim_adapter = new SimpleAdapter(getActivity(), data_list, R.layout.homegrid_item, from, to);
        //配置适配器
        homeGridview.setAdapter(sim_adapter);
        homeGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // openActivity(DetailsActivity.class);
            }
        });
    }

    public List<Map<String, Object>> getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }

    @Override
    protected void initEvent() {

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
    public void onItemClick(int position) {
        String transforemerName = transformerList.get(0);
        try {
            Class cls = Class.forName("com.ToxicBakery.viewpager.transforms." + transforemerName);
            ABaseTransformer transforemer = (ABaseTransformer) cls.newInstance();
            convenientBanner.getViewPager().setPageTransformer(true, transforemer);
            convenientBanner.setScrollDuration(1200);
            // openActivity(SendActicity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        showToast("监听到翻到第" + position + "了");

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xin_tv:

                break;
            case R.id.er_tv:

                break;
            case R.id.zu_tv:

                break;
        }
    }
}
