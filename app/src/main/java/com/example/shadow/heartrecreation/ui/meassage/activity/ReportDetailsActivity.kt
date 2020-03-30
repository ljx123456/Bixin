package com.example.shadow.heartrecreation.ui.meassage.activity

import android.os.Handler
import android.view.View
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.ReportDetailsBean
import com.example.shadow.heartrecreation.ui.meassage.mvp.body.ReportDetailsBody
import com.example.shadow.heartrecreation.ui.meassage.mvp.presenter.ReportDetailsPresenter
import com.example.shadow.heartrecreation.ui.meassage.mvp.view.ReportDetailsView
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.activity_report_details.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_title.*

class ReportDetailsActivity:BaseActivity(),ReportDetailsView{

    private val presenter by lazy { ReportDetailsPresenter(this,this,this) }
    private var id=""

    override fun openEventBus(): Boolean =false

    override fun getActivityLayout(): Int =R.layout.activity_report_details

    override fun setActivityTitle() {
        titleText.text="处理结果"
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
    }

    override fun initActivityData() {
        if (intent.getStringExtra("id")!=null&&intent.getStringExtra("id")!=""){
            id=intent.getStringExtra("id")
            presenter.getReportDetails(ReportDetailsBody(id))
            showLoading()
        }
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }

    override fun getReportDetailsRequest(data: ReportDetailsBean) {
        dismissLoading()
        layout_content.visibility=View.VISIBLE
        errorLayout.visibility=View.GONE
        tv_nickName.text=data.data.serviceUserName
        tv_details.text=data.data.reportContent
        tv_time.text=data.data.updateTime
        tv_result.text=data.data.handleRes
    }

    override fun getReportDetailsError() {
        try {
            var h= Handler()
            h.postDelayed(object :Runnable{
                override fun run() {
                    dismissLoading()
                    layout_content.visibility=View.GONE
                    errorLayout.visibility=View.VISIBLE
//                    Log.e("点击","dismiss了")
                    h.removeCallbacksAndMessages(null)
                }

            },1000)
        }catch (e:Exception){
            e.printStackTrace()
        }
        Click.viewClick(anewClick).subscribe {
            showLoading()
            presenter.getReportDetails(ReportDetailsBody(id))
        }


    }

}