package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.StorageRecordBean

interface RecordOneView : BaseView {
    fun getStorageRecordRequest(data: StorageRecordBean)
    fun getStorageRecordError()
}