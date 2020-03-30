package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.ExpireRecordBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.ExpireRecordBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.ExpireRecordData
import com.example.shadow.heartrecreation.ui.user.mvp.view.ExpireRecordView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ExpireRecordPresenter(owner: LifecycleOwner, val view: ExpireRecordView, val mContext: Context) : BasePresenter(owner, view, mContext), ExpireRecordData.ExpireRecord {
    override fun getExpireRecordRequest(data: ExpireRecordBean) {
        view.getExpireRecordRequest(data)
    }

    override fun getExpireRecordError() {
        view.getExpireRecordError()
    }

    private val expirerecord = ExpireRecordData(this)

    fun getExpireRecord(body: ExpireRecordBody) {
        expirerecord.getExpireRecord(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        expirerecord.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}