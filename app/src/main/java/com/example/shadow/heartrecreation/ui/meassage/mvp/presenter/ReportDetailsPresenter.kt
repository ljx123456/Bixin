package com.example.shadow.heartrecreation.ui.meassage.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.ReportDetailsBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.ReportDetailsBody
import com.example.shadow.heartrecreation.ui.meassage.mvp.data.ReportDetailsData
import com.example.shadow.heartrecreation.ui.meassage.mvp.view.ReportDetailsView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ReportDetailsPresenter(owner: LifecycleOwner, val view: ReportDetailsView, val mContext: Context) : BasePresenter(owner, view, mContext), ReportDetailsData.ReportDetails{

    private val details=ReportDetailsData(this)
    override fun addDisposableList(list: ArrayList<Disposable>) {
        details.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    fun getReportDetails(body:ReportDetailsBody){
        details.getReportDetails(body)
    }

    override fun getReportDetailsRequest(data: ReportDetailsBean) {
        view.getReportDetailsRequest(data)
    }

    override fun getReportDetailsError() {
        view.getReportDetailsError()
    }
}