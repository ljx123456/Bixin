package com.example.shadow.heartrecreation.ui.main.mvp.data

import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListSearchBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.ServeListSearchBody
import com.example.shadow.heartrecreation.utils.http.Api
import com.example.shadow.heartrecreation.utils.http.BaseData
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.http.SaveInfo
import com.example.shadow.heartrecreation.utils.utils.Toast

class ServeListSearchData(val servelistsearch: ServeListSearch) : BaseData<ServeListSearchBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    fun getServeListSearch(body: ServeListSearchBody) {
        api(Api.getApi().getServeListSearch(body)).build()
    }

    override fun onSucceedRequest(data: ServeListSearchBean, what: Int) {
        servelistsearch.getServeListSearchRequest(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int,drinks: ErrorDrinks?) {
        if (NetworkUtils.isConnected()) {
            Toast.Tips(msg)
        }
        servelistsearch.getServeListSearchError()
    }

    interface ServeListSearch {
        fun getServeListSearchRequest(data: ServeListSearchBean)
        fun getServeListSearchError()
    }
}