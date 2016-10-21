package cn.com.bjhj.baseframework.ui.annotation;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;

import java.lang.reflect.Field;

/**
 * 类介绍(必填)：处理注解绑定控件
 * Created by huiyao huang on 2016/9/1  12:48.
 */

public class AnnotateUtils {


    public static void initBindView(Object currentClass, View sourceView) {
        Field[] fields = currentClass.getClass().getDeclaredFields();
        if(fields != null && fields.length > 0) {
            Field[] var6 = fields;
            int var5 = fields.length;

            for(int var4 = 0; var4 < var5; ++var4) {
                Field field = var6[var4];
                BindView bindView = (BindView)field.getAnnotation(BindView.class);
                if(bindView != null) {
                    int viewId = bindView.id();
                    boolean clickLis = bindView.click();

                    try {
                        field.setAccessible(true);
                        if(clickLis) {
                            sourceView.findViewById(viewId).setOnClickListener((View.OnClickListener)currentClass);
                        }

                        field.set(currentClass, sourceView.findViewById(viewId));
                    } catch (Exception var11) {
                        var11.printStackTrace();
                    }
                }
            }
        }

    }

    public static void initBindView(Activity aty) {
        initBindView(aty, aty.getWindow().getDecorView());
    }

    public static void initBindView(View view) {
        Context cxt = view.getContext();
        if(cxt instanceof Activity) {
            initBindView((Activity)cxt);
        } else {
            throw new RuntimeException("view must into Activity");
        }
    }

    public static void initBindView(Fragment frag) {
        initBindView(frag, frag.getActivity().getWindow().getDecorView());
    }
}
