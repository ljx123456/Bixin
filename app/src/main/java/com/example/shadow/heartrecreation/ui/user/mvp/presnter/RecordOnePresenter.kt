package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.StorageRecordBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.StorageRecordBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.StorageRecordData
import com.example.shadow.heartrecreation.ui.user.mvp.view.RecordOneView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class RecordOnePresenter(owner: LifecycleOwner, val view: RecordOneView, val mContext: Context) : BasePresenter(owner, view, mContext), StorageRecordData.StorageRecord {
    override fun getStorageRecordRequest(data: StorageRecordBean) {
        view.getStorageRecordRequest(data)
    }

    override fun getStorageRecordError() {
        view.getStorageRecordError()
    }

    private val storagerecord = StorageRecordData(this)

    fun getStorageRecord(body: StorageRecordBody) {
        storagerecord.getStorageRecord(body)
    }

    fun getTakeRecord(body: StorageRecordBody) {
        storagerecord.getTakeRecord(body)
    }


    override fun addDisposableList(list: ArrayList<Disposable>) {

    }

    override fun presenterDestroy() {

    }
}