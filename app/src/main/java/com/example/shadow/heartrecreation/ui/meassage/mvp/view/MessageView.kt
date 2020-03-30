package com.example.shadow.heartrecreation.ui.meassage.mvp.view

import com.example.shadow.heartrecreation.base.BaseView

interface MessageView:BaseView{
    fun getClearNotificationRequest()
    fun getClearNotificationError()
}