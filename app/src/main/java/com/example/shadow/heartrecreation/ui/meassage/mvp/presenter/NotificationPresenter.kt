package com.example.shadow.heartrecreation.ui.meassage.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.meassage.mvp.view.NotificationView
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.NotificationBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.ReadNotificationBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.NotificationBody
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.ReadNotificationBody
import com.example.shadow.heartrecreation.ui.meassage.mvp.data.NotificationData
import com.example.shadow.heartrecreation.ui.meassage.mvp.data.ReadNotificationData
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class NotificationPresenter(owner: LifecycleOwner, val view: NotificationView, val mContext: Context) : BasePresenter(owner, view, mContext), NotificationData.Notification, ReadNotificationData.ReadNotification {
    override fun getReadNotificationRequest(data: ReadNotificationBean) {
        view.getReadRequest(data)
    }

    override fun getReadNotificationError() {

    }


    private val notificationdata = NotificationData(this)
    private val read= ReadNotificationData(this)

    override fun getNotificationRequest(data: NotificationBean) {
//        view.dismissLoading(mContext)
        view.getNotificationRequest(data)
    }

    override fun getNotificationError() {
//        view.dismissLoading(mContext)
        view.getNotificationError()
    }

    fun getNotification(body: NotificationBody) {
//        view.showLoading(mContext)
        notificationdata.getNotification(body)
    }

    fun read(body: ReadNotificationBody){
        read.getReadNotification(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {

    }

    override fun presenterDestroy() {
    }
}