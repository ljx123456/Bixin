package com.example.shadow.heartrecreation.ui.main.dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.Gravity
import android.view.View
import cn.qqtheme.framework.util.ConvertUtils
import cn.qqtheme.framework.widget.WheelView
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.user
import kotlinx.android.synthetic.main.dialog_num.*

@SuppressLint("ValidFragment")
class NumDialog(val peoplenum: PeoPleNum) : BaseDialogFragment() {

    override fun setLayoutID(): Int = R.layout.dialog_num

    override fun isFullScreen(): Boolean = false

    override fun setLayoutData() {
        setLocation(Gravity.TOP)
        var people = "3"
        var numlist = ArrayList<String>()
        for (i in 1..99) {
            numlist.add("${i}")
        }
        wheelviewSingle.setItems(numlist, 2)
        wheelviewSingle.setTextColor(activity!!.resources.getColor(R.color.gray), activity!!.resources.getColor(R.color.red))
        wheelviewSingle.setTextSize(20f)
        wheelviewSingle.setCycleDisable(false)
        val config = WheelView.DividerConfig()
        config.setRatio(1.0f / 10.0f)//线比率
        config.setVisible(false)
        wheelviewSingle.setDividerConfig(config)
        wheelviewSingle.setOnItemSelectListener { index ->
            people = numlist.get(index)
        }
        Click.viewClick(nextBtn).subscribe {
//            user.setNum(people)
            peoplenum.setPeoPleNum(people)
            dismiss()
        }
        textxianshi.setCompoundDrawablesWithIntrinsicBounds(null, null, activity!!.getDrawable(R.mipmap.xia), null)
        textxianshi.setText("展开")
        textone.visibility = View.GONE
        texttwo.visibility = View.GONE
        textthree.visibility = View.GONE
        textfour.visibility = View.GONE
        Click.viewClick(textxianshi).subscribe {
            if (textone.visibility == 0) {
                textxianshi.setText("展开")
                textxianshi.setCompoundDrawablesWithIntrinsicBounds(null, null, activity!!.getDrawable(R.mipmap.xia), null)
                textone.visibility = View.GONE
                texttwo.visibility = View.GONE
                textthree.visibility = View.GONE
                textfour.visibility = View.GONE
            } else {
                textxianshi.setCompoundDrawablesWithIntrinsicBounds(null, null, activity!!.getDrawable(R.mipmap.shang), null)
                textxianshi.setText("收起")
                textone.visibility = View.VISIBLE
                texttwo.visibility = View.VISIBLE
                textthree.visibility = View.VISIBLE
                textfour.visibility = View.VISIBLE
            }
        }


    }

    override fun clickListener() {

    }

    interface PeoPleNum {
        fun setPeoPleNum(get: String)
    }
}