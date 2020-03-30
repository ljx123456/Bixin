package com.example.shadow.heartrecreation.ui.login.activity

import android.graphics.Color
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import cn.qqtheme.framework.picker.DatePicker
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.DbUtils.setUserDB
import com.example.shadow.heartrecreation.ui.login.SexDialog
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.CheckNameBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.RegDataBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.CheckNameBody
import com.example.shadow.heartrecreation.ui.login.mvp.body.RegDataBody
import com.example.shadow.heartrecreation.ui.login.mvp.presenter.RegDataPresenter
import com.example.shadow.heartrecreation.ui.login.mvp.view.RegDataView
import com.example.shadow.heartrecreation.ui.login.utils.SizeFilterWithTextAndLetter
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentMain
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils
import com.example.shadow.heartrecreation.utils.http.BaseUrl
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.pp.wsy.bosom.app.utils.pickers.pickerUtils
import com.umeng.analytics.MobclickAgent
import kotlinx.android.synthetic.main.activity_register_data.*
import java.util.*

class RegisterDataActivity : BaseActivity(), SexDialog.Sex, RegDataView {

    //昵称校验成功
    override fun setCheckNameRequest(data: CheckNameBean) {
        if(userCode.text!=null&&userCode.text.toString()!=null&&userCode.text.toString().length>0) {
            presenter.setRgeData(RegDataBody(phone, password, password, userName.text.toString(), sex, "${userAge.text.toString()} 00:00:00",userCode.text.toString()))
        }else{
            presenter.setRgeData(RegDataBody(phone, password, password, userName.text.toString(), sex, "${userAge.text.toString()} 00:00:00"))
        }
    }


    private var sexDialog = SexDialog(this)
    private val presenter by lazy { RegDataPresenter(this, this, this) }

    //注册成功
    override fun setRgeDataRequest(data: ByCodeBean) {
//        setUserDB(data.data)
        //友盟统计注册账号数
        if (BaseUrl.HOST_URL=="http://app.bixinyule.com/") {
            MobclickAgent.onEvent(this,"BIXIN_UserClient_Register")
        }
        try {
            var use= DbUtils.getUser()
//            LogUtils.a("useid"+use.userId)
//            LogUtils.a("dataid"+data.data.userId)
            if (use.userId.toString()!=data.data.userId){
                DbUtils.delMerchat()
                DrinkUtils.deleteALLDrinks()
                ServeUtils.deleteALLServe()
                OrderServeUtils.deleteAllOrder()
                user.setNum("0")
                user.setOrderNo("")
                user.setType("1")
                user.setRoomType("0")
                user.setBrokerType("0")
                user.setYueID("1")
                user.setYueName("")
                user.setOrderID("")
                user.setCityID("1")
                user.setCity("")
                user.setRoomMoney("0.00")

                setUserDB(data.data)
                if (SharedUtils.getTag(this)){
                    intentMain()
                }else{
                    com.example.shadow.heartrecreation.ui.leadpage.utils.intentUtils.intentLead0()
                }
                finish()
            }else{
                setUserDB(data.data)
                if (SharedUtils.getTag(this)){
                    intentMain()
                }else{
                    com.example.shadow.heartrecreation.ui.leadpage.utils.intentUtils.intentLead0()
                }
                finish()
            }
        }catch (e:Exception){
            setUserDB(data.data)
            if (SharedUtils.getTag(this)){
                intentMain()
            }else{
                com.example.shadow.heartrecreation.ui.leadpage.utils.intentUtils.intentLead0()
            }
            finish()
        }
    }

    //选择男女
    override fun setSex(s: String, i: Int) {
        userSex.setText(s)
        sex = i
    }

    override fun openEventBus(): Boolean = false
    var phone = ""
    var password = ""
    var sex = 0

    override fun getActivityLayout(): Int = R.layout.activity_register_data

    override fun setActivityTitle() {
    }

    override fun initActivityData() {
        phone = intent.getStringExtra("phone")
        password = intent.getStringExtra("password")
        var filter = arrayOf<InputFilter>(SizeFilterWithTextAndLetter(12,6))
        userName.filters=filter

    }

    override fun clickListener() {
        //选择生日
        Click.viewClick(userAge).subscribe { getTime() }
        //选择性别
        Click.viewClick(userSex).subscribe { sexDialog.show(supportFragmentManager, "") }
        //完成
        Click.viewClick(registerNext).subscribe {
            if (userName.text.toString().length>0&&userName.text!=null&&!userName.text.toString().equals("")&&fill_data_check.isChecked){
                presenter.setCheckName(CheckNameBody(userName.text.toString()))
            }else{
                if (!fill_data_check.isChecked){
                    Toast.Tips("请阅读并同意相关协议")
                }else {
                    Toast.Tips("请输入昵称")
                }
            }

        }

        Click.viewClick(tv_agreement1).subscribe {
            intentUtils.intentHtml(1)
        }

        Click.viewClick(tv_agreement2).subscribe {
            intentUtils.intentHtml(4)
        }

        userName.addTextChangedListener(object :TextWatcher{
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (s==null||s.isEmpty()){
                    var filter = arrayOf<InputFilter>(SizeFilterWithTextAndLetter(12,6))
                    userName.filters=filter
                }
                if (s!=null&&s.toString().length>0&&userAge.text!=null&&userAge.text.length>0&&userSex.text!=null&&userSex.text.length>0){
                    registerNext.isEnabled=true
                }else{
                    registerNext.isEnabled=false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        })

        userAge.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.toString().length>0&&userName.text!=null&&userName.text.length>0&&userSex.text!=null&&userSex.text.length>0){
                    registerNext.isEnabled=true
                }else{
                    registerNext.isEnabled=false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

        userSex.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null&&s.toString().length>0&&userAge.text!=null&&userAge.text.length>0&&userName.text!=null&&userName.text.length>0){
                    registerNext.isEnabled=true
                }else{
                    registerNext.isEnabled=false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

    }

    /**
     * 设置生日
     */
    val c = Calendar.getInstance()//可以对每个时间域单独修改
    var years = c.get(Calendar.YEAR)
    var months = c.get(Calendar.MONTH) + 1
    var dates = c.get(Calendar.DATE)
    fun getTime() {
        var picker = DatePicker(this)
        pickerUtils.showPicker(picker)
        picker.setSelectedItem(years, months, dates)
        picker.setBackgroundColor(Color.parseColor("#FAFAFA"))
        picker.setTopBackgroundColor(Color.parseColor("#ffffff"))
        picker.setLabelTextColor(Color.parseColor("#999999"))
        picker.setTitleText("生日")
        picker.setTitleTextColor(Color.parseColor("#333333"))
        picker.setTitleTextSize(16)
        picker.setOnDatePickListener(cn.qqtheme.framework.picker.DatePicker.OnYearMonthDayPickListener { year, month, day ->
            years = year.toInt()
            months = month.toInt()
            dates = day.toInt()
            userAge.setText("$year-$month-$day")
        })
        picker.show()
    }

    override fun onResume() {
        super.onResume()
        if (BaseUrl.HOST_URL=="http://app.bixinyule.com/") {
            MobclickAgent.onResume(this)
        }
    }

    override fun onPause() {
        super.onPause()
        if (BaseUrl.HOST_URL=="http://app.bixinyule.com/") {
            MobclickAgent.onPause(this)
        }
    }
}