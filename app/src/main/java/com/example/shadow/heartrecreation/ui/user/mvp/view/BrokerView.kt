package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BrokerBean

interface BrokerView : BaseView {
    fun getBrokerRequest(data: BrokerBean)
    fun getBrokerError()
}