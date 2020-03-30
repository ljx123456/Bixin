package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.user.mvp.bean.TakeRecordListBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.TakeRecordListBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class TakeRecordListData(val takerecordlist: TakeRecordList) : BaseData<TakeRecordListBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getTakeRecordList(body: TakeRecordListBody) {
        api(Api.getApi().getRecordLists(body)).build()
    }

    override fun onSucceedRequest(data: TakeRecordListBean, what: Int) {
        takerecordlist.getTakeRecordListRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        takerecordlist.getTakeRecordListError()
    }

    fun getRecordList(takeRecordListBody: TakeRecordListBody) {
        api(Api.getApi().getRecordList(takeRecordListBody)).build()
    }

    fun getExpireRecordList(takeRecordListBody: TakeRecordListBody) {
        api(Api.getApi().getExpireRecordList(takeRecordListBody)).build()
    }

    interface TakeRecordList {
        fun getTakeRecordListRequest(data: TakeRecordListBean)
        fun getTakeRecordListError()
    }
}