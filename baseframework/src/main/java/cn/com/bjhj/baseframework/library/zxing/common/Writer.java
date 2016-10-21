package cn.com.bjhj.baseframework.library.zxing.common;

import java.util.Map;

import cn.com.bjhj.baseframework.library.zxing.BarcodeFormat;
import cn.com.bjhj.baseframework.library.zxing.EncodeHintType;
import cn.com.bjhj.baseframework.library.zxing.WriterException;

/**
 * 类介绍(必填)：
 * Created by Administrator on 2016/10/19  16:23.
 */
public interface Writer {
    BitMatrix encode(String var1, BarcodeFormat var2, int var3, int var4) throws WriterException;

    BitMatrix encode(String var1, BarcodeFormat var2, int var3, int var4, Map<EncodeHintType, ?> var5) throws WriterException;
}
