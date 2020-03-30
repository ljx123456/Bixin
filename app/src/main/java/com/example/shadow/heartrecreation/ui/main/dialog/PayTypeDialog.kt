package com.example.shadow.heartrecreation.ui.main.dialog

import android.annotation.SuppressLint
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.dialog_pay_type.*

@SuppressLint("ValidFragment")
class PayTypeDialog(val paytype: PayType) : BaseDialogFragment() {
    override fun setLayoutID(): Int = R.layout.dialog_pay_type

    override fun isFullScreen(): Boolean = false

    override fun setLayoutData() {
    }

    override fun clickListener() {
        Click.viewClick(payOver).subscribe { dismiss() }
        Click.viewClick(payOk).subscribe {
            if (weChat.isChecked) {
                dismiss()
                paytype.setPayType("2")//微信支付
            } else if (alipay.isChecked) {
                dismiss()
                paytype.setPayType("1") //支付宝支付
            } else {
                Toast.Tips("请选择支付类型")
            }
        }

    }

    //支付类型, 1 支付宝，2 微信
    interface PayType {
        fun setPayType(s: String)

    }
}