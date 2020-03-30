package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.body.FeedbackAddBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.FeedbackAddData
import com.example.shadow.heartrecreation.ui.user.mvp.view.FeedbackAddView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class FeedbackAddPresenter(owner: LifecycleOwner, val view: FeedbackAddView, val mContext: Context) : BasePresenter(owner, view, mContext), FeedbackAddData.FeedbackAdd {
    override fun getFeedbackAddRequest() {
        view.dismissLoading(mContext)
        view.getFeedbackAddRequest()
    }

    override fun getFeedbackAddError() {
        view.dismissLoading(mContext)
    }

    private val feedbackadd = FeedbackAddData(this)
    fun getFeedbackAdd(body: FeedbackAddBody) {
        view.showLoading(mContext)
        feedbackadd.getFeedbackAdd(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        feedbackadd.getDisposable()?.let { it }
    }

    override fun presenterDestroy() {

    }
}