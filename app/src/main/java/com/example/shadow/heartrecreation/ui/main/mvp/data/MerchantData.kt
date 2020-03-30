package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.MerchantBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class MerchantData(val merchant: Merchant) : BaseData<MerchantBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getMerchant(body: MerchantBody) {
        api(Api.getApi().getMerchant(body)).build()
    }

    override fun onSucceedRequest(data: MerchantBean, what: Int) {
        merchant.getMerchantRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        merchant.getMerchantError()
    }

    interface Merchant {
        fun getMerchantRequest(data: MerchantBean)
        fun getMerchantError()
    }
}