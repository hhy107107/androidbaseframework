package cn.com.bjhj.baseframework.library.zxing;

/**
 * 类介绍(必填)：
 * Created by Administrator on 2016/10/19  16:24.
 */

public enum EncodeHintType {
    ERROR_CORRECTION,
    CHARACTER_SET,
    DATA_MATRIX_SHAPE,
    /** @deprecated */
    @Deprecated
    MIN_SIZE,
    /** @deprecated */
    @Deprecated
    MAX_SIZE,
    MARGIN,
    PDF417_COMPACT,
    PDF417_COMPACTION,
    PDF417_DIMENSIONS,
    AZTEC_LAYERS;

    private EncodeHintType() {
    }
}
