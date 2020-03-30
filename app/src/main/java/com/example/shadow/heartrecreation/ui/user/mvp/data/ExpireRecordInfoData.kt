package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.ExpireRecordInfoBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.ExpireRecordInfoBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ExpireRecordInfoData(val expirerecordinfo: ExpireRecordInfo) : BaseData<ExpireRecordInfoBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getExpireRecordInfo(body: ExpireRecordInfoBody) {
        api(Api.getApi().getExpireRecordInfo(body)).build()
    }

    override fun onSucceedRequest(data: ExpireRecordInfoBean, what: Int) {
        expirerecordinfo.getExpireRecordInfoRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        expirerecordinfo.getExpireRecordInfoError()
    }

    interface ExpireRecordInfo {
        fun getExpireRecordInfoRequest(data: ExpireRecordInfoBean)
        fun getExpireRecordInfoError()
    }
}