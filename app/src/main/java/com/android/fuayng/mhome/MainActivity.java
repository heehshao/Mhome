package com.android.fuayng.mhome;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.fuayng.mhome.base.BaseActivity;
import com.android.fuayng.mhome.fargment.Homefargment;
import com.android.fuayng.mhome.fargment.Profilefargment;
import com.android.fuayng.mhome.fargment.Shortlistfargment;
import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tabView)
    TabView tabView;
    @Override
    protected void initSetView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @Override
    protected void init() {
    }
    @Override
    protected void initView() {
        tabView.setTextViewSelectedColor(Color.rgb(19,212,175));
       // tabView.setTabViewBackgroundColor(R.color.tab_selected);
        tabView.setTextViewUnSelectedColor(R.color.tab_unselected);
        List<TabViewChild> tabViewChildList = new ArrayList<>();
        Homefargment homefargment = new Homefargment();
        Shortlistfargment shortlistfargment =  new Shortlistfargment();
        Profilefargment profilefargment = new Profilefargment();
        TabViewChild tabViewChild01 = new TabViewChild(R.mipmap.icon_home_selected, R.mipmap.icon_home_unselected, "Home", homefargment);
        TabViewChild tabViewChild03 = new TabViewChild(R.mipmap.icon_shortlist_selected, R.mipmap.icon_shortlist_unselected, "Shortlist", shortlistfargment);
        TabViewChild tabViewChild04 = new TabViewChild(R.mipmap.icon_profile_selected, R.mipmap.icon_profile_unselected, "Profile", profilefargment);
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild03);
        tabViewChildList.add(tabViewChild04);
        //end add data

        tabView.setTabViewDefaultPosition(0);
        tabView.setTabViewChild(tabViewChildList, getSupportFragmentManager());
        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
            @Override
            public void onTabChildClick(int position, ImageView currentImageIcon, TextView currentTextView) {
                // Toast.makeText(getApplicationContext(),"position:"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
