package cn.com.bjhj.baseframework.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类介绍(必填)：字符串处理类
 * Created by huiyao huang on 2016/9/2  14:20.
 */

public class StringUtils {

    /**
     * 字符串非空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return str != null && str.trim().length() > 0;
    }

    /**
     * 字符串为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

    /**
     * 根据URL 获取文件后缀
     * @param url
     * @return
     */
    public static String getFileExtensions(String url){
        if(StringUtils.isEmpty(url)) return "";
        L.i("url == " + url );
        String extension = "";
        String[] strs = url.split("/");

        String temp = strs[strs.length-1];
        String[] temps = temp.split("\\.");

        extension = temps[temps.length-1];
        return extension;
    }

    /**
     * 判断手机号码
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        Pattern p = Pattern.compile("^((13[0-9])|(17[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        System.out.println(m.matches()+"---");
        return m.matches();

    }

    /**
     * string 图片适配webview
     * @param string
     * @return
     */
    public static String getHtmlStr(String string){
        StringBuffer resultStr = new StringBuffer();
        String contentStr = string;
        String htmlStr = "<Html>\n" +"<style>\n" +
                "\timg{max-width:100%;}\n" +
                "</style>\t <Body >";
        String htmlStr2 = "  \t</Body>\n" +
                "  </Html>";
        resultStr.append(htmlStr);
        resultStr.append(contentStr);
        resultStr.append(htmlStr2);
        L.i(resultStr.toString());
        return resultStr.toString();
    }

    /**
     * string 图片适配webview
     * @param string
     * @return
     */
    public static String getHtmlStr(String string , String jsStr){
        StringBuffer resultStr = new StringBuffer();
        String htmlStr = "<Html>\n" +"<style>\n" +
                "\timg{max-width:100%;}\n" +
                "</style>\t <Body >";
        String htmlStr2 = "  \t</Body>\n" +
                "  </Html>";
        resultStr.append(htmlStr);
        resultStr.append(string);
        resultStr.append(jsStr);
        resultStr.append(htmlStr2);
        L.i(resultStr.toString());
        return resultStr.toString();
    }

    /**
     * 查找str中 以a开头，b结尾的字符串  集合
     * @param str
     * @param a
     * @param b
     * @return
     */
    public static List<String> getStrStartAEndB(String str , String a, String b){
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile(a+"(.*?)"+b);
        Matcher m = p.matcher(str);
        //L.i("m.groupCount() -- > " + m.groupCount());
        while(m.find()) {
            list.add(m.group());
        }
        return list;
    }

}
