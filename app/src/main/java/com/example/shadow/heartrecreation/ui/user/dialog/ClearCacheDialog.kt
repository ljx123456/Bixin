package com.example.shadow.heartrecreation.ui.user.dialog

import android.view.Gravity
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.dialog_clear_cache.*

/**
 * Created by Administrator on 2018/8/20 0020.
 * 清除缓存
 */
class ClearCacheDialog : BaseDialogFragment() {
    override fun isFullScreen(): Boolean = false

    private var totalCacheSize = ""
    private var face: ClearCacheDialogFace? = null


    override fun setLayoutID(): Int = R.layout.dialog_clear_cache


    override fun setLayoutData() {
//        dialogContent.text = "清除缓存" + totalCacheSize
        dialogContent.text="所有缓存数据（包括音频，图片，视频）将从你设备上移除"
        setLocation(Gravity.CENTER)
    }

    override fun clickListener() {
        Click.viewClick(dismissBtn).subscribe { dismiss() }
        Click.viewClick(clearBtn).subscribe { clearBtnClick() }
    }

    private fun clearBtnClick() {
        face?.clearBtnClick()
        dismiss()
    }

    fun setDataSize(totalCacheSize: String, face: ClearCacheDialogFace) {
        this.face = face
        this.totalCacheSize = totalCacheSize
    }

    interface ClearCacheDialogFace {
        fun clearBtnClick()
    }

}