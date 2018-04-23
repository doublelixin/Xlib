package com.doublex.xlib;

import android.support.annotation.NonNull;
import android.support.v4.BuildConfig;

import static android.content.ContentValues.TAG;

/**
 * 日志打印工具
 */
public class LogUtils {
    //是否开启debug,默认根据运行方式选择
    private static boolean mIsDebug = BuildConfig.DEBUG;

    /**
     * 设置是否开启debug
     */
    public static void setDebug(boolean isDebug) {
        mIsDebug = isDebug;
    }

    public static void d(@NonNull String message) {
        if (mIsDebug)
            android.util.Log.d(TAG, message);
    }

    public static void d(@NonNull String tag, @NonNull String message) {
        if (mIsDebug)
            android.util.Log.d(tag, message);
    }

    public static void e(@NonNull String message) {
        if (mIsDebug)
            android.util.Log.e(TAG, message);
    }

    public static void e(@NonNull String tag, @NonNull String message) {
        if (mIsDebug)
            android.util.Log.e(tag, message);
    }

    public static void i(@NonNull String message) {
        if (mIsDebug)
            android.util.Log.i(TAG, message);
    }

    public static void i(@NonNull String tag, @NonNull String message) {
        if (mIsDebug)
            android.util.Log.i(tag, message);
    }

    public static void v(@NonNull String message) {
        if (mIsDebug)
            android.util.Log.v(TAG, message);
    }

    public static void v(@NonNull String tag, @NonNull String message) {
        if (mIsDebug)
            android.util.Log.v(tag, message);
    }

    public static void w(@NonNull String message) {
        if (mIsDebug)
            android.util.Log.w(TAG, message);
    }

    public static void w(@NonNull String tag, @NonNull String message) {
        if (mIsDebug)
            android.util.Log.w(tag, message);
    }

}
