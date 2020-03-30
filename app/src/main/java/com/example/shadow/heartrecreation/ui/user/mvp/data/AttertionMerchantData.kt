package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.AttertionMerchantBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.AttertionMerchantBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class AttertionMerchantData(val attertionmerchant: AttertionMerchant) : BaseData<AttertionMerchantBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getAttertionMerchant(body: AttertionMerchantBody) {
        api(Api.getApi().getAttertionMerchant(body)).build()
    }

    override fun onSucceedRequest(data: AttertionMerchantBean, what: Int) {
        attertionmerchant.getAttertionMerchantRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        attertionmerchant.getAttertionMerchantError()
    }

    interface AttertionMerchant {
        fun getAttertionMerchantRequest(data: AttertionMerchantBean)
        fun getAttertionMerchantError()
    }
}