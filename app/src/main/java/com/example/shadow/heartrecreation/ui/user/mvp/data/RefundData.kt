package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RefundBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class RefundData(val refund: Refund) : BaseData<RefundBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getRefund(body: RefundBody) {
        api(Api.getApi().getRefund(body)).build()
    }

    override fun onSucceedRequest(data: RefundBean, what: Int) {
        refund.getRefundRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        refund.getRefundError()
    }

    interface Refund {
        fun getRefundRequest(data: RefundBean)
        fun getRefundError()
    }
}