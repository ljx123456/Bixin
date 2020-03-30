package com.example.shadow.heartrecreation.ui.meassage.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.FeedBackDetailsBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.FeedBackDetailsBody
import com.example.shadow.heartrecreation.ui.meassage.mvp.data.FeedBackDetailsData
import com.example.shadow.heartrecreation.ui.meassage.mvp.view.FeedBackDetailsView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class FeedBackDetailsPresenter(owner: LifecycleOwner, val view: FeedBackDetailsView, val mContext: Context) : BasePresenter(owner, view, mContext), FeedBackDetailsData.FeedBackDetails{

    private val details=FeedBackDetailsData(this)
    override fun addDisposableList(list: ArrayList<Disposable>) {
        details.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getFeedBackDetails(body: FeedBackDetailsBody){
        details.getFeedBackDetails(body)
    }

    override fun getFeedBackDetailsRequest(data: FeedBackDetailsBean) {
        view.getFeedBackDetailsRequest(data)
    }

    override fun getFeedBackDetailsError() {
        view.getFeedBackDetailsError()
    }
}