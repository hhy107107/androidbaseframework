package cn.com.bjhj.baseframework.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import cn.com.bjhj.baseframework.R;
import cn.com.bjhj.baseframework.interfaces.NetWorkChangeListener;
import cn.com.bjhj.baseframework.ui.annotation.AnnotateUtils;
import cn.com.bjhj.baseframework.ui.widget.TitleBar;

/**
 * 类介绍(必填)：基础fragment
 * Created by huiyao huang on 2016/9/2  8:47.
 */
public abstract class HHYBaseFragment extends Fragment implements View.OnClickListener , NetWorkChangeListener {
    protected Activity mContext;
    protected TitleBar titleBar;//标题栏

    protected int pageNum = 1; //第一页
    protected int pageSize = 20; //每页20条
    protected boolean lastPage = true;//最后一页
    protected boolean firstPage = true;//第一页
    public boolean hasPermission;//有权限

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = this.inflaterView(inflater, container, savedInstanceState);
        AnnotateUtils.initBindView(this, view);
        initTitle(view);
        this.initWidget(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * 设置根布局
     * @param var1 inflater
     * @param var2 container
     * @param var3 bundle
     * @return root view
     */
    protected abstract View inflaterView(LayoutInflater var1, ViewGroup var2, Bundle var3);

    /**
     * 初始化控件
     * @param parentView root view
     */
    protected abstract void initWidget(View parentView);

    @Override
    public void onClick(View v) {
        this.widgetClick(v);
    }

    /**
     * 控件点击事件
     * @param v
     */
    protected void widgetClick(View v) {
    }

    /**
     * 跳转 activity(关闭本身) 无参数
     * @param aty this activity
     * @param cls target activity
     */
    public void skipActivity(Activity aty, Class<?> cls) {
        this.showActivity(aty, cls);
        aty.finish();
    }

    /**
     * 跳转activity(关闭本身) 带参数
     * @param aty this activity
     * @param cls target activity
     * @param extras 参数
     */
    public void skipActivity(Activity aty, Class<?> cls, Bundle extras) {
        this.showActivity(aty, cls, extras);
        aty.finish();
    }
    public void skipActivity(Activity aty, Class<?> cls, int flag) {
        this.showActivity(aty, cls, flag);
        aty.finish();
    }
    public void skipActivity(Activity aty, Class<?> cls, Bundle extras , int flag) {
        this.showActivity(aty, cls, extras ,flag);
        aty.finish();
    }
    /**
     * 显示一个新的activity(不关闭自己)
     * @param aty this activity
     * @param cls target activity
     */
    public void showActivity(Activity aty, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(aty, cls);
        aty.startActivity(intent);
    }

    /**
     * 显示一个新的activity 带参数（不关闭自己）
     * @param aty this activity
     * @param cls target activity
     * @param extras 参数
     */
    public void showActivity(Activity aty, Class<?> cls, Bundle extras) {
        Intent intent = new Intent();
        intent.putExtras(extras);
        intent.setClass(aty, cls);
        aty.startActivity(intent);
    }
    public void showActivity(Activity aty, Class<?> cls, int flag) {
        Intent intent = new Intent();
        intent.setFlags(flag);
        intent.setClass(aty, cls);
        aty.startActivity(intent);
    }
    /**
     * 显示一个新的activity 带参数（不关闭自己）
     * @param aty this activity
     * @param cls target activity
     * @param extras 参数
     */
    public void showActivity(Activity aty, Class<?> cls, Bundle extras , int flag) {
        Intent intent = new Intent();
        intent.putExtras(extras);
        intent.setClass(aty, cls);
        intent.setFlags(flag);
        aty.startActivity(intent);
    }
    /**
     * 设置标题栏文字
     * @param title
     */
    protected void setTitleTxt(String title) {
        if(titleBar != null){
            titleBar.setTitle(title);
        }
    }


    /**
     * 初始化标题栏
     */
    private void initTitle(View view) {
        titleBar = (TitleBar) view.findViewById(R.id.titleBar);
        if(titleBar != null){
            titleBar.showLeftAndCenter();
            ImageButton left = titleBar.getLeftBtn();
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().finish();
                }
            });
        }
    }

}
