package com.example.shadow.heartrecreation.ui.order.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ComplaintDetailsBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.ComplaintDetailsBody
import com.example.shadow.heartrecreation.ui.order.mvp.data.ComplaintDetailsData
import com.example.shadow.heartrecreation.ui.order.mvp.view.ComplaintDetailsView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ComplaintDetailsPresenter(owner: LifecycleOwner, val view: ComplaintDetailsView, val mContext: Context) : BasePresenter(owner, view, mContext), ComplaintDetailsData.ComplaintDetails{

    private val complaint=ComplaintDetailsData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        complaint.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    override fun getComplaintDetailsRequest(data: ComplaintDetailsBean) {
        view.dismissLoading(mContext)
        view.getComplaintDetailsRequest(data)
    }

    override fun getComplaintDetailsError() {
       view.dismissLoading(mContext)
    }

    fun getComplaintDetails(body:ComplaintDetailsBody){
        view.showLoading(mContext)
        complaint.getComplaintDetails(body)
    }
}