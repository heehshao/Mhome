package com.android.fuayng.mhome.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.android.fuayng.mhome.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 作者：SYC on 2017/3/23 10:35
 * 类名：
 * 用途：
 */

public class GlideImageLoader  {
    private Context mContext;

    public GlideImageLoader(Context context) {
        this.mContext = context;
    }

    /**
     * 加载图片方法
     *
     * @param lodingImagerView
     * @param resourcesId      drawable中的图片id
     */
    public void display(ImageView lodingImagerView, int resourcesId) {//外部接口函数
        Glide.with(mContext)
                .load(resourcesId)
                .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
                .into(lodingImagerView);
    }

    /**
     * 加载图片方法
     *
     * @param lodingImagerView
     * @param picUrl
     */
    public void display(ImageView lodingImagerView, String picUrl) {//外部接口函数
        Glide.with(mContext)
                .load(picUrl)
                .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
//                .placeholder(R.color.loading_img_default_color)
                .placeholder(R.mipmap.loding_pic)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(lodingImagerView);
    }

    /**
     * 加载图片方法
     *
     * @param activity
     * @param lodingImagerView
     * @param picUrl
     */
    public void display(Activity activity, ImageView lodingImagerView, String picUrl) {//外部接口函数
        Glide.with(activity)
                .load(picUrl)
                .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
//              .placeholder(R.color.loading_img_default_color)
                .placeholder(R.mipmap.loding_pic)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(lodingImagerView);
    }

    /**
     * 加载图片方法，加载图片为 defaultImg
     *
     * @param lodingImagerView
     * @param picUrl
     * @param defaultImg
     */
    public void display(ImageView lodingImagerView, String picUrl, int defaultImg) {//外部接口函数
        if (defaultImg != 0) {
            Glide.with(mContext)
                    .load(picUrl)
                    .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(defaultImg)
                    .into(lodingImagerView);
        } else {
            Glide.with(mContext)
                    .load(picUrl)
                    .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                  .placeholder(R.color.loading_img_default_color)
                    .placeholder(R.mipmap.loding_pic)
                    .into(lodingImagerView);
        }
    }

    /**
     * 加载图片方法，加载图片为 defaultImg
     *
     * @param lodingImagerView
     * @param picUrl
     * @param defaultImg
     */
    public void displayNoType(ImageView lodingImagerView, String picUrl, int defaultImg) {//外部接口函数
        if (defaultImg != 0) {
            Glide.with(mContext)
                    .load(picUrl)
                    .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(defaultImg)
                    .into(lodingImagerView);
        } else {
            Glide.with(mContext)
                    .load(picUrl)
                    .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                  .placeholder(R.color.loading_img_default_color)
                    .placeholder(R.mipmap.loding_pic)
                    .into(lodingImagerView);
        }
    }

    /**
     * 加载图片方法，加载图片为 defaultImg
     *
     * @param activity
     * @param lodingImagerView
     * @param picUrl
     * @param defaultImg
     */
    public void display(Activity activity, ImageView lodingImagerView, String picUrl, int defaultImg) {//外部接口函数
        if (defaultImg != 0) {
            Glide.with(activity)
                    .load(picUrl)
                    .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
                    .placeholder(defaultImg)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(lodingImagerView);
        } else {
            Glide.with(activity)
                    .load(picUrl)
                    .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
//                  .placeholder(R.color.loading_img_default_color)
                    .placeholder(R.mipmap.loding_pic)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(lodingImagerView);
        }
    }

    /**
     * 加载圆角图片方法，加载图片为 defaultImg
     *
     * @param lodingImagerView
     * @param picUrl
     * @param defaultImg
     */
    public void displayRound(ImageView lodingImagerView, String picUrl, int defaultImg, int roundSize) {//外部接口函数
        if (defaultImg != 0) {
            Glide.with(mContext)
                    .load(picUrl).asBitmap()
                    .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
                    .placeholder(defaultImg)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .transform(new GlideRoundTransform(mContext, roundSize))
                    .into(lodingImagerView);
        } else {
            Glide.with(mContext)
                    .load(picUrl)
                    .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
//                  .placeholder(R.color.loading_img_default_color)
                    .placeholder(R.mipmap.loding_pic)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .transform(new GlideRoundTransform(mContext, roundSize))
                    .into(lodingImagerView);
        }
    }

    /**
     * 加载圆形图片方法，加载图片为 defaultImg
     *
     * @param lodingImagerView
     * @param picUrl
     * @param defaultImg
     */
    public void displayCircle(ImageView lodingImagerView, String picUrl, int defaultImg) {//外部接口函数
        if (defaultImg != 0) {
            Glide.with(mContext)
                    .load(picUrl).asBitmap()
                    .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
                    .placeholder(defaultImg)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .transform(new GlideCircleTransform(mContext))
                    .into(lodingImagerView);
        } else {
            Glide.with(mContext)
                    .load(picUrl)
                    .animate(android.R.anim.fade_in)  // 自己设置渐现动画可以解决加载图片变形问题
//                  .placeholder(R.color.loading_img_default_color)
                    .placeholder(R.mipmap.loding_pic)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .transform(new GlideCircleTransform(mContext))
                    .into(lodingImagerView);
        }
    }

    /**
     * 清除图片缓存
     */
    public void clearImageCache() {
        new Thread(runnable).start();
        Glide.get(mContext).clearMemory(); // 必须在主线程中执行
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                Glide.get(mContext).clearDiskCache(); // 必须在子线程中执行
            } catch (Exception ex) {
            }
        }
    };

}
