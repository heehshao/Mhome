// Generated code from Butter Knife. Do not modify!
package com.android.fuayng.mhome;

import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.ycl.tabview.library.TabView;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  public MainActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.tabView = finder.findRequiredViewAsType(source, R.id.tabView, "field 'tabView'", TabView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tabView = null;

    this.target = null;
  }
}
