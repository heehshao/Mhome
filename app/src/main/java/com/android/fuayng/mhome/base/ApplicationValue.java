package com.android.fuayng.mhome.base;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

public class ApplicationValue {

    public boolean flag = false;
    public List<Activity> activityList = new LinkedList<Activity>();
    private static ApplicationValue instance;

    public ApplicationValue() {
        super();
        //Thread.setDefaultUncaughtExceptionHandler(onBlooey);
    }

    private Thread.UncaughtExceptionHandler onBlooey = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread thread, Throwable ex) {
        }
    };

    public void invokeGc() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    finalize();
                } catch (Throwable e) {
                }
                // 提醒系统及时回收
                System.gc();
            }
        }).start();
    }

    // 单例模式中获取唯一的ApplicationUtil实例
    public static ApplicationValue getInstance() {
        if (null == instance) {
            instance = new ApplicationValue();
        }
        return instance;

    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        if (!activityList.contains(activity)) {
            activityList.add(activity);
        }

    }

    /**
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (activityList.contains(activity)) {
            activityList.remove(activity);
        }

    }

    /**
     * 判断是否包含某个视图
     *
     * @param activity
     * @return
     */
    public boolean containsActivity(Activity activity) {
        if (activityList.contains(activity)) {
            return true;
        }
        return false;
    }


    public void fishActivity(Class<?> cls) {
        int size = activityList.size();
        for (int i = size - 1; i > 0; i--) {
            Activity activity = activityList.get(i);
            if (!activity.isFinishing()) {
                activity.finish();
            }
            if (cls.getName().equals(activity.getLocalClassName())) {
                break;
            }
        }
    }

}
