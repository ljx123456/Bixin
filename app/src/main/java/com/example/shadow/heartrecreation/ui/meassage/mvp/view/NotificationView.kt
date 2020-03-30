package com.example.shadow.heartrecreation.ui.meassage.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.NotificationBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.ReadNotificationBean

interface NotificationView:BaseView {
    fun getNotificationRequest(data: NotificationBean)
    fun getNotificationError()

    fun getReadRequest(data: ReadNotificationBean)
}