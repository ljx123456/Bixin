package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantBean

interface MerchantView : BaseView {
    fun getMerchantRequest(data: MerchantBean)
    fun getMerchantError()
}