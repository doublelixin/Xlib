package com.doublex.xlib;

import android.app.Activity;
import android.util.DisplayMetrics;

class ScreenUtils {
    /**
     * 获取窗口宽度
     */
    static int getWindowWidth(Activity context) {
        //int width = context.getWindowManager().getDefaultDisplay().getWindowWidth();//方法过时
        DisplayMetrics dm = new DisplayMetrics();
        //获取屏幕信息
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取窗口高度
     */
    static int getWindowHeight(Activity context) {
        //int height = context.getWindowManager().getDefaultDisplay().getWindowHeight();//方法过时
        DisplayMetrics dm = new DisplayMetrics();
        //获取屏幕信息
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
}
