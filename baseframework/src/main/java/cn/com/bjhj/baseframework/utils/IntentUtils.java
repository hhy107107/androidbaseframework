package cn.com.bjhj.baseframework.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * 类介绍(必填)：Intent 相关
 * Created by huiyao huang on 2016/9/29  9:08.
 */

public class IntentUtils {

    /**
     * 打开浏览器
     * @param activity
     * @param urlStr
     */
    public static void openBrowser(Activity activity , String urlStr){
        //urlText是一个文本输入框，输入网站地址
        //Uri  是统一资源标识符
        try{
            Uri uri = Uri.parse(urlStr);
            Intent  intent = new  Intent(Intent.ACTION_VIEW, uri);
            activity.startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 拨打电话
     * @param activity activity
     * @param phoneStr 电话号码
     */
    public static void openCallPhone(Activity activity , String phoneStr){
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phoneStr));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
}
