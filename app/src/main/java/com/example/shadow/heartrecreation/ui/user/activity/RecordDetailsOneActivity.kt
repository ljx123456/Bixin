package com.example.shadow.heartrecreation.ui.user.activity

import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.place.intentUtils
import com.example.shadow.heartrecreation.ui.user.adapter.RecordDetailsOneAdapter
import com.example.shadow.heartrecreation.ui.user.adapter.RecordDetailsTwoAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RecordDetailsOneBean
import com.example.shadow.heartrecreation.ui.user.mvp.bean.RecordInfoBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.RecordDetailsOneBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.RecordDetailsOneViewPresnter
import com.example.shadow.heartrecreation.ui.user.mvp.view.RecordDetailsOneView
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.activity_record_details_one.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_title.*

class RecordDetailsOneActivity : BaseActivity(), RecordDetailsOneView {
    //取酒记录详情
    override fun getRecordInfoRequest(data: RecordInfoBean) {
        dismissLoading()
        content.visibility=View.VISIBLE
        errorLayout.visibility=View.GONE
        if (data.data.businessInfo != null) {
            detailsName.text = data.data.businessInfo.businessName
            detailsAdds.text = "商家地址："+data.data.businessInfo.businessAddress
            detailsTime.text = data.data.createTime
            Click.viewClick(detailsAdds).subscribe { intentUtils.intentPlace("", data.data.businessInfo.longitude, data.data.businessInfo.latitude, data.data.businessInfo.latitude, data.data.businessInfo.longitude, data.data.businessInfo.avatar) }
        }
        if (data.data.wineInfo != null) {
            var oneAdapter = RecordDetailsTwoAdapter(data.data.wineInfo)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            detailsList.layoutManager = manager
            detailsList.adapter = oneAdapter
        }
    }

    //取酒记录详情
    override fun getRecordInfoError() {
        try {
            var h= Handler()
            h.postDelayed(object :Runnable{
                override fun run() {
                    dismissLoading()
//                    Log.e("点击","dismiss了")
                    h.removeCallbacksAndMessages(null)
                }

            },1000)
        }catch (e:Exception){
            e.printStackTrace()
        }
        content.visibility=View.GONE
        errorLayout.visibility=View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            showLoading()
            presenter.getRecordInfo(RecordDetailsOneBody(id))
        }


    }

    //存酒记录详情
    override fun getRecordDetailsOneRequest(data: RecordDetailsOneBean) {
        dismissLoading()
        content.visibility=View.VISIBLE
        errorLayout.visibility=View.GONE
        if (data.data.businessInfo != null) {
            detailsName.text = data.data.businessInfo.businessName
            detailsAdds.text = "商家地址："+data.data.businessInfo.businessAddress
            detailsTime.text = data.data.createTime
            Click.viewClick(detailsAdds).subscribe { intentUtils.intentPlace("", data.data.businessInfo.longitude, data.data.businessInfo.latitude, data.data.businessInfo.latitude, data.data.businessInfo.longitude, data.data.businessInfo.avatar) }
        }
        if (data.data.wineInfo != null) {
            var oneAdapter = RecordDetailsOneAdapter(data.data.wineInfo)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            detailsList.layoutManager = manager
            detailsList.adapter = oneAdapter
        }
    }

    //存酒记录详情
    override fun getRecordDetailsOneError() {
        try {
            var h= Handler()
            h.postDelayed(object :Runnable{
                override fun run() {
                    dismissLoading()
//                    Log.e("点击","dismiss了")
                    h.removeCallbacksAndMessages(null)
                }

            },1000)
        }catch (e:Exception){
            e.printStackTrace()
        }
        content.visibility=View.GONE
        errorLayout.visibility=View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            showLoading()
            presenter.getRecordDetailsOne(RecordDetailsOneBody(id))
        }
    }

    override fun openEventBus(): Boolean = false
    private var id = 0
    private var type = 0
    override fun getActivityLayout(): Int = R.layout.activity_record_details_one
    private val presenter by lazy { RecordDetailsOneViewPresnter(this, this,  this) }

    override fun setActivityTitle() {
        id = intent.getIntExtra("id", 0)
        type = intent.getIntExtra("type", 0)
        titleText.text = "记录详情"
        when (type) {
            1 -> presenter.getRecordDetailsOne(RecordDetailsOneBody(id))
            2 -> presenter.getRecordInfo(RecordDetailsOneBody(id))
        }
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
    }

    override fun initActivityData() {

    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }

    }
}