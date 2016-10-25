package cn.com.bjhj.baseframework.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast 处理类...
 * Created by huiyao huang on 11/17/2015.
 */
public class T {

    private static Toast toast; //确保永远只有一个Toast

    /**
     * 显示短的吐司
     * @param context 上下文
     * @param str 提示文字
     */
    public static void showThort(Context context , String str){
        if(context != null){
            showToast(context , str ,Toast.LENGTH_SHORT);
        }
    }

    /**
     * 显示长的吐司
     * @param context 上下文
     * @param str 提示文字
     */
    public static void showLong(Context context , String str){
        if(context != null){
            showToast(context, str , Toast.LENGTH_LONG );
        }
    }

    /**
     * 显示吐司
     * @param context 上下文
     * @param str 内容
     * @param length 显示时间
     */
    private static void showToast(Context context , String str , int length){
        if(toast != null){
            toast.cancel();
        }
        toast = null;
        toast = Toast.makeText(context,str, length);
        toast.show();

    }

    /**
     * 取消  吐司
     * 在base里面 调用
     *
     */
    public static void cancelToast(){
        L.i("取消吐司");
        if(toast != null){
            toast.cancel();
        }
    }
}
