package com.example.shadow.heartrecreation.ui.main.fragment

import android.annotation.SuppressLint
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseFragment

@SuppressLint("ValidFragment")
class CouponsFragment(it: String) : BaseFragment() {
    override fun openEventBus(): Boolean = false

    override fun setLayoutTitle() {
    }

    override fun initFragmentData() {
    }

    override fun setFragmentListener() {
    }

    override fun layoutID(): Int = R.layout.fragment_coupons

}