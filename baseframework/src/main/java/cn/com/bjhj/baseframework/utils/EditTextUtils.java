package cn.com.bjhj.baseframework.utils;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * 类介绍(必填)：EditText 相关
 * Created by huiyao huang on 2016/9/1  14:52.
 */

public class EditTextUtils {
    InputMethodManager imm;

    private static EditTextUtils instance;
    private EditTextUtils(){}
    public static EditTextUtils getInstance(){
        if(instance == null){
            instance = new EditTextUtils();
        }
        return instance;
    }

    /**
     * 判断输入框里是否有数据
     * @param editText this edittext
     * @return boolean
     */
    public boolean isNull(EditText editText){
        if(editText == null) return true;
        Editable str = editText.getText();
        if(str == null) return true;
        if(str.length() == 0) return true;
        try {
            if (str.toString().trim().length() == 0) return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断输入框里是否有数据
     * @param editText this edittext
     * @return boolean
     */
    public boolean isNotNull(EditText editText){
        return !isNull(editText);
    }

    /**
     * 显示软键盘
     * @param context 上下文
     * @param view 接收键盘输入的视图
     */
    public void showKeyBoard(Context  context ,View view){
        L.e("执行了");
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
    }

    /**
     * 隐藏软键盘
     * @param context 上下文
     * @param view 接收键盘输入的视图
     */
    public void hideKeyBoard(Context context , View view){
        if(imm == null){
            imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
    }

    /**
     * 设置光标
     * @param charSequence 内容
     */
    public void setSelection(CharSequence charSequence){
        if (charSequence != null) {
            Spannable spanText = (Spannable)charSequence;
            Selection.setSelection(spanText, charSequence.length());
        }
    }
}
