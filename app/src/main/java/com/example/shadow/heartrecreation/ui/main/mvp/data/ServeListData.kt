package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.ServeListBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ServeListData(val servelist: ServeList) : BaseData<ServeListBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getServeList(body: ServeListBody) {
        api(Api.getApi().getServeList(body)).build()
    }

    override fun onSucceedRequest(data: ServeListBean, what: Int) {
        servelist.getServeListRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        servelist.getServeListError()
    }

    interface ServeList {
        fun getServeListRequest(data: ServeListBean)
        fun getServeListError()
    }
}