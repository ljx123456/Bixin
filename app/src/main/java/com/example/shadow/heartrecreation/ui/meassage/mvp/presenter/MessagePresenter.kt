package com.example.shadow.heartrecreation.ui.meassage.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.ClearNotificationBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.data.ClearNotificationData
import com.example.shadow.heartrecreation.ui.meassage.mvp.view.MessageView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class MessagePresenter(owner: LifecycleOwner, val view: MessageView, val mContext: Context) : BasePresenter(owner, view, mContext),ClearNotificationData.ClearNotification{

    private val clear=ClearNotificationData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        clear.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    override fun getClearNotificationRequest(data: ClearNotificationBean) {
        view.dismissLoading(mContext)
        view.getClearNotificationRequest()
    }

    override fun getClearNotificationError() {
        view.dismissLoading(mContext)
        view.getClearNotificationError()
    }

    fun clearNotification(){
        view.showLoading(mContext)
        clear.getClearNotification()
    }
}