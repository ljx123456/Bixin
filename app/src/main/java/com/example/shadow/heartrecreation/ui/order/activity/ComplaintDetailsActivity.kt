package com.example.shadow.heartrecreation.ui.order.activity

import android.view.View
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ComplaintDetailsBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.ComplaintDetailsBody
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.ComplaintDetailsPresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.ComplaintDetailsView
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.activity_complaint_details.*
import kotlinx.android.synthetic.main.layout_title.*

class ComplaintDetailsActivity:BaseActivity(),ComplaintDetailsView{

    private val presenter by lazy { ComplaintDetailsPresenter(this,this,this) }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int =R.layout.activity_complaint_details

    override fun setActivityTitle() {
        titleText.text="投诉"
        titleLeft.setImageResource(R.mipmap.icon_close)
    }

    override fun initActivityData() {
        presenter.getComplaintDetails(ComplaintDetailsBody(intent.getStringExtra("complaintId")))
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }

    override fun getComplaintDetailsRequest(data: ComplaintDetailsBean) {
        if (data.data!=null&&data.data.reason!=null){
            tv_complaint_start_time.text=data.data.submitTime
            when(data.data.complaintsState){
                0->{
                    layout_complaint_in_view.visibility=View.GONE
                    layout_complaint_end_view.visibility=View.GONE
                    layout_complaint_in.visibility=View.GONE
                    layout_complaint_end.visibility=View.GONE
                    layout_complaint_result.visibility=View.GONE
                }
                1->{
                    layout_complaint_in_view.visibility=View.VISIBLE
                    layout_complaint_end_view.visibility=View.GONE
                    layout_complaint_in.visibility=View.VISIBLE
                    layout_complaint_end.visibility=View.GONE
                    layout_complaint_result.visibility=View.GONE
                    tv_complaint_in_time.text=data.data.handleTime
                }
                2->{
                    layout_complaint_in_view.visibility=View.VISIBLE
                    layout_complaint_end_view.visibility=View.VISIBLE
                    layout_complaint_in.visibility=View.VISIBLE
                    layout_complaint_end.visibility=View.VISIBLE
                    layout_complaint_result.visibility=View.VISIBLE
                    tv_complaint_in_time.text=data.data.handleTime
                    tv_complaint_end_time.text=data.data.endTime
                    tv_complaint_result.text=data.data.handleRes
                }
            }

            tv_complaint_reason.text=data.data.reason
            complaint_context.text=data.data.content
            if (data.data.photos!=null&&data.data.photos.size>0){
                layout_complaint_photo.visibility=View.VISIBLE
                if (data.data.photos.size==1){
                    complaint_img1.visibility=View.VISIBLE
                    complaint_img2.visibility=View.GONE
                    complaint_img3.visibility=View.GONE
                    ImageLoad.setImage(data.data.photos[0],complaint_img1)
                }else if (data.data.photos.size==2) {
                    complaint_img1.visibility = View.VISIBLE
                    complaint_img2.visibility = View.VISIBLE
                    complaint_img3.visibility = View.GONE
                    ImageLoad.setImage(data.data.photos[0], complaint_img1)
                    ImageLoad.setImage(data.data.photos[1], complaint_img2)
                }else{
                    complaint_img1.visibility = View.VISIBLE
                    complaint_img2.visibility = View.VISIBLE
                    complaint_img3.visibility = View.VISIBLE
                    ImageLoad.setImage(data.data.photos[0], complaint_img1)
                    ImageLoad.setImage(data.data.photos[1], complaint_img2)
                    ImageLoad.setImage(data.data.photos[2], complaint_img3)
                }
            }else{
                layout_complaint_photo.visibility=View.GONE
            }


        }

    }
}