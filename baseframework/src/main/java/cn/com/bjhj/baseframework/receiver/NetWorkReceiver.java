package cn.com.bjhj.baseframework.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import cn.com.bjhj.baseframework.interfaces.NetWorkChangeListener;
import cn.com.bjhj.baseframework.utils.L;

/**
 * 类介绍(必填)：网络变化监听
 * Created by huiyao huang on 2016/9/14  10:31.
 */

public class NetWorkReceiver extends BroadcastReceiver {
    NetWorkChangeListener netWorkChangeListener;

    public NetWorkReceiver(NetWorkChangeListener netWorkChangeListener){
        this.netWorkChangeListener = netWorkChangeListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        L.i("执行了");
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            L.i("连接到网络");
            if(netWorkChangeListener != null){
                L.i("通知网络已经连接");
                netWorkChangeListener.onNetWorkChange(true);
            }
        } else {
            L.i("网络已断开");
            if(netWorkChangeListener != null){
                netWorkChangeListener.onNetWorkChange(false);
            }
        }
    }
}