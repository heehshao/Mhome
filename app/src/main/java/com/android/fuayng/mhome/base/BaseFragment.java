package com.android.fuayng.mhome.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

        public View mView;

        public boolean isVisible = false;
        //private CustomerDialog dialog;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            if (mView == null) {
                mView = inflater.inflate(initXML(), container, false);
            } else {
                ViewGroup group = (ViewGroup) mView.getParent();
                if (group != null) {
                    group.removeView(mView);
                }
            }
            ButterKnife.bind(this,mView);
            init();
            initView();
            initEvent();
            return mView;
        }
        /**
         * 设置fragment布局
         *
         * @return
         */
        protected abstract int initXML();

    /**
     * 初始化其他
     *
     * @return
     */
    protected abstract void init();

    /**
     * 初始化控件
     *
     * @return
     */
    protected abstract void initView();

    /**
     * 初始化数据，所有初始化数据的方法写在这里面
     *
     * @return
     */
    protected abstract void initData();

    /**
     * 事件处理
     *
     * @return
     */
    protected abstract void initEvent();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (getUserVisibleHint()) {
            isVisible = true;
        } else {
            isVisible = false;
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        setUserVisibleHint(true);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //x.view().inject(this, LayoutInflater.from(getActivity()), null);
        initData();
        super.onViewCreated(view, savedInstanceState);
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
        Intent intent = new Intent(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 通过Action启动Activity
     *
     * @param action
     */
    protected void openActivity(String action) {
        openActivity(action, null);
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

    /**
     * 弹出加载中窗口。。。
     */
    public void StartLoading() {
        //TODO
    }

    /**
     * 加载中窗口消失。。。
     */
    public void StopLoading() {
        //TODO
    }

//    /**
//     * 只有一个确定按钮的弹出窗(白色风格的)
//     *
//     * @param message
//     */
//    public void showEnsureDialog(String message) {
//        if (dialog == null) {
//            dialog = new CustomerDialog(getActivity());
//        }
//        dialog.AlertMessage(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (v.getId() == R.id.line_btn_sure) {
//                    dialog.dismiss();
//                }
//            }
//        }, message);
//    }

    /**
     * 提示
     */
    protected void showToast(String msg) {
        Toast.makeText(AppContext.getContext(), msg, Toast.LENGTH_SHORT).show();
        //new HintViewUtils(getActivity(),msg,null,null);
    }

    @Override
    public void onResume() {
        super.onResume();
        //   MobclickAgent.onPageStart(getClass().getSimpleName());
    }

    @Override
    public void onPause() {
        super.onPause();
        // MobclickAgent.onPageEnd(getClass().getSimpleName());
    }

    public void SubmitEvent(String key) {
        // MobclickAgent.onEvent(getActivity(), key);
    }
}
