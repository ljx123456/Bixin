package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CityListBean
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class CityListData(val cityList: CityList) : BaseData<CityListBean>() {

    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getCityList() {
        api(Api.getApi().getCityList()).build()
    }

    override fun onSucceedRequest(data: CityListBean, what: Int) {
        cityList.getCityListRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        cityList.getCityListError()
    }

    interface CityList {
        fun getCityListRequest(data: CityListBean)
        fun getCityListError()
    }
}