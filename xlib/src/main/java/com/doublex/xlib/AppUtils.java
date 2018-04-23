package com.doublex.xlib;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.view.KeyEvent;

class AppUtils {
    @SuppressLint("StaticFieldLeak")
    private static Application application;

    static void setApplication(Application application) {
        if (AppUtils.application != null) {
            throw new IllegalStateException("application already holded 'application'.");
        }
        AppUtils.application = application;
    }

    /**
     * 获取全局 Context
     */
    static Context getContext() {
        return application.getApplicationContext();
    }

    /**
     * 获取包名
     */
    static String getPackageName(Context context) {
        return context.getPackageName();
    }

    /**
     * 获取包名简写名称
     */
    @NonNull
    static String getPackageSubName(Context context) {
        String packageName = context.getPackageName();
        return packageName.substring(packageName.lastIndexOf(".") + 1);
    }

    /**
     * 获取版本名称
     */
    static String getVersionName(Context context) {
        String versionName = BuildConfig.VERSION_NAME;
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.COMPONENT_ENABLED_STATE_DEFAULT).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取版本号
     */
    static int getVersionCode(Context context) {
        int versionCode = BuildConfig.VERSION_CODE;
        try {
            versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.COMPONENT_ENABLED_STATE_DEFAULT).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 点击返回按钮
     * 调用系统的返回事件
     */
    static void onBackClick() {
        new Thread() {
            public void run() {
                try {
                    new Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                } catch (Exception e) {
                    android.util.Log.e("Error when onBackClick", e.toString());
                }
            }
        }.start();
    }
}
