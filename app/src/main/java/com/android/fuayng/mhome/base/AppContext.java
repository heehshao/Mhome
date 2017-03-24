package com.android.fuayng.mhome.base;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.umeng.socialize.Config;
import com.umeng.socialize.UMShareAPI;

import cn.jpush.android.api.JPushInterface;

/**
 * 作者：SYC on 2017/3/24 09:10
 * 类名：
 * 用途：
 */

public class AppContext extends Application {
    private static Context mContext;

    public static AppContext mApp;
    private static final String TAG = "AppContext";

    public static Typeface getMovieIcon() {
        return Typeface.createFromAsset(mApp.getAssets(), "movie_select_icon.ttf");
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        LeakCanary.install(this);
        mApp = this;
        //  Logger.init(TAG);
        UMShareAPI.get(mApp);
        Config.DEBUG = true;
        mContext = getApplicationContext();
//        GreenDaoManager.getInstance();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
//        MobclickAgent.setDebugMode(true);
//        MobclickAgent.setCatchUncaughtExceptions(true);
//        // SDK在统计Fragment时，需要关闭Activity自带的页面统计，
//        // 然后在每个页面中重新集成页面统计的代码(包括调用了 onResume 和 onPause 的Activity)。
//        MobclickAgent.openActivityDurationTrack(false);
//        //新浪微博 appkey appsecret
//        PlatformConfig.setWeixin(ConstantValue.WX_ID, ConstantValue.WX_SECRET);
//        PlatformConfig.setQQZone(ConstantValue.QQ_ID, ConstantValue.QQ_KEY);
//        PlatformConfig.setSinaWeibo(ConstantValue.XL_ID,ConstantValue.XL_SECRET);
    }

    public static Context getContext() {
        return mContext;
    }

}
