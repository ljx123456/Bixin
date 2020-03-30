package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CouponsBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.CouponsBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class CouponsData(val coupons: Coupons) : BaseData<CouponsBean>() {

    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getCoupons(body: CouponsBody) {
        api(Api.getApi().getCoupons(body)).build()
    }

    override fun onSucceedRequest(data: CouponsBean, what: Int) {
        coupons.getCouponsRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        coupons.getCouponsError()
    }

    interface Coupons {
        fun getCouponsRequest(data: CouponsBean)
        fun getCouponsError()
    }
}