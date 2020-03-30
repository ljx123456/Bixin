package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.ExpireRecordBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.ExpireRecordBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ExpireRecordData(val expirerecord: ExpireRecord) : BaseData<ExpireRecordBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getExpireRecord(body: ExpireRecordBody) {
        api(Api.getApi().getExpireRecord(body)).build()
    }

    override fun onSucceedRequest(data: ExpireRecordBean, what: Int) {
        expirerecord.getExpireRecordRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        expirerecord.getExpireRecordError()
    }

    interface ExpireRecord {
        fun getExpireRecordRequest(data: ExpireRecordBean)
        fun getExpireRecordError()
    }
}