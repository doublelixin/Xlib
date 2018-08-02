package com.doublex.xlib;

import android.support.annotation.NonNull;
import android.support.v4.BuildConfig;

import static android.content.ContentValues.TAG;

/**
 * 日志打印工具
 */
class LogUtils {
    //是否开启debug,默认根据运行方式选择
    private static boolean mIsDebug = BuildConfig.DEBUG;

    /**
     * 设置是否开启debug
     */
    static void setDebug(boolean isDebug) {
        mIsDebug = isDebug;
    }

    static void d(@NonNull String message) {
        if (mIsDebug) {
            android.util.Log.d(TAG, message);
        }
    }

    static void d(@NonNull String tag, @NonNull String message) {
        if (mIsDebug) {
            android.util.Log.d(tag, message);
        }
    }

    static void e(@NonNull String message) {
        if (mIsDebug) {
            android.util.Log.e(TAG, message);
        }
    }

    static void e(@NonNull String tag, @NonNull String message) {
        if (mIsDebug) {
            android.util.Log.e(tag, message);
        }
    }

    static void i(@NonNull String message) {
        if (mIsDebug) {
            android.util.Log.i(TAG, message);
        }
    }

    static void i(@NonNull String tag, @NonNull String message) {
        if (mIsDebug) {
            android.util.Log.i(tag, message);
        }
    }

    static void v(@NonNull String message) {
        if (mIsDebug) {
            android.util.Log.v(TAG, message);
        }
    }

    static void v(@NonNull String tag, @NonNull String message) {
        if (mIsDebug) {
            android.util.Log.v(tag, message);
        }
    }

    static void w(@NonNull String message) {
        if (mIsDebug) {
            android.util.Log.w(TAG, message);
        }
    }

    static void w(@NonNull String tag, @NonNull String message) {
        if (mIsDebug) {
            android.util.Log.w(tag, message);
        }
    }

}
