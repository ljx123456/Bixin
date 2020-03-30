package com.example.shadow.heartrecreation.ui.user.activity

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import cn.jpush.im.android.api.JMessageClient
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.ToastUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.AppProject
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils.intentLogin
import com.example.shadow.heartrecreation.ui.main.dialog.VersionUpdatingDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UpdateBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.UpdateBody
import com.example.shadow.heartrecreation.ui.main.mvp.view.SplashView
import com.example.shadow.heartrecreation.ui.user.dialog.CallPhoneDialog
import com.example.shadow.heartrecreation.ui.user.dialog.ClearCacheDialog
import com.example.shadow.heartrecreation.ui.user.dialog.ExitDialog
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.SetPresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.SetView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentBlack
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentHtml
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentOpinionFeedback
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentRegardWe
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentSafe
import com.example.shadow.heartrecreation.utils.DataCleanManager.clearAllCache
import com.example.shadow.heartrecreation.utils.DataCleanManager.getTotalCacheSize
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.utils.*
import com.mylhyl.acp.Acp
import com.mylhyl.acp.AcpListener
import com.mylhyl.acp.AcpOptions
import com.pp.wsy.bosom.app.ui.login.mvp.presenter.SplashPresenter
import kotlinx.android.synthetic.main.activity_set.*
import kotlinx.android.synthetic.main.layout_title.*



class SetActivity : BaseActivity(), SetView, ClearCacheDialog.ClearCacheDialogFace, SplashView, VersionUpdatingDialog.VersionUpdatingCallBack, ExitDialog.Exit,CallPhoneDialog.CallPhone {


    override fun OkExit() {
        presenter.getLogout()
    }

    override fun getUpdateRequest(data: UpdateBean) {
        updatingdialog.setDialogContent(data, this)
        updatingdialog.show(supportFragmentManager, "")
    }
    override fun getUpdateError(code: Int, message: String) {
        Toast.Tips(message)
    }

    override fun enterInto() {

    }

    override fun clearBtnClick() {
//        clearAllCache(this)
//        set_clearawaySize.text = GlideCacheUtil.getInstance().getCacheSize(this)
        GlideCacheUtil.getInstance().clearImageAllCache(this)//清除图片所有缓存
        DataCleanManager.cleanInternalCache(mContext)//清除本应用内部缓存
        DataCleanManager.cleanFiles(mContext)//清除/data/data/com.xxx.xxx/files下的内容
        DataCleanManager.cleanExternalCache(mContext)//清除外部cache下的内容
        set_clearawaySize.text = GlideCacheUtil.getInstance().getCacheSize(this)
    }

    //退出登陆
    override fun getLogoutRequest() {
        DbUtils.DelUser()
        DbUtils.delMerchat()
        DrinkUtils.deleteALLDrinks()
        ServeUtils.deleteALLServe()
        OrderServeUtils.deleteAllOrder()
        JMessageClient.logout()
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
        ActivityUtils.finishAllActivities()
        intentLogin()
    }

    //拨打电话
    override fun call() {
        CallPhone("4008677080")
    }

    override fun openEventBus(): Boolean = false
    private val updatingdialog = VersionUpdatingDialog()
    override fun getActivityLayout(): Int = R.layout.activity_set
    private val presenter by lazy { SetPresenter(this, this, this) }
    private val updataPresenter by lazy { SplashPresenter(this, this, this) }
    private val clearcachedialog = ClearCacheDialog()
    private val exitdialog = ExitDialog(this)
    //设置公司电话
    private val callPhoneDialog=CallPhoneDialog(this,"400-867-7080")
    override fun setActivityTitle() {
        titleText.setText("设置")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
    }

    override fun initActivityData() {
        set_clearawaySize.text = getTotalCacheSize(this)
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }

        //安全中心
        Click.viewClick(set_safe).subscribe {
            intentSafe()
        }
        //黑名单
        Click.viewClick(set_blacklist).subscribe { intentBlack() }
        //意见反馈
        Click.viewClick(set_feedback).subscribe { intentOpinionFeedback() }
        //帮助中心
        Click.viewClick(set_help).subscribe { intentHtml(2) }
        //版本更新
        Click.viewClick(set_update).subscribe { updataPresenter.getUpsata(UpdateBody(1, AppUtils.getAppVersionCode())) }
        //清楚缓存
        Click.viewClick(set_clearaway).subscribe {
            if (clearcachedialog.isAdded){
                clearcachedialog.dismiss()
            }else {
                clearcachedialog.setDataSize(getTotalCacheSize(this), this)
                clearcachedialog.showDialog(this)
            }
        }
        //关于我们
        Click.viewClick(set_we).subscribe { intentRegardWe() }
        //联系我们
        Click.viewClick(set_phone).subscribe {
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
            callPhoneDialog.show(supportFragmentManager,"")
        }
        //修改电话
        Click.viewClick(set_alter_phone).subscribe { }
        //退出登录
        Click.viewClick(set_over_user).subscribe {
            exitdialog.show(supportFragmentManager, "")

        }


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

    override fun onDestroy() {
        super.onDestroy()
        Log.e("测试","销毁了set")
//        val refWatcher = AppProject.getRefWatcher(this)
//        refWatcher.watch(this)
    }
}