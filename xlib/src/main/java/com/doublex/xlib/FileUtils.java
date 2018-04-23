package com.doublex.xlib;

import android.os.Environment;
import android.widget.Toast;

import java.io.File;

class FileUtils {
    /**
     * 创建自定义路径文件夹
     */
    static String getFilePath(String filePath) {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(AppUtils.getContext(), "SD卡检测异常", Toast.LENGTH_SHORT).show();
            return null;
        }
        String picPath = Environment.getExternalStorageDirectory() + File.separator + AppUtils.getContext().getPackageName() + File.separator + filePath + File.separator;
        File file = new File(picPath);
        if (!file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.mkdirs();
        }
        return picPath;
    }
}
