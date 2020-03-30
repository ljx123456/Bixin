package com.example.shadow.heartrecreation.ui.order.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ComplaintBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ReasonBean

interface ComplaintView :BaseView{
    fun getReasonRequest(data:ReasonBean)

    fun getComplaintRequest(data:ComplaintBean)
    fun getComplaintError()
}