package com.example.shadow.heartrecreation.ui.order.activity

import android.content.Intent
import android.provider.MediaStore
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.QiniuPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.QiniuView
import com.example.shadow.heartrecreation.ui.order.adapter.ReasonAdapter
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ComplaintBean
import com.example.shadow.heartrecreation.ui.order.mvp.bean.ReasonBean
import com.example.shadow.heartrecreation.ui.order.mvp.body.ComplaintBody
import com.example.shadow.heartrecreation.ui.order.mvp.body.ReasonBody
import com.example.shadow.heartrecreation.ui.order.mvp.presenter.ComplaintPresenter
import com.example.shadow.heartrecreation.ui.order.mvp.view.ComplaintView
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.CameraSelect
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.activity_complaint.*
import kotlinx.android.synthetic.main.layout_title.*
import java.io.File

class ComplaintActivity:BaseActivity(), TextWatcher, CameraSelect.CameraSelectFace,ComplaintView, QiniuView {
    override fun sendSucceedImage(fileUrlList: ArrayList<String>) {
        var imageUrl = "http://pic.bixinyule.com/" + fileUrlList.get(0)
        LogUtils.a("图片地址" + imageUrl)

        if (map.size==2){
            add_pic_complaint.visibility=View.GONE
        }
        if (complaint_layout1.visibility==View.GONE){
            complaint_layout1.visibility=View.VISIBLE
            ImageLoad.setImage(imageUrl,complaint_img1)
            map.put(1,imageUrl)
        }else if (complaint_layout2.visibility==View.GONE){
            complaint_layout2.visibility=View.VISIBLE
            ImageLoad.setImage(imageUrl,complaint_img2)
            map.put(2,imageUrl)
        }else if (complaint_layout3.visibility==View.GONE){
            complaint_layout3.visibility=View.VISIBLE
            ImageLoad.setImage(imageUrl,complaint_img3)
            map.put(3,imageUrl)
        }
        if (!file!!.exists()) {
            return
        } else {
//            file!!.delete()
            deletePic(file!!.absolutePath)
        }

    }

    override fun sendFileErrorImage() {

    }

    override fun returnCameraImageList(list: java.util.ArrayList<String>) {
        if (list!=null&&list.size>0) {
            qiniuPresenter.setImage(list)
            file = File(list[0])
        }
    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (s!!.length >= 500) {
            ToastUtils.showShort("当前输入内容不能超过500字")
        }
        complaint_num.setText("${s!!.length}/500字")
    }

    private val presenter by lazy { ComplaintPresenter(this,this,this) }
    private val qiniuPresenter by lazy { QiniuPresenter(this, this, this) }

    private var reasonId=""
    private var orderServiceNo=""
    private var map=HashMap<Int,String>()
    private var cameraSelect = CameraSelect(this)
    private var file: File?=null

    override fun openEventBus(): Boolean =false

    override fun getActivityLayout(): Int =R.layout.activity_complaint

    override fun setActivityTitle() {
        titleText.text="投诉"
        titleLeft.setImageResource(R.mipmap.icon_close)
    }

    override fun initActivityData() {
        cameraSelect.initSingleCameraSdk(this)
        orderServiceNo=intent.getStringExtra("orderServiceNo")
        presenter.getReason(ReasonBody(orderServiceNo))
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        complaint_context.addTextChangedListener(this)

        Click.viewClick(add_pic_complaint).subscribe {
            cameraSelect.openCamera()
        }
        Click.viewClick(complaint_cancel1).subscribe {
            map.remove(1)
            complaint_layout1.visibility=View.GONE
        }
        Click.viewClick(complaint_cancel2).subscribe {
            map.remove(2)
            complaint_layout2.visibility=View.GONE
        }
        Click.viewClick(complaint_cancel3).subscribe {
            map.remove(3)
            complaint_layout3.visibility=View.GONE
        }

        Click.viewClick(btn_complaint).subscribe {
            if (complaint_context.text.toString().length > 0&&reasonId!="") {
                if (map.size>0) {
                    var list = ArrayList<String>()
                    map.values.forEach {
                        list.add(it)
                    }
                    presenter.getComplaint(ComplaintBody(orderServiceNo, reasonId, complaint_context.text.toString(), list))
                }else{
                    presenter.getComplaint(ComplaintBody(orderServiceNo, reasonId, complaint_context.text.toString(), null))
                }
            } else if (reasonId==""){
                ToastUtils.showShort("请选择投诉理由")
            }else{
                ToastUtils.showShort("请输入投诉内容")
            }
        }

    }

    override fun getReasonRequest(data: ReasonBean) {
        if (data.data!=null&&data.data.size>0){
            var reasonAdapter=ReasonAdapter(data.data)
            var manager = LinearLayoutManager(this)
            manager.orientation = LinearLayout.VERTICAL
            recy_complaint.layoutManager=manager
            recy_complaint.adapter=reasonAdapter

            reasonAdapter.setOnItemChildClickListener { adapter, view, position ->
                reasonAdapter.data.forEachIndexed { index, dataBean ->
                    if (index==position){
                        dataBean.isFlag=true
                        reasonId=dataBean.reasonId.toString()
                    }else{
                        dataBean.isFlag=false
                    }
                }
                reasonAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun getComplaintRequest(data: ComplaintBean) {
        Toast.Tips("投诉成功")
        finish()
    }

    override fun getComplaintError() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        cameraSelect.onActivityCameraResult(requestCode, resultCode, data)
    }

    private fun deletePic(path:String){
        if(!TextUtils.isEmpty(path)){
            val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val contentResolver = this.getContentResolver()//cutPic.this是一个上下文
//            val url =  MediaStore.Images.Media.DATA + "='" + path + "'"
//            //删除图片
//            contentResolver.delete(uri, url, null)
            val url =  MediaStore.Images.Media.DATA + "=?"
            //删除图片
            contentResolver.delete(uri, url, arrayOf(path))
        }
    }
}