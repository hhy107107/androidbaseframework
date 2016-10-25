package cn.com.bjhj.baseframework.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import cn.com.bjhj.baseframework.R;
import cn.com.bjhj.baseframework.application.BjhjApplication;
import cn.com.bjhj.baseframework.interfaces.NetWorkChangeListener;
import cn.com.bjhj.baseframework.receiver.NetWorkReceiver;
import cn.com.bjhj.baseframework.ui.annotation.AnnotateUtils;
import cn.com.bjhj.baseframework.ui.widget.TitleBar;
import cn.com.bjhj.baseframework.utils.DialogUtils;
import cn.com.bjhj.baseframework.utils.L;
import cn.com.bjhj.baseframework.utils.NetworkUtils;
import cn.com.bjhj.baseframework.utils.T;

/**
 * 类介绍(必填)：基础Activity
 * Created by huiyao huang on 2016/10/22  9:46.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements IBaseActivity,View.OnClickListener , NetWorkChangeListener {
    protected BaseActivity mContext;//上下文
    protected TitleBar titleBar;//标题栏

    protected int pageNum = 1; //第一页
    protected int pageSize = 20; //每页20条
    protected boolean lastPage = true;//最后一页
    protected boolean firstPage = true;//第一页

    protected boolean hasPermission;//有权限
    public static boolean isForeground = false; //是否在前台

    private IntentFilter intentFilter;
    private NetWorkReceiver networkChangeReceive; //网络状态监听

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!NetworkUtils.isNetworkAvailable(this)){
            T.showThort(this , "您没有可用的网络");
        }
        mContext = this;
        BjhjApplication.application.addActivity(this);

        this.setRootView();
        AnnotateUtils.initBindView(this);
        initTitle();
        this.initWidget();
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
    private void initTitle() {
        titleBar = (TitleBar) findViewById(R.id.titleBar);
        if(titleBar != null){
            titleBar.showLeftAndCenter();
            ImageButton left = titleBar.getLeftBtn();
            left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        L.i("返回键");
        DialogUtils.closeProgressDia();
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isForeground = false;
        if(networkChangeReceive != null){
            try{
                unregisterReceiver(networkChangeReceive);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isForeground = true;
        //addAction
        if(intentFilter == null){
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        networkChangeReceive = new NetWorkReceiver(this);
        try{
            registerReceiver(networkChangeReceive, intentFilter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public abstract void setRootView() ;

    @Override
    public abstract void initWidget() ;

    @Override
    public abstract void widgetClick(View var1) ;

    @Override
    public void onClick(View v) {
        this.widgetClick(v);
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
     * 跳转 activity(关闭本身) 无参数
     * @param aty this activity
     * @param cls target activity
     * @param flag flag
     */
    public void skipActivity(Activity aty, Class<?> cls ,int flag) {
        this.showActivity(aty, cls , flag);
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
     * 显示一个新的activity(不关闭自己)
     * @param aty this activity
     * @param cls target activity
     * @param flag flag
     */
    public void showActivity(Activity aty, Class<?> cls , int flag) {
        Intent intent = new Intent();
        intent.setClass(aty, cls);
        intent.setFlags(flag);
        aty.startActivity(intent);
    }

    /**
     * 显示一个新的activity(不关闭自己)
     * @param aty this activity
     * @param cls target activity
     * @param code 请求码
     */
    public void showActivityForResult(Activity aty, Class<?> cls , int code) {
        Intent intent = new Intent();
        intent.setClass(aty, cls);
        aty.startActivityForResult(intent , code);
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

    /**
     * 显示一个新的activity 带参数（不关闭自己）
     * @param aty this activity
     * @param cls target activity
     * @param extras 参数
     * @param code 请求参数
     */
    public void showActivityForResult(Activity aty, Class<?> cls, Bundle extras , int code) {
        Intent intent = new Intent();
        intent.putExtras(extras);
        intent.setClass(aty, cls);
        aty.startActivityForResult(intent , code);
    }


}
