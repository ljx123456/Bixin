package com.example.shadow.heartrecreation.ui.order.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ComplaintDetailsBean


interface ComplaintDetailsView:BaseView{
    fun getComplaintDetailsRequest(data:ComplaintDetailsBean)
}