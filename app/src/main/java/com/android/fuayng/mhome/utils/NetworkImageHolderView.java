package com.android.fuayng.mhome.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.android.fuayng.mhome.R;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;

/**
 * 创建人：${SYC}
 * 创建时间：2016/11/11 14:37
 * 修改备注：网络下载图片
 */
public class NetworkImageHolderView implements Holder<String> {
    private ImageView imageView;
    @Override
    public View createView(Context context) {
        //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        imageView.setImageResource(R.mipmap.loding_pic);
       // ImageLoader.getInstance().displayImage(data,imageView);
        Glide
                .with( context )
                .load( data )
                .skipMemoryCache( true )
                .into( imageView );
    }
}
