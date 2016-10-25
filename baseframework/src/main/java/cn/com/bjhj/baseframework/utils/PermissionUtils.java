package cn.com.bjhj.baseframework.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import cn.com.bjhj.baseframework.constants.PermissionCode;

/**
 * 类介绍(必填)：6.0权限申请
 * Created by huiyao huang on 2016/8/4  13:20.
 */

public class PermissionUtils {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    /**
     * sdcard 读写权限
     *  Checks if the app has permission to write to device storage
     *  If the app does not has permission then the user will be prompted to grant permissions
     * @param activity
     */
    public static boolean verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    PermissionCode.REQUEST_WRITE_EXTERNAL_STORAGE);
            return false;
        }
        return true;
    }

    /**
     * 询问sd cord 权限      和 相机权限
     * @param mActivity
     * @return 如果有权限，返回 true,没有权限，返回false,并且向用户请求权限
     */
    public static boolean requestSDCardPermission(Activity mActivity){
        // 判断SD卡是否存在，并且是否具有读写权限(针对6.0运行时权限)
        //Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
        boolean checkSDCardResult ;
        if(ContextCompat.checkSelfPermission(mActivity , Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            L.i("权限");
            ActivityCompat.requestPermissions(mActivity,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},10);
            checkSDCardResult = false;
        }else{
            checkSDCardResult = true;
        }

        boolean checkCameraResult;
        if(ContextCompat.checkSelfPermission(mActivity , Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //没有权限
            ActivityCompat.requestPermissions(mActivity , new String[]{Manifest.permission.CAMERA},10);
            checkCameraResult = false;
        }else{
            checkCameraResult = true;
        }

        return checkCameraResult && checkSDCardResult;
    }

    /**
     * 询问相机权限
     * @param mActivity activ
     * @return 如果有权限，返回 true,没有权限，返回false,并且向用户请求权限
     */
    public static boolean requestCameraPermission(Activity mActivity){
        if(ContextCompat.checkSelfPermission(mActivity , Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //没有权限
            ActivityCompat.requestPermissions(mActivity , new String[]{Manifest.permission.CAMERA}, PermissionCode.REQUEST_CAMERA);
            return false;
        }

        return true;
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener , Activity activity) {
        new AlertDialog.Builder(activity)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

}
