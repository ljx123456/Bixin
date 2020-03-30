package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantDetailsBean

interface MerchantDetailsView:BaseView {
    fun getMerchantDetailsRequest(data: MerchantDetailsBean)
    fun getMerchantDetailsError()
    fun getFollowChange()
}