package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.DrinkDetailsBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.DrinkDetailsBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class DrinkDetailsData(val drinkdetails: DrinkDetails) : BaseData<DrinkDetailsBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getDrinkDetails(body: DrinkDetailsBody) {
        api(Api.getApi().getDrinkDetails(body)).build()
    }

    override fun onSucceedRequest(data: DrinkDetailsBean, what: Int) {
        drinkdetails.getDrinkDetailsRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        drinkdetails.getDrinkDetailsError()
    }

    interface DrinkDetails {
        fun getDrinkDetailsRequest(data: DrinkDetailsBean)
        fun getDrinkDetailsError()
    }
}