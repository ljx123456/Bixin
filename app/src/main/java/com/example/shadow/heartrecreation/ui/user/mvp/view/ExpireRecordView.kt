package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.ExpireRecordBean

interface ExpireRecordView:BaseView {
    fun getExpireRecordRequest(data: ExpireRecordBean)
    fun getExpireRecordError()
}