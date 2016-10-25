package cn.com.bjhj.baseframework.utils;

/**
 * 类介绍(必填)：布局参数
 * Created by huiyao huang on 2016/9/1  15:23.
 */

public class LayoutValue {
    /** grid的行间距 dip */
    public static final int GRID_ROW_SPACE = 0; // dip grid行间距。
    // 值为0，表示不指定行间距，自动居中。
    /** grid的列间距 dip */
    public static final int GRID_COL_SPACE = 0; // dip grid列间距。
    // 值为0，表示不指定列间距，自动居中。
    /** grid默认的列数，可能达不到 */
    public static final int GRID_COL_NUM = 4; // 列数，可能达不到
    /** grid默认的列数，可能达不到 */
    public static final int GRID_ROW_NUM = 3; // 列数，可能达不到
    /** 滑屏底部的圆圈半径 */
    public static final int Grid_CIRCLE_RADIUS = 3; // dip 滑屏底部的圆圈半径

    /** 状态栏的高度 */
    public static int TITLEHEIGHT = 40;
    // Dialog
    public static final int DIALOG_WIDTH = 500;
    public static final int DIALOG_HEIGHT = 400;

    /** 屏幕宽高 */
    public static int SCREEN_WIDTH = 480;
    public static int SCREEN_HEIGHT = 800;
    /** 状态栏高度 */
    public static int SCREEN_RECT = 0;
    /** 密度 */
    public static float SCREEN_DENSITY = 1.0f;// density
    /** 主视图的高度 */
    public static int CONTENTHEIGHT = 720;

    /** 屏幕底部的空余高度 */
    public static int SCREEN_BOTTOMHIGHT = 0;
}
