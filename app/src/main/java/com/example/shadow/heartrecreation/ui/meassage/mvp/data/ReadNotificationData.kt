package com.example.shadow.heartrecreation.ui.meassage.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.ReadNotificationBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.ReadNotificationBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ReadNotificationData(val notification: ReadNotification) : BaseData<ReadNotificationBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)
    fun getReadNotification(body: ReadNotificationBody) {
        api(Api.getApi().getReadNotification(body)).build()
    }

    override fun onSucceedRequest(data: ReadNotificationBean, what: Int) {
        notification.getReadNotificationRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        notification.getReadNotificationError()
    }

    interface ReadNotification {
        fun getReadNotificationRequest(data: ReadNotificationBean)
        fun getReadNotificationError()
    }
}