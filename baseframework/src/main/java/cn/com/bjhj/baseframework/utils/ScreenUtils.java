package cn.com.bjhj.baseframework.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import cn.com.bjhj.baseframework.ui.activity.BaseActivity;

/**
 * 屏幕信息  工具类
 * Created by huiyao huang on 2016/7/17.
 */
public class ScreenUtils {

    /**是否全屏*/
    private static boolean isFullScreen = false;

    /**
     * 获取状态栏高度
     * @param context 上下文
     * @return 状态栏高度
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 得到屏幕信息对象，并打印信息
     * @param context 上下文
     * @return display metrics
     */
    public static DisplayMetrics displayMetrics(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        L.v("screen width=" + dm.widthPixels + "px, screen height=" + dm.heightPixels
                + "px, densityDpi=" + dm.densityDpi + ", density=" + dm.density);
        return dm;
    }

    /**
     * 屏幕宽度（像素）
     * @param context 上下文
     * @return 宽度（像素）
     */
    public static int widthPixels(Context context) {
        return displayMetrics(context).widthPixels;
    }

    /**
     * 屏幕高度（像素）
     * @param context 上下文
     * @return 高度（像素）
     */
    public static int heightPixels(Context context) {
        return displayMetrics(context).heightPixels;
    }

    /**
     * 显示器逻辑密度 准确的讲是相对密度
     * density = densityDpi/160 （160是google定义的标准 dpi == 160的时候，density == 1）
     * @see DisplayMetrics#density
     * @param context 上下文
     * @return 相对密度
     */
    public static float density(Context context) {
        return displayMetrics(context).density;
    }

    /**
     * 屏幕密度
     * densityDpi = density * 160
     * @see ScreenUtils#density(Context)
     * @param context 上下文
     * @return 屏幕密度
     */
    public static int densityDpi(Context context) {
        return displayMetrics(context).densityDpi;
    }

    /**
     * 是否充满屏幕
     * @return true 充满屏幕  false 不充满屏幕
     */
    public static boolean isFullScreen() {
        return isFullScreen;
    }

    /**
     * 切换是否充满屏幕
     * @param activity 需要切换的activity
     */
    public static void toggleFullScreen(BaseActivity activity) {
        Window window = activity.getWindow();
        int flagFullscreen = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //如果充满屏幕，就变成不充满  反之则反
        if (isFullScreen) {
            window.clearFlags(flagFullscreen);
            isFullScreen = false;
        } else {
            window.setFlags(flagFullscreen, flagFullscreen);
            isFullScreen = true;
        }
    }

    /**
     * 保持屏幕常亮
     * @param activity the activity
     */
    public static void keepBright(Activity activity) {
        //需在setContentView前调用
        int keepScreenOn = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
        activity.getWindow().setFlags(keepScreenOn, keepScreenOn);
    }
}
