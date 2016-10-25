package cn.com.bjhj.baseframework.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.WriterException;

import cn.com.bjhj.baseframework.R;
import cn.com.bjhj.baseframework.http.AsyncHttpClient;
import cn.com.bjhj.baseframework.others.myzxing.utils.Utils;

/**
 * 类介绍(必填)：dialog工具类
 * Created by huiyao huang on 2016/9/1  15:10.
 */

public class DialogUtils {

    private static Dialog progressDialog; // 加载进度
    private static Dialog progressDialog1; // 加载进度
    private static Dialog progressDialog2; // 加载进度

    /**
     * 关闭进度弹窗
     */
    public static void closeProgressDia(){
        L.i("执行了关闭");
        if(progressDialog != null){
            progressDialog.cancel();
            L.i("关闭0");
        }
        if(progressDialog1 != null){
            progressDialog1.cancel();
            L.i("关闭1");
        }
        if(progressDialog2 != null){
            progressDialog2.cancel();
            L.i("关闭2");
        }
    }

    /**
     * 显示进度弹窗
     * @param context
     */
    public static void showProgressDia(final Context context) {
        if(context == null) return;
        if(progressDialog1 != null){
            progressDialog1.cancel();
            progressDialog1 = null;
        }
        progressDialog1 = new Dialog(context , R.style.Dialogstyle);
        progressDialog1.setCancelable(true);
        progressDialog1.setCanceledOnTouchOutside(false);
        progressDialog1.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_BACK){
                    closeProgressDia();
                    return true;
                }
                return false;
            }
        });
        progressDialog1.show();
        Window window = progressDialog1.getWindow();
        window.setContentView(R.layout.dialog_http_progress2);
        ImageView img = (ImageView) window.findViewById(R.id.load_img);
        Animation operatingAnim = AnimationUtils.loadAnimation(context, R.anim.circel);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        img.startAnimation(operatingAnim);
    }

    /**
     * 显示进度弹窗 白色
     * @param context
     */
    public static void showProgressDiaWhite(final Context context) {
        if(context == null) return;
        if(progressDialog2 != null){
            progressDialog2.cancel();
            progressDialog2 = null;
        }
        progressDialog2 = new Dialog(context , R.style.Dialogstyle);
        progressDialog2.setCancelable(true);
        progressDialog2.setCanceledOnTouchOutside(false);
        progressDialog2.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_BACK){
                    closeProgressDia();
                    return true;
                }
                return false;
            }
        });
        progressDialog2.show();
        Window window = progressDialog2.getWindow();
        window.setContentView(R.layout.dialog_http_progress3);
        ImageView img = (ImageView) window.findViewById(R.id.load_img);
        Animation operatingAnim = AnimationUtils.loadAnimation(context, R.anim.circel);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        img.startAnimation(operatingAnim);
    }

    /**
     * 显示进度弹窗
     * @param context
     * @param text 文字
     * @param client
     */
    public static void showProgressDia2(final Context context, final String text, final AsyncHttpClient client) {
        if(context == null) return;
        if(progressDialog != null){
            progressDialog.cancel();
            progressDialog = null;
        }
        progressDialog = new Dialog(context, R.style.Dialogstyle);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_BACK){
                    closeProgressDia();
                    return true;
                }
                return false;
            }
        });
        progressDialog.show();
        Window window = progressDialog.getWindow();
        window.setContentView(R.layout.dialog_http_progress);
        progressDialog.getWindow().setGravity(Gravity.CENTER);
        progressDialog.getWindow().setLayout(LayoutValue.SCREEN_WIDTH * 5 / 7, WindowManager.LayoutParams.WRAP_CONTENT);
        TextView textView = (TextView) window.findViewById(R.id.progress_TV);
        textView.setText(text);
        window.findViewById(R.id.dialog_http_dismiss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                progressDialog.dismiss();
                progressDialog = null;
                client.cancelRequests(context, true);
            }
        });
    }


    public static Dialog rqcode = null;
    public static void showRQcode(final Context context ,String qrStr){
        rqcode = new Dialog(context, R.style.Dialogstyle);
        rqcode.setCanceledOnTouchOutside(true);
        rqcode.setCancelable(true);
        rqcode.show();
        Window window = rqcode.getWindow();
        if(window != null){
            window.setGravity(Gravity.CENTER);
            window.setContentView(R.layout.dialog_rqcode2);
            window.setGravity(Gravity.CENTER);
            window.setLayout(DensityUtil.getScreenW(context) * 5 / 7, WindowManager.LayoutParams.WRAP_CONTENT);
            try {
                Bitmap b = Utils.Create2DCode(context,qrStr);
                ImageView img = (ImageView) rqcode.findViewById(R.id.rqcodeImg);
                img.setImageBitmap(b);
            } catch (WriterException e) {
                e.printStackTrace();
            }
        }
    }
}
