package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RecordDetailsOneBean
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RecordInfoBean

interface RecordDetailsOneView : BaseView {
    fun getRecordDetailsOneRequest(data: RecordDetailsOneBean)
    fun getRecordDetailsOneError()
    fun getRecordInfoRequest(data: RecordInfoBean)
    fun getRecordInfoError()
}