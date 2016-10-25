package cn.com.bjhj.baseframework.ui.activity;

import android.view.View;

/**
 * 类介绍(必填)：接口  base activity实现
 * Created by huiyao huang on 2016/9/1  12:54.
 */

public interface IBaseActivity {
    /**
     * 设置根布局
     */
    void setRootView();

    /**
     * 设置控件
     */
    void initWidget();

    /**
     * 控件单击事件
     * @param var1 控件
     */
    void widgetClick(View var1);
}