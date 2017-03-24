package com.android.fuayng.mhome.fargment;

import com.android.fuayng.mhome.R;
import com.android.fuayng.mhome.base.BaseFragment;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;

/**
 * 作者：SYC on 2017/3/24 09:50
 * 类名：
 * 用途：
 */

public class Profilefargment extends BaseFragment {
    @Override
    protected int initXML() {
        return R.layout.profile_fragment;
    }

    @Override
    protected void init() {
        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(getActivity()).setShareConfig(config);
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }
}
