package com.example.shadow.heartrecreation.ui.main.dialog

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.OrderServeUtils
import com.example.shadow.heartrecreation.db.ServeUtils
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.ui.main.activity.ServeListActivity
import com.example.shadow.heartrecreation.ui.main.adapter.YueServeAdapter
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.utils.GlideCacheUtil
import com.google.gson.Gson
import kotlinx.android.synthetic.main.dialog_serve_list.*

@SuppressLint("ValidFragment")
class ServeListDialog(val servelist: ServeList) : BaseDialogFragment(), NumDialog.PeoPleNum {

    override fun setPeoPleNum(get: String) {
//        serveSize.text = "约玩人数:${user.getNum().toInt()}人"
//        dasngqianshuju.text = "已邀请${user.getNum().toInt()}人，还可邀请${user.getNum().toInt()}人"
    }

    override fun setLayoutID(): Int = R.layout.dialog_serve_list
    private val numDialog = NumDialog(this)
    override fun isFullScreen(): Boolean = true

    override fun setLayoutData() {
        haveServe()
//        serveSize.text = "约玩人数:${user.getNum().toInt()}人"
//        dasngqianshuju.text = "已邀请${user.getNum().toInt()}人，还可邀请${user.getNum().toInt()}人"
    }

    override fun clickListener() {
        Click.viewClick(serveOver).subscribe { dismiss() }
        Click.viewClick(serveListOver).subscribe {

            ShowDialog.showCustomDialogs(activity, "是否清空已选达人信息", "清空", "取消", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
//                            ServeUtils.getServeData().forEach {
//                                OrderServeUtils.
//                            }
                            ServeUtils.deleteALLServe()//删除所有服务人员
                            haveServe()
                            dialog.dismiss()
                        }
                        DialogInterface.BUTTON_NEGATIVE -> {
                            dialog.dismiss()
                        }
                    }
                }
            })


        }
        Click.viewClick(detailsYue).subscribe {
            servelist.setServeGoYue()
        }
        Click.viewClick(serveSetNum).subscribe {
            if (numDialog.isAdded){
                numDialog.dismiss()
            }else {
                numDialog.show(activity!!.supportFragmentManager, "")
            }
        }
    }

    //有服务人员
    fun haveServe() {
        var serveData = ServeUtils.getServeData()
        if (serveData != null && serveData.size >= 1 && serveData.get(0).image != null) {
            serveList.visibility = View.VISIBLE
            var adapters = YueServeAdapter(0,serveData)
            var merager = LinearLayoutManager(getContext())
            merager.orientation = LinearLayout.VERTICAL
            serveList.layoutManager = merager
            serveList.adapter = adapters
            LogUtils.a("已选" + Gson().toJson(serveData))
//            serveNum.setText("已选(${serveData.size})人")
            servelistNum.setText("${serveData.size}")
//            dasngqianshuju.text = "已邀请${serveData.size}人，还可邀请${user.getNum().toInt() - serveData.size}人"
            dasngqianshuju.text = "已邀请${serveData.size}人"
            adapters.setOnItemChildClickListener { adapter, view, position ->
                when (view.id) {
                    R.id.yueServeDell -> {
                        ServeUtils.deleteServe(adapters.data.get(position).id)
                        adapters.remove(position)
                        serveNum.setText("已选(${adapters.data.size})人")
//                        dasngqianshuju.text = "已邀请${adapters.data.size}人，还可邀请${user.getNum().toInt() - serveData.size}人"
                        dasngqianshuju.text = "已邀请${adapters.data.size}人"
                        servelistNum.text="${adapters.data.size}"
                    }
                }
            }
        } else {
            serveList.visibility = View.GONE
//            serveNum.setText("已选(0)人")
//            dasngqianshuju.text = "已邀请0人，还可邀请${user.getNum().toInt()}人"
            dasngqianshuju.text = "已邀请0人"
            servelistNum.text="0"
        }
    }

    interface ServeList {
        fun setServeGoYue()
        fun setServeOver()
    }

    override fun onDismiss(dialog: DialogInterface?) {
//        if (activity!! as ServeListActivity)
//        (activity!! as ServeListActivity).haveServe()
        servelist.setServeOver()
        super.onDismiss(dialog)
    }

    override fun onDestroy() {
        super.onDestroy()
        GlideCacheUtil.getInstance().clearImageAllCache(activity!!)//清除图片所有缓存
    }
}