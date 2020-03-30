package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.StorageRecordBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.StorageRecordBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class StorageRecordData(val storagerecord: StorageRecord) : BaseData<StorageRecordBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getStorageRecord(body: StorageRecordBody) {
        api(Api.getApi().getStorageRecord(body)).build()
    }

    fun getTakeRecord(body: StorageRecordBody) {
        api(Api.getApi().getTakeRecord(body)).build()
    }

    override fun onSucceedRequest(data: StorageRecordBean, what: Int) {
        storagerecord.getStorageRecordRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        storagerecord.getStorageRecordError()
    }

    interface StorageRecord {
        fun getStorageRecordRequest(data: StorageRecordBean)
        fun getStorageRecordError()
    }
}