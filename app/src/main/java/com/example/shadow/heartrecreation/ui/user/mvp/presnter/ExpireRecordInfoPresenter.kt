package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.ExpireRecordInfoBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.ExpireRecordInfoBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.ExpireRecordInfoData
import com.example.shadow.heartrecreation.ui.user.mvp.view.ExpireRecordInfoView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ExpireRecordInfoPresenter(owner: LifecycleOwner, val view: ExpireRecordInfoView, val mContext: Context) : BasePresenter(owner, view, mContext), ExpireRecordInfoData.ExpireRecordInfo {
    override fun getExpireRecordInfoRequest(data: ExpireRecordInfoBean) {
        view.dismissLoading(mContext)
        view.getExpireRecordInfoRequest(data)
    }

    override fun getExpireRecordInfoError() {
        view.dismissLoading(mContext)
        view.getExpireRecordInfoError()
    }

    private val expirerecordinfo = ExpireRecordInfoData(this)


    fun getExpireRecordInfo(body: ExpireRecordInfoBody) {
        view.showLoading(mContext)
        expirerecordinfo.getExpireRecordInfo(body)
    }


    override fun addDisposableList(list: ArrayList<Disposable>) {
        expirerecordinfo.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}