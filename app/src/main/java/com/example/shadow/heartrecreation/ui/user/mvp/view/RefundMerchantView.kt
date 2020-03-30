package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RefundMerchantBean

interface RefundMerchantView:BaseView {
    fun getRefundMerchantRequest(data: RefundMerchantBean)
    fun getRefundMerchantError()
}