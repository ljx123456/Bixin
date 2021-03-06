package com.example.shadow.heartrecreation.utils.utils

import android.content.Intent
import android.support.v4.app.Fragment
import com.example.shadow.heartrecreation.base.BaseActivity
import com.muzhi.camerasdk.PyxCamera
import com.muzhi.camerasdk.model.CameraSdkParameterInfo

import java.util.*

/**
 * Created by Administrator on 2018/8/11 0011.
 */
class CameraSelect(private var face: CameraSelectFace) : PyxCamera.CameraImageCallBack {


    private lateinit var cameraPyx: PyxCamera
    private var cameraInfo = CameraSdkParameterInfo()


    //单选BaseActivity
    fun initSingleCameraSdk(context: BaseActivity) {
        cameraInfo.isSingleMode = true
        cameraInfo.isCutoutImage = true
        cameraInfo.isShowTailor = true
        cameraPyx = PyxCamera(context, cameraInfo)
        cameraPyx.setCameraImageCallBack(this)
    }

    //单选Fragment
    fun initSingleCameraSdk(context: Fragment) {
        cameraInfo.isSingleMode = true
        cameraInfo.isCutoutImage = true
        cameraInfo.isShowTailor = true
        cameraPyx = PyxCamera(context, cameraInfo)
        cameraPyx.setCameraImageCallBack(this)
    }


    //多选BaseActivity
    fun initMultiCameraSdk(context: BaseActivity) {
        cameraInfo.isOpenDialog = false
        cameraPyx = PyxCamera(context, cameraInfo)
        cameraPyx.setCameraImageCallBack(this)
    }


    //多选Fragment
    fun initMultiCameraSdk(context: Fragment) {
        cameraInfo.isOpenDialog = false
        cameraInfo.maxImage = 9
        cameraPyx = PyxCamera(context, cameraInfo)
        cameraPyx.setCameraImageCallBack(this)
    }

    //设置选择数量
    fun setImageNumber(imageNumber: Int) {
        cameraInfo.maxImage = imageNumber
    }

    //生命周期
    fun onActivityCameraResult(requestCode: Int, resultCode: Int, data: Intent?) {
        cameraPyx.let { it.onActivityCameraResult(requestCode, resultCode, data) }
    }


    //图片回调
    override fun returnCameraImageList(list: ArrayList<String>) {
        face.returnCameraImageList(list)
    }


    //删除图片
    fun deleteItem(position: Int) {
        cameraPyx.deleteImage(position)
    }


    //打开相册
    fun openCamera() = cameraPyx.let { it.openCamera() }


    //编辑资料专用-打开相册
    fun userInfoOpenCamera(imageNumber: Int) {
        cameraInfo = CameraSdkParameterInfo()
        cameraInfo.isOpenDialog = false
        cameraInfo.maxImage = imageNumber
        cameraPyx.setCameraSdkParameterInfo(cameraInfo)
        cameraPyx.openCamera()
    }


    interface CameraSelectFace {
        fun returnCameraImageList(list: ArrayList<String>)
    }

}