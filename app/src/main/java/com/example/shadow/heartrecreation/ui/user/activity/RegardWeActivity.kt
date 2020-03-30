package com.example.shadow.heartrecreation.mvp.view.activity

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Build
import com.blankj.utilcode.util.AppUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.blankj.utilcode.util.ToastUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentHtml
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.mylhyl.acp.Acp
import com.mylhyl.acp.AcpListener
import com.mylhyl.acp.AcpOptions
import kotlinx.android.synthetic.main.activity_regard_we.*
import kotlinx.android.synthetic.main.layout_title.*

/**
 * 关于我们
 */
class RegardWeActivity : BaseActivity() {
    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_regard_we

    override fun setActivityTitle() {
        titleText.text = "关于我们"
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
    }

    override fun initActivityData() {
        versionName.text="版本号：V${AppUtils.getAppVersionName()}"
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
//        Click.viewClick(user_agreement).subscribe {
//            intentHtml(1)
//        }
//        Click.viewClick(service_phone).subscribe {
//            ShowDialog.showCustomDialog(this, "提示信息", "是否拨打400-867-7080电话", "拨打电话", "取消", object : DialogInterface.OnClickListener {
//                override fun onClick(dialog: DialogInterface?, which: Int) {
//                    when (which) {
//                        DialogInterface.BUTTON_POSITIVE -> {
//                            CallPhone("4008677080")
//                            dialog!!.dismiss()
//                        }
//                        DialogInterface.BUTTON_NEGATIVE -> {
//                            dialog!!.dismiss()
//                        }
//                    }
//                }
//            })
//        }
    }

    fun CallPhone(phoneNum: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Acp.getInstance(getApplication()).request(AcpOptions.Builder()
                    .setPermissions(Manifest.permission.CALL_PHONE)
                    .build(),
                    object : AcpListener {
                        override fun onGranted() {
                            val intent = Intent(Intent.ACTION_DIAL)
                            val data = Uri.parse("tel:$phoneNum")
                            intent.setData(data)
                            startActivity(intent)
                        }

                        override fun onDenied(permissions: List<String>) {
                            ToastUtils.showShort("获取系统权限失败，请手动开启")
                        }
                    })
        } else {
            val intent = Intent(Intent.ACTION_DIAL)
            val data = Uri.parse("tel:$phoneNum")
            intent.setData(data)
            startActivity(intent)
        }
    }
}