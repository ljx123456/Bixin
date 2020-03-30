package com.example.shadow.heartrecreation.ui.login.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.CheckNameBean


interface RegDataView : BaseView {
    fun setRgeDataRequest(data: ByCodeBean)
    fun setCheckNameRequest(data: CheckNameBean)
}