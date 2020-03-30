package com.example.shadow.heartrecreation.ui.main.dialog

import android.annotation.SuppressLint
import android.util.Log
import cn.qqtheme.framework.widget.WheelView
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.DbUtils.getMerchat
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderShowTimeBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.OrderShowTimeBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.OrderShowTimePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.OrderShowTimeView
import kotlinx.android.synthetic.main.dialog_yue_time.*
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("ValidFragment")
class YueTimeDialog(val yuetime: YueTime) : BaseDialogFragment() {
    private lateinit var orderTime: List<String>
    private var orderTimes=ArrayList<String>()
    fun setData(orderTime: List<String>) {
        this.orderTime = ArrayList<String>()
        this.orderTime = orderTime
        orderTime.forEach {
            orderTimes.add(it.substringAfter(" ").substring(0,5))
        }
    }

    private var time = ""
    private var times=""

    override fun setLayoutID(): Int = R.layout.dialog_yue_time

    override fun isFullScreen(): Boolean = false

    override fun setLayoutData() {
//        wheelviewSingle.setItems(orderTime, 0)
        wheelviewSingle.setItems(orderTimes, 0)
        wheelviewSingle.setTextColor(activity!!.resources.getColor(R.color.gray), activity!!.resources.getColor(R.color.red))
        wheelviewSingle.setTextSize(20f)
        wheelviewSingle.setCycleDisable(true)
        val config = WheelView.DividerConfig()
        config.setRatio(1.0f / 10.0f)//线比率
        config.setVisible(false)
        wheelviewSingle.setDividerConfig(config)
        time = orderTime.get(0)
        tv_title.text=getTime(time)
        times=getTimes(time)
        wheelviewSingle.setOnItemSelectListener { index ->
            time = orderTime.get(index)
            tv_title.text=getTime(time)
            times=getTimes(time)
        }
    }

    override fun clickListener() {
        Click.viewClick(yueTimeOk).subscribe {
            yuetime.setYueTime(time,times)
            dismiss()
        }
    }

    interface YueTime {
        fun setYueTime(time: String,times:String)
    }

    /**
     * 根据当前日期获得是星期几
     * time=yyyy-MM-dd
     * @return
     */
    public fun getWeek(time:String):String {
        var  Week = ""
        var format = SimpleDateFormat("yyyy-MM-dd")
        var c = Calendar.getInstance()
        try {
            c.setTime(format.parse(time))
        } catch (e:Exception) {
            Log.e("测试","异常")
            e.printStackTrace()
        }

        var wek=c.get(Calendar.DAY_OF_WEEK)

        if (wek == 1) {
            Week += "周日"
        }
        if (wek == 2) {
            Week += "周一"
        }
        if (wek == 3) {
            Week += "周二"
        }
        if (wek == 4) {
            Week += "周三"
        }
        if (wek == 5) {
            Week += "周四"
        }
        if (wek == 6) {
            Week += "周五"
        }
        if (wek == 7) {
            Week += "周六"
        }
        return Week
    }

    fun getData(time:String):String{
        var split=time.split("-")
        return split[1]+"月"+split[2]+"日"
    }

    fun getTime(time:String):String{
        var split=time.split(" ")

        return getData(split[0])+"（"+getWeek(split[0])+"）"
    }

    fun getTimes(time:String):String{
        var split=time.split(" ")

        return getData(split[0])+"（"+getWeek(split[0])+"）"+split[1].substring(0,split[1].length-3)
    }
}