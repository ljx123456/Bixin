package com.example.shadow.heartrecreation.ui.user.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BusinessBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.BusinessBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class BusinessData(val business: Business) : BaseData<BusinessBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getBusiness(body: BusinessBody) {
        api(Api.getApi().getBusiness(body)).build()
    }


    override fun onSucceedRequest(data: BusinessBean, what: Int) {
        business.getBusinessRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        business.getBusinessError()
    }

    interface Business {
        fun getBusinessRequest(data: BusinessBean)
        fun getBusinessError()
    }
}