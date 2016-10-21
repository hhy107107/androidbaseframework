package cn.com.bjhj.baseframework.library.zxing.camera.open;

import android.hardware.Camera;

import cn.com.bjhj.baseframework.others.myzxing.camera.open.OpenCameraInterface;

/**
 * Default implementation for Android before API 9 / Gingerbread.
 */
final class DefaultOpenCameraInterface implements OpenCameraInterface {

	/**
	 * Calls {@link Camera#open()}.
	 */
	@Override
	public Camera open() {
		return Camera.open();
	}
}
