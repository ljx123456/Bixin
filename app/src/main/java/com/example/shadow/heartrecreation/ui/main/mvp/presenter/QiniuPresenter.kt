package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.qiniu.SendAppFile
import com.example.shadow.heartrecreation.qiniu.SendFileInterface
import com.example.shadow.heartrecreation.ui.main.mvp.bean.QiniuTokenBean
import com.example.shadow.heartrecreation.ui.main.mvp.data.QiniuTokenData
import com.example.shadow.heartrecreation.ui.main.mvp.view.QiniuView
import com.example.shadow.heartrecreation.utils.utils.Toast
import io.reactivex.disposables.Disposable

class QiniuPresenter(owner: LifecycleOwner, val view: QiniuView, val mContext: Context) : BasePresenter(owner, view, mContext), QiniuTokenData.QiniuToken, SendFileInterface {
    //上传成功
    override fun sendSucceed(fileUrlList: ArrayList<String>) {
        view.dismissLoading(mContext)
        view.sendSucceedImage(fileUrlList)
    }

    //上传失败
    override fun sendFileError(msg: String) {
        view.dismissLoading(mContext)
        Toast.Tips(msg)
        view.sendFileErrorImage()
    }

    private val qiniu = QiniuTokenData(this)
    private var imageList = ArrayList<String>()
    //获取Token成功
    override fun getQiniuTokenRequest(data: QiniuTokenBean) {
        SendAppFile.sendImageFile(imageList, data.data.token, this)
    }

    //获取Token失败
    override fun getQiniuTokenError() {
        view.dismissLoading(mContext)
    }

    fun setImage(file: ArrayList<String>) {
        view.showLoading(mContext)
        imageList.clear()
        imageList = file
        qiniu.getQiniuToken()
    }


    override fun addDisposableList(list: ArrayList<Disposable>) {
        qiniu.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}