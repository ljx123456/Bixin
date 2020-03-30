package com.example.shadow.heartrecreation.ui.order.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.MoreInviteBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.MoreInviteBody
import com.example.shadow.heartrecreation.ui.order.mvp.data.MoreInviteData
import com.example.shadow.heartrecreation.ui.order.mvp.view.MoreInviteView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class MoreInvitePresenter(owner: LifecycleOwner, val view: MoreInviteView, val mContext: Context) : BasePresenter(owner, view, mContext), MoreInviteData.MoreInvite {

    override fun getMoreInviteRequest(data: MoreInviteBean) {
        view.dismissLoading(mContext)
        view.getMoreInviteRequest(data)
    }

    override fun getMoreInviteError() {
        view.dismissLoading(mContext)
    }

    private val moreinvite = MoreInviteData(this)
    fun getMoreInvite(body: MoreInviteBody) {
        view.showLoading(mContext)
        moreinvite.getMoreInvite(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {

    }

    override fun presenterDestroy() {

    }
}