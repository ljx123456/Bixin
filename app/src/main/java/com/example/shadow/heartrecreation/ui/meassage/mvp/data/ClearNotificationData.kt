package com.example.shadow.heartrecreation.ui.meassage.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.ClearNotificationBean
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ClearNotificationData(val clear: ClearNotification) : BaseData<ClearNotificationBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)
    fun getClearNotification() {
        api(Api.getApi().getClearNotification()).build()
    }

    override fun onSucceedRequest(data: ClearNotificationBean, what: Int) {
        clear.getClearNotificationRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        clear.getClearNotificationError()
    }

    interface ClearNotification {
        fun getClearNotificationRequest(data: ClearNotificationBean)
        fun getClearNotificationError()
    }
}