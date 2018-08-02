package com.doublex.xlib;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

class StreamUtils {

    /***
     * Stream转为String
     */
    static String getString(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            Writer writer = new StringWriter();

            char[] chars = new char[2048];
            try {
                Reader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                int counter;
                while ((counter = bufferedReader.read(chars)) != -1) {
                    writer.write(chars, 0, counter);
                }
            } finally {
                inputStream.close();
            }
            return writer.toString();
        } else {
            return "No Contents";
        }
    }

    /***
     * byte转为String
     */
    static String getString(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return "";
        }
        StringBuilder buf = new StringBuilder();
        for (byte b : bytes) {
            buf.append(String.format("%02X:", b));
        }
        if (buf.length() > 0) {
            buf.deleteCharAt(buf.length() - 1);
        }
        return buf.toString();
    }

    static byte[] getResponse(String urlPath) {
        InputStream inStream = null;
        ByteArrayOutputStream outStream = null;
        HttpURLConnection conn = null;
        byte[] data;
        try {
            URL url = new URL(urlPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(1000);
            conn.setReadTimeout(1000);
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inStream = conn.getInputStream();
                byte[] b = new byte[1024];
                int len;
                //创建字节数组输出流，读取输入流的文本数据时，同步把数据写入数组输出流
                outStream = new ByteArrayOutputStream();
                while ((len = inStream.read(b)) != -1) {
                    outStream.write(b, 0, len);
                }
                data = outStream.toByteArray();
                return data;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
                if (outStream != null) {
                    outStream.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
