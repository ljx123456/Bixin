package  com.example.shadow.heartrecreation.ui.main.dialog

import android.content.Context
import android.view.View
import com.blankj.utilcode.util.AppUtils.getAppPackageName
import com.blankj.utilcode.util.AppUtils.installApp
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UpdateBean
import com.example.shadow.heartrecreation.utils.VersionDownloader
import com.example.shadow.heartrecreation.utils.permissions.UserPermissions
import com.example.shadow.heartrecreation.utils.permissions.UserPermissions.userSD
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.dialog_version_updating.*

class VersionUpdatingDialog : BaseDialogFragment(), UserPermissions.MemoryReadPermissionsFace, VersionDownloader.FileDownloaderCallBack {
    override fun requestPermissionsFaceError() {
        Toast.Tips("请打开APP所需内存读取权限→设置→应用→权限管理")
    }

    override fun isFullScreen(): Boolean = true

    //开始下载
    override fun requestPermissionsFaceSucceed(context: Context, what: Int) {
        startFileDownloaderLayout()
        versionDownloader.fileDownloader(auditStateBean.data.packageUrl, "${auditStateBean.data.packageVersion}")
    }

    private val STATETEXT = "安装"
    private val versionDownloader by lazy { VersionDownloader(this, activity!!) }


    private lateinit var auditStateBean: UpdateBean
    private lateinit var versionUpdatingCallBack: VersionUpdatingCallBack


    override fun setLayoutID(): Int = R.layout.dialog_version_updating

    override fun setLayoutData() {
        setLayoutView()
        judgeUpdating()
    }

    //渲染UI页面
    private fun setLayoutView() {
        if (auditStateBean.data.description!=null&&auditStateBean.data.description.size>0) {
            auditStateBean.data.description.forEachIndexed { index, s ->
                if (index == 0) {
                    content.text = "${index + 1}、" + s
                } else {
                    content.text = "${content.text}\n" + "${index + 1}、" + s
                }
            }
        }else{
            content.text="无"
        }
//        content.text = auditStateBean.data.packageUrl
        titleVersion.text = auditStateBean.data.packageNo
    }

    //判断是否强制更新
    private fun judgeUpdating() {
        if (auditStateBean.data.isForce == 1) {
            this.isCancelable=false
            constraintUpdating()
        }
        else {
            this.isCancelable=true
            closableUpdating()
        }
    }

    //可选更新
    private fun closableUpdating() {
        dismissBtn.visibility = View.VISIBLE
    }


    //强制更新
    private fun constraintUpdating() {
        dismissBtn.visibility = View.GONE
    }


    override fun clickListener() {
        Click.viewClick(updatingBtn).subscribe { updateClick() }
        Click.viewClick(dismissBtn).subscribe { dismissBtnClick() }
    }

    //取消更新
    private fun dismissBtnClick() {
        versionUpdatingCallBack.enterInto()
        dismiss()
    }


    //开始更新
    private fun updateClick() {
//        updatingBtn.visibility = View.GONE
        val content = updatingBtn.text.toString()
        if (content != STATETEXT) startUpdating()
        else installApp(versionDownloader.saveFileName, getAppPackageName() + ".fileprovider")
    }


    //开始下载更新
    private fun startUpdating() {
        userSD(context!!, this)
    }


    //显示更新的UI
    private fun startFileDownloaderLayout() {
        updatingBtn.visibility = View.GONE
        progressbarLayout.visibility = View.VISIBLE
    }


    //下载进度
    override fun onProgress(progress: Int) {
        progressbar.progress = progress
        progressText.text = progress.toString() + "%"
    }

    //开始下载
    override fun onPending(string: String) {
        progressText.text = string
    }


    //下载结束
    override fun completed(file: String) {
        updatingBtn.visibility = View.VISIBLE
        progressbarLayout.visibility = View.GONE
        updatingBtn.text = STATETEXT
        setCompletedUi()
        installApp(versionDownloader.saveFileName, getAppPackageName() + ".fileprovider")
    }


    //设置下载完成UI
    private fun setCompletedUi() {
        progressbar.progress = 100
        progressText.text = "100%"
        updatingBtn.text = STATETEXT
        updatingBtn.visibility = View.VISIBLE
    }


    interface VersionUpdatingCallBack {
        fun enterInto()
    }


    fun setDialogContent(auditStateBean: UpdateBean, versionUpdatingCallBack: VersionUpdatingCallBack) {
        this.auditStateBean = auditStateBean
        this.versionUpdatingCallBack = versionUpdatingCallBack
    }

}