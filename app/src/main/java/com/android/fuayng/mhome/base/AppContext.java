package com.android.fuayng.mhome.base;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.PersistentCookieStore;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
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

        //---------这里给出的是示例代码,告诉你可以这么传,实际使用的时候,根据需要传,不需要就不传-------------//
        HttpHeaders headers = new HttpHeaders();
        headers.put("commonHeaderKey1", "commonHeaderValue1");    //header不支持中文
        headers.put("commonHeaderKey2", "commonHeaderValue2");
        HttpParams params = new HttpParams();
        params.put("commonParamsKey1", "commonParamsValue1");     //param支持中文,直接传,不要自己编码
        params.put("commonParamsKey2", "这里支持中文参数");
        //-----------------------------------------------------------------------------------//
        OkGo.init(this);

        //以下设置的所有参数是全局参数,同样的参数可以在请求的时候再设置一遍,那么对于该请求来讲,请求中的参数会覆盖全局参数
        //好处是全局参数统一,特定请求可以特别定制参数
        try {
            //以下都不是必须的，根据需要自行选择,一般来说只需要 debug,缓存相关,cookie相关的 就可以了
            OkGo.getInstance()
                    //打开该调试开关,控制台会使用 红色error 级别打印log,并不是错误,是为了显眼,不需要就不要加入该行
                    .debug("OkGo")
                    //如果使用默认的 60秒,以下三行也不需要传
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)  //全局的连接超时时间
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)     //全局的读取超时时间
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)    //全局的写入超时时间
                    //可以全局统一设置缓存模式,默认是不使用缓存,可以不传,具体其他模式看 github 介绍 https://github.com/jeasonlzy/
                    .setCacheMode(CacheMode.NO_CACHE)
                    //可以全局统一设置缓存时间,默认永不过期,具体使用方法看 github 介绍
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                    .setCookieStore(new PersistentCookieStore());          //cookie持久化存储，如果cookie不过期，则一直有效
        } catch (Exception e) {
            e.printStackTrace();
        }

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
