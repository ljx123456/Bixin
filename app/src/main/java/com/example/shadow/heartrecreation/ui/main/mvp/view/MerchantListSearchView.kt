package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantListSearchBean

interface MerchantListSearchView : BaseView {
    fun getMerchantListSearchRequest(data: MerchantListSearchBean)
    fun getMerchantListSearchError()
}