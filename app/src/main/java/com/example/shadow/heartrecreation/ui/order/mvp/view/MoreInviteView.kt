package com.example.shadow.heartrecreation.ui.order.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.order.mvp.bean.MoreInviteBean

interface MoreInviteView : BaseView {
    fun getMoreInviteRequest(data: MoreInviteBean)
}