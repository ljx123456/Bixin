package com.example.shadow.heartrecreation.ui.main.dialog

import com.blankj.utilcode.util.ActivityUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.dialog_login_other.*

class OtherLoginDialog:BaseDialogFragment(){
    override fun setLayoutID(): Int = R.layout.dialog_login_other

    override fun isFullScreen(): Boolean =true

    override fun setLayoutData() {
        this.isCancelable=false
    }

    override fun clickListener() {
        Click.viewClick(yes).subscribe {
            ActivityUtils.finishAllActivities()
            intentUtils.intentLogin()
        }
    }

}