package com.example.shadow.heartrecreation.ui.user.dialog

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.*
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.dialog_exit.*

@SuppressLint("ValidFragment")
class ExitDialog(val exit: Exit) : BaseDialogFragment() {
    override fun isFullScreen(): Boolean = true

    override fun clickListener() {
        Click.viewClick(exitOK).subscribe { exit.OkExit() }
        Click.viewClick(exitOver).subscribe { dismiss() }

    }

    override fun setLayoutData() {

    }

    override fun setLayoutID(): Int = R.layout.dialog_exit
    interface Exit {
        fun OkExit()
    }
}