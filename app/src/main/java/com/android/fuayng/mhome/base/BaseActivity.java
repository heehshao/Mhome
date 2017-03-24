package com.android.fuayng.mhome.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * 作者：SYC on 2017/3/15 17:08
 * 类名：
 * 用途：
 */

public abstract class BaseActivity extends FragmentActivity {
    private View mContextView = null;
    protected Context mContext;
    @Override
    protected  void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       initSetView(savedInstanceState);
        mContext = AppContext.getContext();
        init();
        initView();
        initListener();
        initData();
        fastClick();
        ApplicationValue.getInstance().addActivity(this);
    }
    /**
     * 绑定布局
     * @param savedInstanceState
     */
    protected abstract void initSetView(Bundle savedInstanceState);

    /**
     * 初始化
     */
    protected abstract void init();
    /**
     * 初始化控件
     */
    protected abstract void initView();
    /**
     * 初始化widget组件事件
     */
    protected abstract void initListener();
    /**
     * 初始化数据
     */
    protected abstract void initData();
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    /**
     * 提示
     */
    protected void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
    /**
     * 通过类名启动Activity
     *
     * @param cls 需要跳转的类
     */
    protected void openActivity(Class<?> cls) {
        openActivity(cls, null);
    }

    /**
     * 通过类名启动Activity，并且含有Bundle数据
     *
     * @param cls    需要跳转的类
     * @param bundle 数据
     */
    protected void openActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    /**
     * 通过Action启动Activity，并且含有Bundle数据
     *
     * @param action
     * @param bundle 数据
     */
    protected void openActivity(String action, Bundle bundle) {
        Intent intent = new Intent(action);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
    /**
     * [防止快速点击]
     *
     * @return
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
