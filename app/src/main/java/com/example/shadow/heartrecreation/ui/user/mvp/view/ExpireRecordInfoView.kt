package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.ExpireRecordInfoBean

interface ExpireRecordInfoView:BaseView {
    fun getExpireRecordInfoRequest(data: ExpireRecordInfoBean)
    fun getExpireRecordInfoError()
}