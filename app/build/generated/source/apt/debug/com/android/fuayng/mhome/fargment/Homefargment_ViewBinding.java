// Generated code from Butter Knife. Do not modify!
package com.android.fuayng.mhome.fargment;

import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.android.fuayng.mhome.R;
import com.bigkoo.convenientbanner.ConvenientBanner;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class Homefargment_ViewBinding<T extends Homefargment> implements Unbinder {
  protected T target;

  public Homefargment_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.xinTv = finder.findRequiredViewAsType(source, R.id.xin_tv, "field 'xinTv'", TextView.class);
    target.erTv = finder.findRequiredViewAsType(source, R.id.er_tv, "field 'erTv'", TextView.class);
    target.zuTv = finder.findRequiredViewAsType(source, R.id.zu_tv, "field 'zuTv'", TextView.class);
    target.convenientBanner = finder.findRequiredViewAsType(source, R.id.convenientBanner, "field 'convenientBanner'", ConvenientBanner.class);
    target.liebiaoLv = finder.findRequiredViewAsType(source, R.id.liebiao_lv, "field 'liebiaoLv'", ListView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.xinTv = null;
    target.erTv = null;
    target.zuTv = null;
    target.convenientBanner = null;
    target.liebiaoLv = null;

    this.target = null;
  }
}
