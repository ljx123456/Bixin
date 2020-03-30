package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantListSearchBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.MerchantListSearchBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class MerchantListSearchData(val merchantlistsearch: MerchantListSearch) : BaseData<MerchantListSearchBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getMerchantListSearch(body: MerchantListSearchBody) {
        api(Api.getApi().getMerchantListSearch(body)).build()
    }

    override fun onSucceedRequest(data: MerchantListSearchBean, what: Int) {
        merchantlistsearch.getMerchantListSearchRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        merchantlistsearch.getMerchantListSearchError()
    }

    interface MerchantListSearch {
        fun getMerchantListSearchRequest(data: MerchantListSearchBean)
        fun getMerchantListSearchError()
    }
}