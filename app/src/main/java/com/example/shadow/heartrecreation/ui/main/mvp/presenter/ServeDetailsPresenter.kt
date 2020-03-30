package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.FansChangeBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeDetailsBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.FansChangeBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.ReportBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.ServeDetailsBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.FansChangeData
import com.example.shadow.heartrecreation.ui.main.mvp.data.ReportData
import com.example.shadow.heartrecreation.ui.main.mvp.data.ServeDetailsData
import com.example.shadow.heartrecreation.ui.main.mvp.view.ServeDetailsView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ServeDetailsPresenter(owner: LifecycleOwner, val view: ServeDetailsView, val mContext: Context) : BasePresenter(owner, view, mContext), ServeDetailsData.ServeDetails, FansChangeData.FansChange,ReportData.Report {
    override fun getReportRequest(data: FansChangeBean) {
        view.dismissLoading(mContext)
        view.getReportRequest()
    }

    override fun getReportError() {
        view.dismissLoading(mContext)
    }

    //关注成功
    override fun getFansChangeRequest(data: FansChangeBean) {
        view.dismissLoading(mContext)
        view.getFansChangeRequest()
    }

    //关注失败
    override fun getFansChangeError() {
        view.dismissLoading(mContext)
    }

    private val servedetails = ServeDetailsData(this)
    private val fanschange = FansChangeData(this)
    private val report=ReportData(this)

    fun getReport(body: ReportBody){
        view.showLoading(mContext)
        report.getReport(body)
    }

    fun getFansChange(body: FansChangeBody) {
        view.showLoading(mContext)
        fanschange.getFansChange(body)
    }

    fun getServeDetails(body: ServeDetailsBody) {
//        view.showLoading(mContext)
        servedetails.getServeDetails(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        servedetails.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    override fun getServeDetailsRequest(data: ServeDetailsBean) {
//        view.dismissLoading(mContext)
        view.getServeDetailsRequest(data)
    }

    override fun getServeDetailsError() {
//        view.dismissLoading(mContext)
        view.getServeDetailsError()
    }
}