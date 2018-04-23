package com.doublex.xlib;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;

class TimeUtils {

    /**
     * 获取自定义格式的当前时间
     */
    static String getCurrentTime(String format) {
        if (TextUtils.isEmpty(format)) format = "yyyy-MM-dd HH:mm:ss";
        return new SimpleDateFormat(format, Locale.ENGLISH).format(System.currentTimeMillis());
    }

    /**
     * 获取时间戳
     */
    static long getLongTime() {
        return System.currentTimeMillis();
    }
}
