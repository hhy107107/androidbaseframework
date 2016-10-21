package cn.com.bjhj.baseframework.interfaces;


import cn.com.bjhj.baseframework.library.pulltorefresh.PullToRefreshScrollView;

/**
 * 类介绍(必填)：开放 onScrollChanged监听
 * Created by huiyao huang on 2016/9/25  10:05.
 */

public interface  ScrollViewListener {
    void onScrollChanged(PullToRefreshScrollView scrollView, int x, int y, int oldx, int oldy);
}
