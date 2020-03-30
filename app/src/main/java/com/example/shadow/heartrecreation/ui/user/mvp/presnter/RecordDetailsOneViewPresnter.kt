package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RecordDetailsOneBean
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RecordInfoBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RecordDetailsOneBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.RecordDetailsOneData
import com.example.shadow.heartrecreation.ui.user.mvp.data.RecordInfoData
import com.example.shadow.heartrecreation.ui.user.mvp.view.RecordDetailsOneView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class RecordDetailsOneViewPresnter(owner: LifecycleOwner, val view: RecordDetailsOneView, val mContext: Context) : BasePresenter(owner, view, mContext), RecordDetailsOneData.RecordDetailsOne, RecordInfoData.RecordInfo {
    override fun getRecordInfoRequest(data: RecordInfoBean) {
        view.dismissLoading(mContext)
        view.getRecordInfoRequest(data)
    }

    override fun getRecordInfoError() {
        view.dismissLoading(mContext)
        view.getRecordInfoError()
    }

    override fun getRecordDetailsOneRequest(data: RecordDetailsOneBean) {
        view.dismissLoading(mContext)
        view.getRecordDetailsOneRequest(data)
    }

    override fun getRecordDetailsOneError() {
        view.dismissLoading(mContext)
        view.getRecordDetailsOneError()
    }

    fun getRecordDetailsOne(body: RecordDetailsOneBody) {
        view.showLoading(mContext)
        recorddetailsone.getRecordDetailsOne(body)
    }

    fun getRecordInfo(recordDetailsOneBody: RecordDetailsOneBody) {
        view.showLoading(mContext)
        recordinfo.getRecordInfo(recordDetailsOneBody)
    }

    private val recordinfo = RecordInfoData(this)
    private val recorddetailsone = RecordDetailsOneData(this)
    override fun addDisposableList(list: ArrayList<Disposable>) {
        recordinfo.getDisposable()?.let { list.add(it) }
        recorddetailsone.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }


}