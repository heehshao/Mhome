package com.android.fuayng.mhome.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.fuayng.mhome.R;
import com.android.fuayng.mhome.bean.LieBiaoBean;
import com.android.fuayng.mhome.utils.GlideImageLoader;

import java.util.List;

/**
 * 作者：SYC on 2017/3/24 12:47
 * 类名：
 * 用途：
 */

public class HomeListAdapter extends BaseAdapter {
    private Context mContext;
    private List<LieBiaoBean> datas;

    public HomeListAdapter(Context context, List<LieBiaoBean> datas) {
        this.mContext = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        if (datas != null) {
            return datas.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HomeListAdapter.ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(mContext, R.layout.liebiao_item, null);
            holder = new HomeListAdapter.ViewHolder();
            view.setTag(holder);
            holder.priceTv = (TextView) view.findViewById(R.id.price);
            holder.titleTv = (TextView) view.findViewById(R.id.title);
            holder.imgUrl = (ImageView) view.findViewById(R.id.imageView);
        } else {
            holder = (HomeListAdapter.ViewHolder) view.getTag();
        }
        LieBiaoBean lieBiaoBean = datas.get(i);
        holder.priceTv.setText(lieBiaoBean.getPrice());
        holder.titleTv.setText(lieBiaoBean.getTitle());
        new GlideImageLoader(mContext).display(holder.imgUrl,lieBiaoBean.getImgurl()+"");
        return view;
    }

    static class ViewHolder {
        TextView priceTv;
        TextView titleTv;
        ImageView imgUrl;

    }
}
