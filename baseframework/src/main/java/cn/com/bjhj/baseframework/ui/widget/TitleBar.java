package cn.com.bjhj.baseframework.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.com.bjhj.baseframework.R;


/**
 * 类介绍(必填)：通用标题栏
 * Created by huiyao huang on 2016/9/3  14:56.
 */

public class TitleBar extends RelativeLayout {
    private ImageButton leftBtn; //左边按钮，一般是返回键
    private ImageButton leftBtn2; //左边按钮，一般是返回键,webview 专用  返回上一层页面
    private ImageButton rightBtn; //右边按钮
    private TextView rightTxt; //右边文字
    private TextView titleTxt;//中间文字

    public TitleBar(Context context) {
        super(context);
        init(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.title_bar, this);
        leftBtn = (ImageButton) findViewById(R.id.header_left_small);
        leftBtn2 = (ImageButton) findViewById(R.id.header_left_small2);
        rightBtn = (ImageButton) findViewById(R.id.header_right_small);
        rightTxt = (TextView) findViewById(R.id.header_right_complete);
        titleTxt = (TextView) findViewById(R.id.header_title);
    }

    public ImageButton getLeftBtn(){
        return leftBtn;
    }
    public ImageButton getLeftBtn2(){
        return leftBtn2;
    }

    /**
     * webview 模式
     */
    public void showWebViewModel(){
        leftBtn.setVisibility(VISIBLE);
        leftBtn2.setVisibility(VISIBLE);
        rightTxt.setVisibility(INVISIBLE);
        rightBtn.setVisibility(INVISIBLE);
        titleTxt.setVisibility(VISIBLE);
    }

    /**
     * 显示返回键和标题
     */
    public void showLeftAndCenter(){
        leftBtn.setVisibility(VISIBLE);
        rightBtn.setVisibility(INVISIBLE);
        rightTxt.setVisibility(GONE);
        titleTxt.setVisibility(VISIBLE);
    }

    /**
     * 只显示返回键
     */
    public void showOnlyLeftBtn(){
        titleTxt.setVisibility(GONE);
        rightBtn.setVisibility(GONE);
        rightTxt.setVisibility(GONE);
        leftBtn.setVisibility(VISIBLE);
    }

    /**
     * 只显示标题栏
     */
    public void showOnlyTitle(){
        leftBtn.setVisibility(GONE);
        rightBtn.setVisibility(GONE);
        rightTxt.setVisibility(GONE);
        titleTxt.setVisibility(VISIBLE);
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title){
        titleTxt.setText(title);
    }

    /**
     * 设置返回键图标
     * @param imageResourceId
     */
    public void setLeftImageResource(int imageResourceId){
        leftBtn.setImageResource(imageResourceId);
    }

    /**
     * 设置右边图标
     * @param imageResourceId
     */
    public void setRightImageResource(int imageResourceId){
        rightBtn.setImageResource(imageResourceId);
        rightBtn.setVisibility(VISIBLE);
    }

    /**
     * 获取右边按钮
     * @return
     */
    public ImageButton getRightBtn(){
        return rightBtn;
    }
    /**
     * 设置右边文字
     * @param txt
     */
    public void setRightTxt(String txt){
        rightTxt.setText(txt);
        rightTxt.setVisibility(VISIBLE);
        rightBtn.setVisibility(GONE);
    }

    /**
     * 设置文字并设置点击事件
     * @param txt
     * @param clickListener
     */
    public void setRightTxt(String txt , OnClickListener clickListener){
        rightTxt.setText(txt);
        rightTxt.setVisibility(VISIBLE);
        rightBtn.setVisibility(GONE);
        rightTxt.setOnClickListener(clickListener);
    }


}
