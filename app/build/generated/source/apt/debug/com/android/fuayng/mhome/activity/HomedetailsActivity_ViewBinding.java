// Generated code from Butter Knife. Do not modify!
package com.android.fuayng.mhome.activity;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.android.fuayng.mhome.R;
import com.bigkoo.convenientbanner.ConvenientBanner;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class HomedetailsActivity_ViewBinding<T extends HomedetailsActivity> implements Unbinder {
  protected T target;

  public HomedetailsActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.toolbarLin = finder.findRequiredViewAsType(source, R.id.toolbar_lin, "field 'toolbarLin'", LinearLayout.class);
    target.mainIvPlaceholder = finder.findRequiredViewAsType(source, R.id.main_iv_placeholder, "field 'mainIvPlaceholder'", ImageView.class);
    target.mLlTitleContainer = finder.findRequiredViewAsType(source, R.id.main_ll_title_container, "field 'mLlTitleContainer'", LinearLayout.class);
    target.mFlTitleContainer = finder.findRequiredViewAsType(source, R.id.main_fl_title, "field 'mFlTitleContainer'", FrameLayout.class);
    target.mAblAppBar = finder.findRequiredViewAsType(source, R.id.main_abl_app_bar, "field 'mAblAppBar'", AppBarLayout.class);
    target.mTvToolbarTitle = finder.findRequiredViewAsType(source, R.id.main_tv_toolbar_title, "field 'mTvToolbarTitle'", TextView.class);
    target.mTbToolbar = finder.findRequiredViewAsType(source, R.id.main_tb_toolbar, "field 'mTbToolbar'", Toolbar.class);
    target.convenientBanner = finder.findRequiredViewAsType(source, R.id.convenientBanner, "field 'convenientBanner'", ConvenientBanner.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbarLin = null;
    target.mainIvPlaceholder = null;
    target.mLlTitleContainer = null;
    target.mFlTitleContainer = null;
    target.mAblAppBar = null;
    target.mTvToolbarTitle = null;
    target.mTbToolbar = null;
    target.convenientBanner = null;

    this.target = null;
  }
}
