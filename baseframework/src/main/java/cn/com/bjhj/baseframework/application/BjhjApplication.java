package cn.com.bjhj.baseframework.application;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 * 类介绍(必填)：基础application
 * Created by huiyao huang on 2016/10/17  14:13.
 */

public class BjhjApplication extends Application{

    public static boolean DEBUG = true; //调试模式 打包的时候改成false 以减少 资源占用
    public static BjhjApplication application; //application 上下文
    private List<Activity> activityList = new LinkedList<Activity>(); //activity集合 用于统一关闭activity

    /**
     * 添加一个Activity
     * @param activity this activity
     */
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    /**
     * 完全退出一个应用  退出程序时调用
     */
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }

    /**
     * 获取当前栈里的Activity
     * @return activity list
     */
    public List<Activity> getActivityList(){
        return activityList;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
