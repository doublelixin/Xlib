package com.doublex.xlib;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.BuildConfig;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AppUtils {
    @SuppressLint("StaticFieldLeak")
    private static Application application;

    public static void setApplication(Application application) {
        if (AppUtils.application != null) {
            throw new IllegalStateException("application already holded 'application'.");
        }
        AppUtils.application = application;
    }

    /**
     * 获取全局 Context
     */
    public static Context getContext() {
        return application.getApplicationContext();
    }

    /**
     * 获取包名
     */
    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    /**
     * 获取包名简写名称
     */
    @NonNull
    public static String getPackageSubName(Context context) {
        String packageName = context.getPackageName();
        return packageName.substring(packageName.lastIndexOf(".") + 1);
    }

    /**
     * 获取版本名称
     */
    public static String getVersionName(Context context) {
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
    public static int getVersionCode(Context context) {
        int versionCode = BuildConfig.VERSION_CODE;
        try {
            versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.COMPONENT_ENABLED_STATE_DEFAULT).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }


    /**
     * 创建自定义路径文件夹
     */
    public static String getFilePath(Context context, String filePath) {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(context, "SD卡检测异常", Toast.LENGTH_SHORT).show();
            return null;
        }
        String picPath = Environment.getExternalStorageDirectory() + File.separator + context.getPackageName() + File.separator + filePath + File.separator;
        File file = new File(picPath);
        if (!file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.mkdirs();
        }
        return picPath;
    }

    /**
     * 获取自定义格式的当前时间
     */
    public static String getCurrentTime(String format) {
        if (TextUtils.isEmpty(format)) format = "yyyy-MM-dd HH:mm:ss";
        return new SimpleDateFormat(format, Locale.ENGLISH).format(System.currentTimeMillis());
    }

    /**
     * 点击返回按钮
     * 调用系统的返回事件
     */
    public static void onBackClick() {
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
