package com.example.shadow.heartrecreation.ui.order.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ComplaintBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ReasonBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.ComplaintBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.ReasonBody
import com.example.shadow.heartrecreation.ui.order.mvp.data.ComplaintData
import com.example.shadow.heartrecreation.ui.order.mvp.data.ReasonData
import com.example.shadow.heartrecreation.ui.order.mvp.view.ComplaintView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ComplaintPresenter(owner: LifecycleOwner, val view: ComplaintView, val mContext: Context) : BasePresenter(owner, view, mContext),ReasonData.Reason,ComplaintData.Complaint{
    override fun getComplaintRequest(data: ComplaintBean) {
        view.dismissLoading(mContext)
        view.getComplaintRequest(data)
    }

    override fun getComplaintError() {
        view.dismissLoading(mContext)
        view.getComplaintError()
    }

    private val reason=ReasonData(this)
    private val complaint=ComplaintData(this)

    override fun addDisposableList(list: ArrayList<Disposable>) {
        reason.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    override fun getReasonRequest(data: ReasonBean) {
        view.dismissLoading(mContext)
        view.getReasonRequest(data)
    }

    override fun getReasonError() {
        view.dismissLoading(mContext)
    }

    fun getReason(body:ReasonBody){
        view.showLoading(mContext)
        reason.getReason(body)
    }

    fun getComplaint(body:ComplaintBody){
        view.showLoading(mContext)
        complaint.getComplaint(body)
    }
}