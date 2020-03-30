package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantDetailsBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.MerchantDetailsBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class MerchantDetailsData(val merchantdetails: MerchantDetails) : BaseData<MerchantDetailsBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getMerchantDetails(body: MerchantDetailsBody) {
        api(Api.getApi().getMerchantDetails(body)).build()
    }

    override fun onSucceedRequest(data: MerchantDetailsBean, what: Int) {
        merchantdetails.getMerchantDetailsRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        merchantdetails.getMerchantDetailsError()
    }

    interface MerchantDetails {
        fun getMerchantDetailsRequest(data: MerchantDetailsBean)
        fun getMerchantDetailsError()
    }
}