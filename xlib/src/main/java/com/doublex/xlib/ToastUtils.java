package com.doublex.xlib;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ToastUtils
 */
class ToastUtils {
    private static Toast toast = null;

    /**
     * 优化多次重复弹窗的toast
     */
    static void toast(Context context, String message) {
        if (toast != null) {
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    static void toastShort(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    static void toastLong(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 中心toast
     * 根据需求，后期将进行改进
     * --需要改进
     */
    static void toastCenter(Context context, String title, String content) {
        View inflate = View.inflate(context, R.layout.custom_toast, null);
        TextView titleView = inflate.findViewById(R.id.toast_title);
        titleView.setText(title);
        TextView contentView = inflate.findViewById(R.id.toast_content);
        contentView.setText(content);
        android.widget.Toast toast = new android.widget.Toast(context);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(android.widget.Toast.LENGTH_SHORT);
        toast.setView(inflate);
        toast.show();
    }
}
