# Xlib

## 必须先调用initXlib()

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
---
```
dependencies {
        implementation 'com.github.doublelixin:Xlib:1.1.0'
}
```
---
# 主要方法

## sys
* .getAppContext()
    * 获取全局 Context
        * return Context
* .getPackageName()
    * 获取包名
        * return String
* .getPackageSubName()
    * 获取包名简写名称
        * return String
* .getClassName(Class clazz)
    * 获取当前类的名称
        * return String
* .getMethodName()
    * 获取当前的方法名称
        * return String
* .getLineNumber()
    * 获取当前行号
        * return int
* .getVersionName()
    * 获取版本名称
        * return String
* .getVersionCode()
    * 获取版本号
        * return int
* .getMacID(Context context)
    * 获取手机MacID
        * return String
* .getMacAddress(Context context)
    * 获取手机MACAddress
        * return String
* .getIMEI(Context context)
    * 获取手机IMEI
        * return String
* .getAndroidID(Context context)
    * 获取手机AndroidID
        * return String
* .checkPermission(Context context, String permission)
    * 检查是否已经有权限
        * return boolean
* .onBackClick()
    * 调用系统的返回事件
        * return void
* .isForeground(Context context, String className)
    * 判断activity是否在前台
        * return boolean
* .openInputMethod(EditText editText)
    * 打开输入法软键盘
        * return void
* .closeInputMethod(View view)
    * 获取版本名称
        * return void


## Toast
* .toast(String msg)
    * 优化多次重复弹窗的toast
        * return void
* .toastCenter(String title, String msg)
    * 中心toast
        * return void
* .toastShort(String msg)
    * 默认短时间显示
        * return void
* .toastLong(String msg)
    * 默认长时间显示
        * return void


## Window
* .getScreenWidth(Context context)
    * 获取屏幕宽度(px)
        * return int
* .getScreenHeight(Context context)
    * 获取屏幕高度(px)
        * return int
* .getStatusBarHeight(Context context)
    * 获取状态栏高度
        * return int
* .getNavigationBarHeight(Context context)
    * 获取NavigationBar(导航栏)的高度
        * return int
* .px2dip(Context context, float pxValue)
    * px2dip
        * return int
* .dip2px(Context context, float pxValue)
    * dip2px
        * return int


## Time
* .getLongTime()
    * 获取时间戳
        * return long
* .getTime()
    * 获取默认格式的当前时间
        * return String
* .getTime(String format)
    * 获取自定义格式的当前时间
        * return String


## File
* .getFilePath(String filePath)
    * 创建自定义路径文件夹
        * return String
* .getString(InputStream inputStream)
    * Stream转为String
        * return String
* .getString(byte[] bytes)
    * byte转为String
        * return String
* .getResponseByte(String url)
    * get方式获取网络数据
        * return byte[]
* .getResponseString(String url)
    * get方式获取网络数据
        * return String


## SharedPreferences
* .getSP(String key, String defaultValue)
    * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
        * return Object
* .putSP(String key, String defaultValue)
    * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
        * return void
* .contains(String key)
    * 查询某个key是否已经存在
        * return boolean
* .getAll()
    * 查询所有的键值对
        * return Map
* .remove(String key)
    * 移除某个key值已经对应的值
        * return void
* .clear()
    * 清除所有数据
        * return void


## Log
* .setDebug(boolean isDebug)
    * 设置是否开启debug
        * return void
* .LogD(@NonNull String message)
    * return void
* .LogD(@NonNull String tag, @NonNull String message)
    * return void
* .LogE(@NonNull String message)
    * return void
* .LogE(@NonNull String tag, @NonNull String message)
    * return void
* .LogI(@NonNull String message)
    * return void
* .LogI(@NonNull String tag, @NonNull String message)
    * return void
* .LogV(@NonNull String message)
    * return void
* .LogV(@NonNull String tag, @NonNull String message)
    * return void
* .LogW(@NonNull String message)
    * return void
* .LogW(@NonNull String tag, @NonNull String message)
    * return void


## VerificationCodeEditText
```
在xml文件中使用
<com.doublex.xlib.VerificationCodeEditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:figures="4" />


//设置位数
editText.setFigures(4);
//设置验证码之间的间距
editText.setVerCodeMargin(1);
//设置底部选中状态的颜色
editText.setBottomSelectedColor(getResources().getColor(Color.RED));
//设置底部未选中状态的颜色
editText.setBottomNormalColor(getResources().getColor(Color.GRAY));
//设置选择的背景色
editText.setSelectedBackgroundColor(getResources().getColor(Color.TRANSPARENT));
//设置底线的高度
editText.setBottomLineHeight(2);
//设置当验证码变化时候的监听器
editText.setOnVerificationCodeChangedListener(new OnVerificationCodeChangedListener() {
    @Override
    public void onVerCodeChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onInputCompleted(CharSequence charSequence) {

    }
});
```