package com.example.shadow.heartrecreation.ui.share

import android.annotation.SuppressLint
import android.view.Gravity
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import kotlinx.android.synthetic.main.dialog_share.*

@SuppressLint("ValidFragment")
class ShareDialog(val share: Share) : BaseDialogFragment() {

    override fun setLayoutID(): Int = R.layout.dialog_share

    override fun isFullScreen(): Boolean = true

    override fun setLayoutData() {
//        setLocation(Gravity.BOTTOM)
    }

    override fun clickListener() {
        Click.viewClick(shareOff).subscribe { dismiss() }
        Click.viewClick(shareOver).subscribe { dismiss() }
        //微信分享
        Click.viewClick(shareWX).subscribe {
            share.setShareWX()
            dismiss()
        }
        //朋友圈分享
        Click.viewClick(sharePYQ).subscribe {
            share.setSharePYQ()
            dismiss()
        }
    }

    interface Share {
        fun setShareWX()
        fun setSharePYQ()
    }
}