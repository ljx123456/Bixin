package com.example.shadow.heartrecreation.ui.order.activity

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.order.adapter.EvaluateAdapter
import com.example.shadow.heartrecreation.ui.order.dialog.EvaluateDialog
import com.example.shadow.heartrecreation.ui.order.mvp.bean.EvaluateModel
import com.example.shadow.heartrecreation.ui.order.mvp.bean.EvaluateOrderBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.EvaluateTagModel
import com.example.shadow.heartrecreation.ui.order.mvp.body.EvaluateOrderBody
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.EvaluateOrderPresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.EvaluateOrderView
import com.example.shadow.heartrecreation.utils.utils.Click
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_evaluate.*
import kotlinx.android.synthetic.main.layout_title.*

class EvaluateActivity : BaseActivity(), EvaluateOrderView {
    var dialog = EvaluateDialog()
    val dataInfo = ArrayList<EvaluateModel>()
    override fun getEvaluateOrderRequest(data: EvaluateOrderBean) {

        var evaluateadapter = EvaluateAdapter(data.data.serviceUsers)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.VERTICAL
        evaluateList.layoutManager = manager
        evaluateList.adapter = evaluateadapter

        var mapList = ArrayList<EvaluateOrderBean.DataBean.ServiceTagsBean>()
        var info = data.data.serviceTags
        for (model in info) {
            if (model.parentId == -1) {
                mapList.add(model)
            }
        }
        for (datas in mapList) {
            var stringList = ArrayList<EvaluateTagModel>()
            for (list in info) {
                if (datas.tagId == list.parentId) {
                    var tag = EvaluateTagModel(list.tagId, list.tagName, false)
                    stringList.add(tag)
                }
            }
            dataInfo.add(EvaluateModel(datas.tagName, stringList))
        }

        LogUtils.a("数据" + Gson().toJson(dataInfo))



        evaluateadapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.evaluateTag -> {
                    dialog.setData(dataInfo, mContext)
                    dialog.show(supportFragmentManager, "")
                }
            }
        }
    }

    override fun getEvaluateOrderError() {

    }

    override fun openEventBus(): Boolean = false
    private var orderNo = ""
    private val presenter by lazy { EvaluateOrderPresenter(this, this, this) }
    override fun getActivityLayout(): Int = R.layout.activity_evaluate

    override fun setActivityTitle() {
        titleText.text = "评价"
        orderNo = intent.getStringExtra("orderNo")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
        presenter.getEvaluateOrder(EvaluateOrderBody(orderNo))
    }

    override fun initActivityData() {

    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }
}