package com.example.shadow.heartrecreation.ui.order.dialog

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseAppActivity
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.ui.order.adapter.EvaluateClick
import com.example.shadow.heartrecreation.ui.order.adapter.EvaluateDialogAdapter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.EvaluateModel
import com.example.shadow.heartrecreation.ui.order.mvp.bean.EvaluateTagModel
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.dialog_evaluate.*

class EvaluateDialog : BaseDialogFragment(), EvaluateClick {

    override fun setOnItemClickListerOne(get: EvaluateTagModel) {
        if (tagList.contains(get.tagName)) {
            tagList.remove(get.tagName)
        } else {
            if (tagList.size >= 5) {
                Toast.Tips("最多只能选择5个标签")
            } else tagList.add(get.tagName)
        }
        LogUtils.a("当前数据" + Gson().toJson(dataInfo))
        evaluateOne.setList(tagList)
    }

    var dataInfo = ArrayList<EvaluateModel>()
    lateinit var mContext: Context

    fun setData(map: ArrayList<EvaluateModel>, mContext: BaseAppActivity) {
        this.dataInfo = map
        this.mContext = mContext
    }

    override fun setLayoutID(): Int = R.layout.dialog_evaluate
    lateinit var eAdapter: EvaluateDialogAdapter
    override fun isFullScreen(): Boolean = true
    var tagList = ArrayList<String>()
    override fun setLayoutData() {
        var data = ArrayList<String>()
        evaluateOne.setList(data)
        eAdapter = EvaluateDialogAdapter(dataInfo, tagList, this)
        var manager = LinearLayoutManager(mContext)
        evaluateList.layoutManager = manager
        evaluateList.adapter = eAdapter


    }

    override fun clickListener() {
        Click.viewClick(evaluateOver).subscribe { dismiss() }
        Click.viewClick(evaluateOverTwo).subscribe { dismiss() }
    }


}