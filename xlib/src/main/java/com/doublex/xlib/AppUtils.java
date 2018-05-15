package com.doublex.xlib;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
     * 获取当前类的名称
     */
    static String getClassName(Class clazz) {
        String clazzName = clazz.getName();
        String name;
        if (clazzName.contains(".")) {
            int index = clazzName.lastIndexOf(".") + 1;
            name = clazzName.substring(index);
        } else name = clazzName;
        return name;
    }

    /**
     * 获取当前的方法名称
     */
    static String getMethodName() {
        return Thread.currentThread().getStackTrace()[1].getMethodName();
    }

    /**
     * 获取当前行号
     */
    static int getLineNumber() {
        return Thread.currentThread().getStackTrace()[1].getLineNumber();
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

    /**
     * 获取手机MacID号
     * 需要动态权限: android.permission.READ_PHONE_STATE
     */
    static String getMacID(Context context) {
        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        if (checkPermission(context, Manifest.permission.ACCESS_WIFI_STATE)) {
            @SuppressLint("MissingPermission") String WLANMAC = wm.getConnectionInfo().getMacAddress();
            return WLANMAC;
        } else return "NULL";
    }

    /**
     * 获取手机IMEI号
     * 需要动态权限: android.permission.READ_PHONE_STATE
     */
    static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
        if (checkPermission(context, Manifest.permission.READ_PHONE_STATE)) {
            @SuppressLint("MissingPermission") String imei = telephonyManager.getDeviceId();
            return imei;
        } else return "NULL";
    }

    /**
     * 获取手机AndroidID号
     */
    @SuppressLint("HardwareIds")
    static String getAndroidID(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * 检查是否已经有权限
     */
    static boolean checkPermission(Context context, String perssion) {
        return ContextCompat.checkSelfPermission(context, perssion) != PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 判断activity是否在前台
     */
    static boolean isForeground(Context context, String className) {
        if (context == null || TextUtils.isEmpty(className)) return false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = null;
        if (am != null) {
            list = am.getRunningTasks(1);
        }
        if (list != null && list.size() > 0) {
            if (className.equals(list.get(0).topActivity.getClassName())) return true;
        }
        return false;
    }

    /**
     * 打开输入法软键盘
     */
    static void openInputMethod(final EditText editText) {
        new Timer().schedule(new TimerTask() {
            public void run() {
                InputMethodManager inputManager = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputManager != null) {
                    inputManager.showSoftInput(editText, 0);
                }
            }
        }, 200);
    }

    /**
     * 关闭输入法软键盘
     */
    static void closeInputMethod(View view) {
        try {
            //获取输入法的服务
            InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            //判断是否在激活状态
            if (imm != null && imm.isActive()) {
                //隐藏输入法
                imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
