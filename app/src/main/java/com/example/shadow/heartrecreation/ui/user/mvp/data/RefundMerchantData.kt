package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundMerchantBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RefundMerchantBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class RefundMerchantData(val refundmerchant: RefundMerchant) : BaseData<RefundMerchantBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getRefundMerchant(body: RefundMerchantBody) {
        api(Api.getApi().getRefundMerchant(body)).build()
    }

    override fun onSucceedRequest(data: RefundMerchantBean, what: Int) {
        refundmerchant.getRefundMerchantRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        refundmerchant.getRefundMerchantError()
    }

    interface RefundMerchant {
        fun getRefundMerchantRequest(data: RefundMerchantBean)
        fun getRefundMerchantError()
    }
}