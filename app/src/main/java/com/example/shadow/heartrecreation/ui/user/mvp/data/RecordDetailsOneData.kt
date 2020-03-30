package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RecordDetailsOneBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RecordDetailsOneBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class RecordDetailsOneData(val recorddetailsone: RecordDetailsOne) : BaseData<RecordDetailsOneBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getRecordDetailsOne(body: RecordDetailsOneBody) {
        api(Api.getApi().getRecordDetailsOne(body)).build()
    }

    override fun onSucceedRequest(data: RecordDetailsOneBean, what: Int) {
        recorddetailsone.getRecordDetailsOneRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        recorddetailsone.getRecordDetailsOneError()
    }

//    fun getRecordInfo(recordDetailsOneBody: RecordDetailsOneBody) {
//        api(Api.getApi().getRecordInfo(recordDetailsOneBody)).build()
//    }

    interface RecordDetailsOne {
        fun getRecordDetailsOneRequest(data: RecordDetailsOneBean)
        fun getRecordDetailsOneError()
    }
}