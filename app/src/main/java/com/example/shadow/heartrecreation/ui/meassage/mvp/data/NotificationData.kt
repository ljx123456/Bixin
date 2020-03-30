package com.example.shadow.heartrecreation.ui.meassage.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.NotificationBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.NotificationBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class NotificationData(val notification: Notification) : BaseData<NotificationBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)
    fun getNotification(body: NotificationBody) {
        api(Api.getApi().getNotification(body)).build()
    }

    override fun onSucceedRequest(data: NotificationBean, what: Int) {
        notification.getNotificationRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        notification.getNotificationError()
    }

    interface Notification {
        fun getNotificationRequest(data: NotificationBean)
        fun getNotificationError()
    }
}