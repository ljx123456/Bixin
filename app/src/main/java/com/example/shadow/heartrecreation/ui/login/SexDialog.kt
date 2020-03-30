package com.example.shadow.heartrecreation.ui.login

import android.annotation.SuppressLint
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import kotlinx.android.synthetic.main.dialog_sex.*

@SuppressLint("ValidFragment")
class SexDialog(val sex: Sex) : BaseDialogFragment() {
    override fun setLayoutID(): Int = R.layout.dialog_sex

    override fun isFullScreen(): Boolean = true

    override fun setLayoutData() {
    }

    override fun clickListener() {
        Click.viewClick(dialogMan).subscribe {
            sex.setSex("男", 1)
            dismiss()
        }
        Click.viewClick(dialogWoman).subscribe {
            sex.setSex("女", 2)
            dismiss()
        }
        Click.viewClick(dialogOver).subscribe {
            dismiss()
        }
    }

    interface Sex {
        fun setSex(s: String, i: Int)
    }
}