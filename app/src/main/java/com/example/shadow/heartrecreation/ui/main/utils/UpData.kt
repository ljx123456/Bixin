package com.example.shadow.heartrecreation.ui.main.utils

import com.blankj.utilcode.util.AppUtils
import com.example.shadow.heartrecreation.base.BaseAppActivity
import com.example.shadow.heartrecreation.ui.main.base.BaseActivity
import com.example.shadow.heartrecreation.ui.main.dialog.VersionUpdatingDialog
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UpdateBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.UpdateBody
import com.example.shadow.heartrecreation.ui.main.mvp.view.SplashView
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.pp.wsy.bosom.app.ui.login.mvp.presenter.SplashPresenter

class UpData(val activity:BaseActivity):SplashView, VersionUpdatingDialog.VersionUpdatingCallBack {

    private val updataPresenter by lazy { SplashPresenter(activity, this, activity) }
    private val updatingdialog = VersionUpdatingDialog()

//    public fun getUpdata(){
//        updataPresenter.getUpsata(UpdateBody(1, 17))
//    }



    //更新接口
    override fun getUpdateRequest(data: UpdateBean) {
        updatingdialog.setDialogContent(data, this)
        updatingdialog.show(activity.supportFragmentManager, "")
    }
    override fun getUpdateError(code: Int, message: String) {
        if (code!=-1301)
            Toast.Tips(message)
    }

    override fun enterInto() {

    }
}