package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.AttertionMerchantBean

interface AttertionMerchantView : BaseView {
    fun getAttertionMerchantRequest(data: AttertionMerchantBean)
    fun getAttertionMerchantError()
}