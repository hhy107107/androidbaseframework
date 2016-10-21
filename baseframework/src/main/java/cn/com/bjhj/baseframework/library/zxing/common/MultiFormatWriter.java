package cn.com.bjhj.baseframework.library.zxing.common;

import java.io.Writer;
import java.util.Map;

import cn.com.bjhj.baseframework.library.zxing.BarcodeFormat;
import cn.com.bjhj.baseframework.library.zxing.EncodeHintType;
import cn.com.bjhj.baseframework.library.zxing.WriterException;

/**
 * 类介绍(必填)：
 * Created by Administrator on 2016/10/19  16:22.
 */

public final class MultiFormatWriter implements Writer {
    public MultiFormatWriter() {
    }

    public BitMatrix encode(String contents, BarcodeFormat format, int width, int height) throws WriterException {
        return this.encode(contents, format, width, height, (Map)null);
    }

    public BitMatrix encode(String contents, BarcodeFormat format, int width, int height, Map<EncodeHintType, ?> hints) throws WriterException {
        Object writer;
        switch($SWITCH_TABLE$com$google$zxing$BarcodeFormat()[format.ordinal()]) {
            case 1:
                writer = new AztecWriter();
                break;
            case 2:
                writer = new CodaBarWriter();
                break;
            case 3:
                writer = new Code39Writer();
                break;
            case 4:
            case 10:
            case 13:
            case 14:
            default:
                throw new IllegalArgumentException("No encoder available for format " + format);
            case 5:
                writer = new Code128Writer();
                break;
            case 6:
                writer = new DataMatrixWriter();
                break;
            case 7:
                writer = new EAN8Writer();
                break;
            case 8:
                writer = new EAN13Writer();
                break;
            case 9:
                writer = new ITFWriter();
                break;
            case 11:
                writer = new PDF417Writer();
                break;
            case 12:
                writer = new QRCodeWriter();
                break;
            case 15:
                writer = new UPCAWriter();
        }

        return ((Writer)writer).encode(contents, format, width, height, hints);
    }
}
