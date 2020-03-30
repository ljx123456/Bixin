package com.example.shadow.heartrecreation.ui.user.activity

import android.text.Editable
import android.text.TextWatcher
import com.example.shadow.heartrecreation.utils.utils.Click
import com.blankj.utilcode.util.ToastUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.user.mvp.body.FeedbackAddBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.FeedbackAddPresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.FeedbackAddView
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.activity_opinion_feedback.*
import kotlinx.android.synthetic.main.layout_title.*

class OpinionFeedbackActivity : BaseActivity(), TextWatcher, FeedbackAddView {
    override fun getFeedbackAddRequest() {
        Toast.Tips("感谢您的反馈")
        finish()
    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (s!!.length >= 500) {
            Toast.Tips("当前输入内容不能超过500字")
        }
        opinion_feedback_num.setText("${s!!.length}/500字")
    }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_opinion_feedback
    private val presenter by lazy { FeedbackAddPresenter(this, this, this) }

    override fun setActivityTitle() {
        titleText.setText("意见反馈")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
    }

    override fun initActivityData() {
    }

    override fun clickListener() {
        opinion_feedback_context.addTextChangedListener(this)
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(opinion_feedback_ok).subscribe {
            if (opinion_feedback_context.text.toString().length > 0) {
                presenter.getFeedbackAdd(FeedbackAddBody(opinion_feedback_context.text.toString(), getUserToken()))
            } else {
                Toast.Tips("请输入反馈内容")
            }
        }
    }

}