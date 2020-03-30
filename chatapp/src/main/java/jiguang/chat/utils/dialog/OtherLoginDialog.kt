package jiguang.chat.utils.dialog

import jiguang.chat.R


class OtherLoginDialog: BaseDialogFragment(){
    override fun setLayoutID(): Int = R.layout.dialog_login_other

    override fun isFullScreen(): Boolean =true

    override fun setLayoutData() {
        this.isCancelable=false
    }

    override fun clickListener() {
    }

}