package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.TakeRecordListBean

interface DrinksRecordView:BaseView {
    fun getTakeRecordListRequest(data: TakeRecordListBean)
    fun DrinksRecordError()
}