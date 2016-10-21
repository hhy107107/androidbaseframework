package cn.com.bjhj.baseframework.ui.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类介绍(必填)：通过注解绑定控件  id
 * Created by huiyao huang on 2016/9/1  12:49.
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BindView {
    int id(); //控件ID  必填

    boolean click() default false;  //控件点击事件 可选
}