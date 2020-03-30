package com.example.shadow.heartrecreation.ui.meassage.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.FeedBackDetailsBean

interface FeedBackDetailsView:BaseView{
    fun getFeedBackDetailsRequest(data: FeedBackDetailsBean)
    fun getFeedBackDetailsError()
}