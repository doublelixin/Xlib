package com.doublex.xlib;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.Map;

public class Xlib {

    //============================app=============================

    public static void setApp(Application app) {
        AppUtils.setApplication(app);
    }

    /**
     * 获取全局 Context
     */
    public static Context getAppContext() {
        return AppUtils.getContext();
    }

    /**
     * 获取包名
     */
    public static String getPackageName() {
        return AppUtils.getPackageName(AppUtils.getContext());
    }


    /**
     * 获取包名简写名称
     */
    public static String getPackageSubName() {
        return AppUtils.getPackageSubName(AppUtils.getContext());
    }

    /**
     * 获取版本名称
     */
    public static String getVersionName() {
        return AppUtils.getVersionName(AppUtils.getContext());
    }

    /**
     * 获取版本号
     */
    public static int getVersionCode() {
        return AppUtils.getVersionCode(AppUtils.getContext());
    }

    /**
     * 获取手机MacID号
     */
    public static String getMacID(Context context) {
        return AppUtils.getMacID(context);
    }

    /**
     * 获取手机IMEI号
     */
    public static String getIMEI(Context context) {
        return AppUtils.getIMEI(context);
    }

    /**
     * 获取手机AndroidID号
     */

    public static String getAndroidID(Context context) {
        return AppUtils.getAndroidID(context);
    }

    /**
     * 检查是否已经有权限
     */
    public static boolean checkPermission(Context context, String perssion) {
        return AppUtils.checkPermission(context, perssion);
    }

    /**
     * 点击返回按钮
     * 调用系统的返回事件
     */
    public static void onBackClick() {
        AppUtils.onBackClick();
    }

    //============================toast=============================

    /**
     * 优化多次重复弹窗的toast
     */
    public static void toast(String msg) {
        ToastUtils.toast(AppUtils.getContext(), msg);
    }

    /**
     * 中心toast
     * 根据需求，后期将进行改进
     * --需要改进
     */
    public static void toastCenter(String title, String msg) {
        ToastUtils.toastCenter(AppUtils.getContext(), title, msg);
    }

    /**
     * 默认短时间显示
     */
    public static void toastShort(String msg) {
        ToastUtils.toastShort(AppUtils.getContext(), msg);
    }

    /**
     * 默认长时间显示
     */
    public static void toastLong(String msg) {
        ToastUtils.toastLong(AppUtils.getContext(), msg);
    }

    //============================window=============================

    /**
     * 获取屏幕宽度(px)
     */
    public static int getScreenWidth(Context context) {
        return ScreenUtils.getScreenWidth(context);
    }

    /**
     * 获取屏幕高度(px)
     */
    public static int getScreenHeight(Context context) {
        return ScreenUtils.getScreenHeight(context);
    }

    /**
     * 获取状态栏高度
     */
    public static int getStatusBarHeight(Context context) {
        return ScreenUtils.getStatusBarHeight(context);
    }

    /**
     * 计算NavigationBar(导航栏)的高度
     */
    public static int getNavigationBarHeight(Context context) {
        return ScreenUtils.getNavigationBarHeight(context);
    }

    /**
     * px2dip
     */
    public static int px2dip(Context context, float pxValue) {
        return ScreenUtils.px2dip(context, pxValue);
    }

    /**
     * dip2px
     */
    public static int dip2px(Context context, float dipValue) {
        return ScreenUtils.dip2px(context, dipValue);
    }
    //============================time=============================

    /**
     * 获取时间戳
     */
    public static long getLongTime() {
        return TimeUtils.getLongTime();
    }

    /**
     * 获取默认格式的当前时间
     */
    public static String getTime() {
        return TimeUtils.getCurrentTime("");
    }

    /**
     * 获取自定义格式的当前时间
     */
    public static String getTime(String format) {
        return TimeUtils.getCurrentTime(format);
    }

    //============================file=============================

    /**
     * 创建自定义路径文件夹
     */
    public static String getFilePath(String filePath) {
        return FileUtils.getFilePath(filePath);
    }

    //============================sp=============================

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     */
    public static Object getSP(String key, String defaultValue) {
        return SharedPreferencesUtils.get(AppUtils.getContext(), key, defaultValue);
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     */
    public static void putSP(String key, String defaultValue) {
        SharedPreferencesUtils.put(AppUtils.getContext(), key, defaultValue);
    }

    /**
     * 查询某个key是否已经存在
     */
    public static boolean contains(String key) {
        return SharedPreferencesUtils.contains(AppUtils.getContext(), key);
    }

    /**
     * 查询所有的键值对
     */
    public static Map<String, ?> getAll() {
        return SharedPreferencesUtils.getAll(AppUtils.getContext());
    }

    /**
     * 移除某个key值已经对应的值
     */
    public static void remove(String key) {
        SharedPreferencesUtils.remove(AppUtils.getContext(), key);
    }

    /**
     * 清除所有数据
     */
    public static void clear() {
        SharedPreferencesUtils.clear(AppUtils.getContext());
    }

    //============================log=============================

    /**
     * 设置是否开启debug
     */
    public static void setDebug(boolean isDebug) {
        LogUtils.setDebug(isDebug);
    }

    public static void LogD(@NonNull String message) {
        LogUtils.d(message);
    }

    public static void LogD(@NonNull String tag, @NonNull String message) {
        LogUtils.d(tag, message);
    }

    public static void LogE(@NonNull String message) {
        LogUtils.e(message);
    }

    public static void LogE(@NonNull String tag, @NonNull String message) {
        LogUtils.e(tag, message);
    }

    public static void LogI(@NonNull String message) {
        LogUtils.i(message);
    }

    public static void LogI(@NonNull String tag, @NonNull String message) {
        LogUtils.i(tag, message);
    }

    public static void LogV(@NonNull String message) {
        LogUtils.v(message);
    }

    public static void LogV(@NonNull String tag, @NonNull String message) {
        LogUtils.v(tag, message);
    }

    public static void LogW(@NonNull String message) {
        LogUtils.w(message);
    }

    public static void LogW(@NonNull String tag, @NonNull String message) {
        LogUtils.w(tag, message);
    }
}
