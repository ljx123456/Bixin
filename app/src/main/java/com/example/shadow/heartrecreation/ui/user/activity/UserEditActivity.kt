package com.example.shadow.heartrecreation.ui.user.activity

import android.content.Intent
import android.graphics.Color
import android.provider.MediaStore
import android.text.Editable
import android.text.InputFilter
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import cn.qqtheme.framework.picker.DatePicker

import com.example.shadow.heartrecreation.utils.utils.Click
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.DbUtils
import com.example.shadow.heartrecreation.db.DbUtils.getUser
import com.example.shadow.heartrecreation.db.DbUtils.setUserDB
import com.example.shadow.heartrecreation.db.db.UserDB
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.db.user.getUserBirthday
import com.example.shadow.heartrecreation.db.user.getUserID
import com.example.shadow.heartrecreation.db.user.getUserImage
import com.example.shadow.heartrecreation.db.user.getUserNick
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.login.mvp.bean.ByCodeBean
import com.example.shadow.heartrecreation.ui.login.mvp.bean.CheckNameBean
import com.example.shadow.heartrecreation.ui.login.mvp.body.CheckNameBody
import com.example.shadow.heartrecreation.ui.login.utils.SizeFilterWithTextAndLetter
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.QiniuPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.QiniuView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.UserEditBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.UserEditBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.UserEditPresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.UserEditView
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.CameraSelect
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.pp.wsy.bosom.app.utils.pickers.pickerUtils
import kotlinx.android.synthetic.main.activity_user_edit.*
import kotlinx.android.synthetic.main.layout_title.*
import java.io.File
import java.util.*

class UserEditActivity : BaseActivity(), UserEditView, CameraSelect.CameraSelectFace, QiniuView {
    override fun setCheckNameRequest(data: CheckNameBean) {
        presenter.UserEdit(UserEditBody(getUserToken(), userName.text.toString(), "${userBirthday.text.toString()} 00:00:00", imageUrl))
    }

    //数据更新成功
    override fun getUserEditRequest(data: UserEditBean) {
        var info = getUser()
        var infoData = ByCodeBean.DataBean()
        infoData.avatar = imageUrl
        infoData.birthday = userBirthday.text.toString()
        infoData.constellation = data.data.constellation
        infoData.identity = info.identity
        infoData.nickname = userName.text.toString()
        infoData.phone = info.phone
        infoData.rongToken = info.rongToken
        infoData.sex = info.sex.toInt()
        infoData.token = info.token
        infoData.bixinId=info.bixinId
        infoData.age=data.data.age
        infoData.jmpassword=info.jmpassword
        infoData.userId=info.userId.toString()
        setUserDB(infoData)
        finish()
    }

    //图片上传成功
    override fun sendSucceedImage(fileUrlList: ArrayList<String>) {
        imageUrl = "http://pic.bixinyule.com/" + fileUrlList.get(0)
        LogUtils.a("图片地址" + imageUrl)
        ImageLoad.setUserHead(imageUrl, userImage)
        if (!file!!.exists()) {
            return
        } else {
//            file!!.delete()
            deletePic(file!!.absolutePath)
        }
    }

    //图片上传失败
    override fun sendFileErrorImage() {

    }

    //图片选择回调
    override fun returnCameraImageList(list: ArrayList<String>) {
        if (list!=null&&list.size>0) {
            qiniuPresenter.setImage(list)
            file = File(list[0])
        }
    }

    override fun openEventBus(): Boolean = false
    private var imageUrl = ""
    private val presenter by lazy { UserEditPresenter(this, this, this) }
    private val qiniuPresenter by lazy { QiniuPresenter(this, this, this) }
    private var cameraSelect = CameraSelect(this)
    private var file: File?=null

    override fun getActivityLayout(): Int = R.layout.activity_user_edit

