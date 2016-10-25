package cn.com.bjhj.baseframework.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Preference处理类
 * 以键值对的方式保存一些简单的用户数据
 * Created by huiyao huang on 2016/7/17.
 */
public class PreferenceUtils {

    /**
     * 通过键，获取字符串类型的Pre数据
     * @param context 上下文
     * @param key 键
     * @param defaultValue 值
     * @return 保存的字符串数据
     */
    public static String getPrefString(Context context, String key, final String defaultValue) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getString(key, defaultValue);
    }

    /**
     * 设置字符串类型的Pre数据
     * @param context 上下文
     * @param key 键
     * @param value 值
     */
    public static void setPrefString(Context context, final String key, final String value) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings.edit().putString(key, value).commit();
    }

    /**
     * 设置long类型的Pre数据
     * @param context 上下文
     * @param key 键
     * @param value 值
     */
    public static void setPrefLong(Context context, final String key, final long value) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings.edit().putLong(key, value).commit();
    }

    /**
     * 得到布尔型的Pre数据
     * @param context 上下文
     * @param key 键
     * @param defaultValue 默认值
     * @return 保存的布尔型数据
     */
    public static boolean getPrefBoolean(Context context, final String key, final boolean defaultValue) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getBoolean(key, defaultValue);
    }

    /**
     * 设置布尔型的Pre数据
     * @param context 上下文
     * @param key 键
     */
    public static void setPrefBoolean(Context context, final String key, final boolean value) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings.edit().putBoolean(key, value).commit();
    }

    /**
     * 设置int型的Pre数据
     * @param context 上下文
     * @param key 键
     * @param value 值
     */
    public static void setPrefInt(Context context, final String key, final int value) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings.edit().putInt(key, value).commit();
    }

    /**
     * 得到int型的pre数据
     * @param context 上下文
     * @param key 键
     * @param defaultValue 默认值
     * @return 返回对应的value
     */
    public static int getPrefInt(Context context, final String key, final int defaultValue) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getInt(key, defaultValue);
    }

    /**
     * 设置float型的Pre数据
     * @param context 上下文
     * @param key 键
     * @param value 值
     */
    public static void setPrefFloat(Context context, final String key,final float value) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings.edit().putFloat(key, value).commit();
    }


    /**
     * 得到float型的pre数据
     * @param context 上下文
     * @param key 键
     * @param defaultValue 默认值
     * @return 返回对应的value
     */
    public static float getPrefFloat(Context context, final String key,final float defaultValue) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getFloat(key, defaultValue);
    }

    /**
     * 设置long型的Pre数据
     * @param context 上下文
     * @param key 键
     * @param value 值
     */
    public static void setSettingLong(Context context, final String key, final long value) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings.edit().putLong(key, value).commit();
    }

    /**
     * 得到long型的pre数据
     * @param context 上下文
     * @param key 键
     * @param defaultValue 默认值
     * @return 返回对应的value
     */
    public static long getPrefLong(Context context, final String key, final long defaultValue) {
        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getLong(key, defaultValue);
    }


    /**
     * 查询pre文件中是否包含某个键
     * @param context 上下文
     * @param key 键
     * @return true包含  false不包含
     */
    public static boolean hasKey(Context context, final String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).contains(key);
    }

    /**
     * 清空pre数据
     * @param context 上下文
     * @param p SharedPreferences
     */
    public static void clearPreference(Context context, final SharedPreferences p) {
        final SharedPreferences.Editor editor = p.edit();
        editor.clear();
        editor.commit();
    }
}
