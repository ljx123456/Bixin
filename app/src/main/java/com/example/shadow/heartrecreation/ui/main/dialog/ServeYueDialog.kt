package com.example.shadow.heartrecreation.ui.main.dialog


import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.DbUtils.getMerchat
import com.example.shadow.heartrecreation.db.ServeUtils
import com.example.shadow.heartrecreation.db.ServeUtils.setServe
import com.example.shadow.heartrecreation.db.db.ServePersonnelDB
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeDetailsBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.dialog_serve_yue.*

class ServeYueDialog : BaseDialogFragment() {
    private var id = ""
    private var image = ""
    private var name = ""
    private var money = ""
    private var time = ""
    private var adds = ""
    private var join = ""
    private var sex = ""
    private var age = ""
    private var merchant = ""
    private var merchantid = ""
    fun setData(id: String, image: String, name: String, mongy: String, time: String, adds: String, join: String, sex: String, age: String, merchant: String, merchantid: String) {
        this.id = id
        this.image = image
        this.name = name
        this.money = mongy
        this.time = time
        this.adds = adds
        this.join = join
        this.sex = sex
        this.age = age
        this.merchant = merchant
        this.merchantid = merchantid
    }

    override fun setLayoutID(): Int = R.layout.dialog_serve_yue


    override fun isFullScreen(): Boolean = true

    override fun setLayoutData() {
        ImageLoad.setUserHead(image, serveDialogImage)
        serveDialogSex.setText("${age}")
        var MerchanData = getMerchat()
        yueChan.setText(MerchanData.merchantName)
        serveDialogName.text=name
//        serveDialogMoney.setText(adds)
        serveDialogMoney.setText("¥:${money}")
        serveYueTime.text = "达人距约玩场地约${adds}，预计${time}内到达"
        when (sex) {
            "1" -> {
                serveDialogSex.setBackgroundResource(R.drawable.man_shape)
                serveDialogSex.setCompoundDrawablesWithIntrinsicBounds(activity!!.resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
            }
            else -> {
                serveDialogSex.setBackgroundResource(R.drawable.woman_shape)
                serveDialogSex.setCompoundDrawablesWithIntrinsicBounds(activity!!.resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
            }
        }
    }

    override fun clickListener() {
        Click.viewClick(serveOver).subscribe { dismiss() }
        Click.viewClick(serveDialogGo).subscribe {
            setServe(ServePersonnelDB(
                    null,
                    "${id}",
                    name, image,
                    "${money}",
                    "",
                    "",
                    "${age}",
                    "${sex}",
                    adds,
                    join)
            )
//            Toast.Tips("添加成功")
            if (ServeUtils.getServeData()[ServeUtils.getServeData().lastIndex].serveID=="${id}"){
                Toast.Tips("添加成功")
            }
            dismiss()
            activity!!.finish()
        }
    }
}