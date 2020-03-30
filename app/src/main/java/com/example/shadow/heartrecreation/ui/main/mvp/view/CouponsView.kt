package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CouponUserAddBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CouponsBean

interface CouponsView:BaseView {
    fun getCouponsRequest(data: CouponsBean)
    fun getCouponsError()
    fun getCouponUserAddRequest(data: CouponUserAddBean)
    fun getCouponUserAddError()
}