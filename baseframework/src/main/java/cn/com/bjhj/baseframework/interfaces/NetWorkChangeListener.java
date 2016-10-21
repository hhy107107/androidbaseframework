package cn.com.bjhj.baseframework.interfaces;

/**
 * 类介绍(必填)：网络监听
 * Created by huiyao huang on 2016/9/14  10:49.
 */

public interface NetWorkChangeListener {

    /**
     * 网络是否可用
     * @param available
     */
    void onNetWorkChange(boolean available);
}
