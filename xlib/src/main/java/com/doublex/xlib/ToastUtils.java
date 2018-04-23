package com.doublex.xlib;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.doublex.libx.R;

/**
 * ToastUtils
 */
public class ToastUtils {
    private static Toast toast = null;

    /**
     * 优化多次重复弹窗的toast
     */
    public static void toast(Context context, String message) {
        if (toast != null) {
            toast.setText(message);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * 中心toast
     * 根据需求，后期将进行改进
     * --需要改进
     */
    public static void toastCenter(Context context, String title, String content) {
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
