package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundServeBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RefundServeBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class RefundServeData(val refundserve: RefundServe) : BaseData<RefundServeBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getRefundServe(body: RefundServeBody) {
        api(Api.getApi().getRefundServe(body)).build()
    }

    override fun onSucceedRequest(data: RefundServeBean, what: Int) {
        refundserve.getRefundServeRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        refundserve.getRefundServeError()
    }

    interface RefundServe {
        fun getRefundServeRequest(data: RefundServeBean)
        fun getRefundServeError()
    }
}