    override fun setActivityTitle() {
        titleText.text = "修改资料"
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
        ImageLoad.setUserHead(getUserImage(), userImage)
        imageUrl = getUserImage()
        userName.setText(DbUtils.getUser().nickname)
        userBirthday.text = getUser().birthday.subSequence(0, 10)
        titleRightText.visibility = View.VISIBLE
        titleRight.visibility = View.GONE
        titleRightText.text = "保存"
        titleRightText.setTextColor(Color.parseColor("#333333"))
    }

    override fun initActivityData() {
        cameraSelect.initSingleCameraSdk(this)
        ImageLoad.setUserHead(getUserImage(), userImage)
        userID.text = "${getUserID()}"
        if (getUser().sex.equals("1")) {
            userAge.text = "男"
        } else {
            userAge.text = "女"
        }
        var filter = arrayOf<InputFilter>(SizeFilterWithTextAndLetter(12,6))
        userName.filters=filter
    }

    override fun clickListener() {
        Click.viewClick(userImage).subscribe { cameraSelect.openCamera() }
        Click.viewClick(userBirthday).subscribe {
            getTime()
        }
        Click.viewClick(titleRightText).subscribe {
            if (userName.text.toString().length>0&&userName.text!=null&&!userName.text.toString().equals("")){
                if (userName.text.toString()==user.getUserNick()){
                    presenter.UserEdit(UserEditBody(getUserToken(), userName.text.toString(), "${userBirthday.text.toString()} 00:00:00", imageUrl))
                }else {
                    presenter.setCheckName(CheckNameBody(userName.text.toString()))
                }
            }else{
                Toast.Tips("请输入昵称")
            }
        }
        Click.viewClick(titleLeft).subscribe { finish() }

        userName.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (s==null||s.isEmpty()){
                    var filter = arrayOf<InputFilter>(SizeFilterWithTextAndLetter(12,6))
                    userName.filters=filter
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        cameraSelect.onActivityCameraResult(requestCode, resultCode, data)
    }

//    /**
//     * 设置生日
//     */
////    val c = Calendar.getInstance()//可以对每个时间域单独修改
////    var years = c.get(Calendar.YEAR)
////    var months = c.get(Calendar.MONTH) + 1
////    var dates = c.get(Calendar.DATE)
//    fun getTime() {
//        var time = userBirthday.text.toString()
//        var years = "${time.substring(0, 4)}".toInt()
//        var months = "${time.substring(5, 7)}".toInt()
//        var dates = "${time.substring(8, 10)}".toInt()
//
//        LogUtils.a("${years}-${months}-${dates}")
//        var picker = DatePicker(this)
//        pickerUtils.showPicker(picker)
//        picker.setSelectedItem(years, months, dates)
//        picker.setBackgroundColor(Color.parseColor("#FAFAFA"))
//        picker.setTopBackgroundColor(Color.parseColor("#ffffff"))
//        picker.setLabelTextColor(Color.parseColor("#999999"))
//        picker.setSubmitTextColor(Color.parseColor("#FE849B"))
//        picker.setTitleText("生日")
//        picker.setTitleTextColor(Color.parseColor("#333333"))
//        picker.setTitleTextSize(16)
//        picker.setOnDatePickListener(cn.qqtheme.framework.picker.DatePicker.OnYearMonthDayPickListener { year, month, day ->
//            years = year.toInt()
//            months = month.toInt()
//            dates = day.toInt()
//
//        })
//        picker.show()
//    }

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
            userBirthday.setText("$year-$month-$day")
        })
        picker.show()
    }

    private fun deletePic(path:String){
        if(!TextUtils.isEmpty(path)){
            val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val contentResolver = this.getContentResolver()//cutPic.this是一个上下文
//            val url =  MediaStore.Images.Media.DATA + "='" + path + "'"
//            //删除图片
//            contentResolver.delete(uri, url, null)
            val url =  MediaStore.Images.Media.DATA + "=?"
            //删除图片
            contentResolver.delete(uri, url, arrayOf(path))
        }
    }
}