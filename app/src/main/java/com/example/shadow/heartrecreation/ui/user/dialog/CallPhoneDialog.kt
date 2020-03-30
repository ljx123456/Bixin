package com.example.shadow.heartrecreation.ui.user.dialog

import android.annotation.SuppressLint
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.dialog_call_phone.*

@SuppressLint("ValidFragment")
class CallPhoneDialog(val callPhone: CallPhone,val phoneNum:String):BaseDialogFragment(){
    override fun setLayoutID(): Int = R.layout.dialog_call_phone

    override fun isFullScreen(): Boolean=true

    override fun setLayoutData() {
        callPhoneOK.text=phoneNum
    }

    override fun clickListener() {
        Click.viewClick(callPhoneOK).subscribe{
            callPhone.call()
            dismiss()}
        Click.viewClick(callPhoneOver).subscribe { dismiss() }
    }

    interface CallPhone{
        fun call()
    }
}