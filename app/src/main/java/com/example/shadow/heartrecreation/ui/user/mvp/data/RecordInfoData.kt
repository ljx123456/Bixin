package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RecordInfoBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RecordDetailsOneBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class RecordInfoData(val recordinfo: RecordInfo) : BaseData<RecordInfoBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getRecordInfo(body: RecordDetailsOneBody) {
        api(Api.getApi().getRecordInfo(body)).build()
    }

    override fun onSucceedRequest(data: RecordInfoBean, what: Int) {
        recordinfo.getRecordInfoRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        recordinfo.getRecordInfoError()
    }

    interface RecordInfo {
        fun getRecordInfoRequest(data: RecordInfoBean)
        fun getRecordInfoError()
    }
}