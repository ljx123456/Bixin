package com.example.shadow.heartrecreation.ui.main.dialog

import android.annotation.SuppressLint
import android.util.Log
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OccupationBean
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.OccupationPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.OccupationView
import com.qiniu.android.utils.StringUtils
import kotlinx.android.synthetic.main.dialog_screen.*

@SuppressLint("ValidFragment")
class ScreenDialog(val screen: Screen) : BaseDialogFragment(),OccupationView {
    override fun getOccupationRequest(data: OccupationBean) {

    }

    var stringHight = ArrayList<String>()
    var stringAge = ArrayList<String>()
    var stringJoin = ArrayList<String>()
    var stringSex = ArrayList<String>()
    var stringType = ArrayList<String>()
    var hight = ""
    var Age = ""
    var Sex = 0
    var Type = 0
    var join = ""
//    private val present by lazy { OccupationPresenter(this,this,activity!!) }

    override fun setLayoutID(): Int = R.layout.dialog_screen

    override fun isFullScreen(): Boolean = true

    override fun setLayoutData() {
        setData()
        screenHight.setList(stringHight)
        screenAge.setList(stringAge)
        screenJoin.setList(stringJoin)
        screenSex.setList(stringSex)
        screenType.setList(stringType)

        screenSex.setIndexItemSelected(0)
        screenAge.setIndexItemSelected(0)
        screenJoin.setIndexItemSelected(0)
        screenType.setIndexItemSelected(0)

    }

    private fun setData() {
        stringHight.add("全部")
        stringHight.add("160cm以下")
        stringHight.add("160cm~165cm")
        stringHight.add("165cm~170cm")
        stringHight.add("170cm 以上")

        stringSex.add("全部")
        stringSex.add("男")
        stringSex.add("女")

        stringType.add("全部")
        stringType.add("空闲的")

        stringAge.add("全部")
        stringAge.add("20岁以下")
        stringAge.add("20岁~24岁")
        stringAge.add("24岁~28岁")
        stringAge.add("28岁以上")

        stringJoin.add("全部")
        stringJoin.add("教师")
        stringJoin.add("律师")
        stringJoin.add("医生")
        stringJoin.add("模特")
        stringJoin.add("驻唱")
        stringJoin.add("主播")
        stringJoin.add("歌手")
        stringJoin.add("演员")
        stringJoin.add("行政")
        stringJoin.add("人事")
        stringJoin.add("销售")
        stringJoin.add("客服")
        stringJoin.add("运营")
        stringJoin.add("秘书")
        stringJoin.add("前台")
        stringJoin.add("会计")
        stringJoin.add("护士")
        stringJoin.add("无业")
        stringJoin.add("摄影师")
        stringJoin.add("设计师")
        stringJoin.add("化妆师")
        stringJoin.add("造型师")
        stringJoin.add("品酒师")
        stringJoin.add("舞蹈老师")
        stringJoin.add("音乐老师")
        stringJoin.add("健身教练")
        stringJoin.add("自由职业")
        stringJoin.add("在校学生")


//        stringJoin.add("其他")
    }

    override fun clickListener() {
        Click.viewClick(dialogOver).subscribe { dismiss() }
        Click.viewClick(screenOver).subscribe {
            screenAge.cancelAllSelectedItems()
            screenSex.cancelAllSelectedItems()
            screenHight.cancelAllSelectedItems()
            screenJoin.cancelAllSelectedItems()
            screenType.cancelAllSelectedItems()
            screenAge.setIndexItemSelected(0)
            screenSex.setIndexItemSelected(0)
            screenHight.setIndexItemSelected(0)
            screenJoin.setIndexItemSelected(0)
            screenType.setIndexItemSelected(0)
            Type=0
            hight="140cm-200cm"
            Age="0-100"
            join=""
            Sex=0
//            screen.setScreenData(0, "140cm-200cm", "0-50", "", 0)
        }
        Click.viewClick(screenOk).subscribe {
            if (screenHight.selectedItemText != null) {
                hight = screenHight.selectedItemText
            } else {
                hight = ""
            }
            if (screenAge.selectedIndex != null) {
//                Age = screenAge.selectedItemText
                when (screenAge.selectedIndex) {
                    1 -> Age = "0-20"
                    2 -> Age = "20-24"
                    3 -> Age = "24-28"
                    4 -> Age = "28-100"
                    else -> Age = "0-100"
                }
            } else {
                Age = "0-100"
            }



            if (screenSex.selectedIndex != null) {
                if (screenSex.selectedIndex==-1){
                    Sex = 0
                }else {
                    Sex = screenSex.selectedIndex
                }
            } else {
                Sex = 0
            }
            if (screenType.selectedIndex != null) {
                if (screenType.selectedIndex==-1){
                    Type = 0
                }else {
                    Type = screenType.selectedIndex
                }
            } else {
                Type = 0
            }
            if (screenJoin.selectedItemText != null) {
                if (screenJoin.selectedItemText.toString().equals("全部"))
                    join=""
                else
                    join = screenJoin.selectedItemText
            } else {
                join = ""
            }
            dismiss()
            Log.e("测试","sex:"+Sex+"hight:"+hight+"age:"+Age+"join:"+join+"type:"+Type)
            screen.setScreenData(Sex, hight, Age, join, Type)
        }
    }

    interface Screen {
        fun setScreenData(selectedIndex: Int, selectedItemText: String, selectedItemText1: String, join: String, selectedIndex1: Int)
    }
}