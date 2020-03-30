package com.example.shadow.heartrecreation.ui.test.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.image.ImageInfo
import com.example.shadow.heartrecreation.ui.test.util.Person
import com.example.shadow.heartrecreation.utils.banner.BannerUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.z_activity_swimming_details.*

class SwimmingDetailsActivity:BaseActivity(){

    private var list=ArrayList<Person>()
    private var id=0
    private var info:Person?=null

    override fun onSavedInstanceState(bundle: Bundle?) {
        super.onSavedInstanceState(bundle)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView = window.decorView
            val option = ( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            decorView.systemUiVisibility = option
            window.navigationBarColor = Color.TRANSPARENT
            window.statusBarColor = Color.TRANSPARENT
        }
        val actionBar = getSupportActionBar()
        actionBar!!.hide()
        nac_layout.alpha = 0.toFloat()
        nac_root.setFadingView(nac_layout)
        nac_root.setFadingHeightView(detailsBanner)
    }

    override fun openEventBus(): Boolean =false

    override fun getActivityLayout(): Int =R.layout.z_activity_swimming_details

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        initPerson()
        id=intent.getIntExtra("id",0)

        list.forEach {
            if (it.id==id){
                info=it
            }
        }
        if (info!=null) {
            screenName.setText(info!!.name)
            serveFans.setText("接单数:0 \n粉丝:0 ")
            serveAge.text="${info!!.age}"
            if (info!!.sex==1){
                serveSex.text="男"
            }else{
                serveSex.text="女"
            }
            var imagelist = java.util.ArrayList<ImageInfo>()

            info!!.images.forEach { imagelist.add(ImageInfo(it, false, 2)) }
            BannerUtils().setBanner(detailsBanner, imagelist)
            occupationName.setText(info!!.occ)
            Click.viewClick(detailsYue).subscribe {
                showLoading()
                Toast.Tips("邀请成功")
                finish()
                dismissLoading()
            }
        }

    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }

    fun initPerson(){
        var list1=ArrayList<String>()
        list1.add("http://pic1.win4000.com/pic/4/9b/d9e57869f6.jpg")
        list1.add("http://pic1.win4000.com/pic/4/9b/77cbefd82b.jpg")
        list1.add("http://pic1.win4000.com/pic/4/9b/bdf864567c.jpg")
        list1.add("http://pic1.win4000.com/pic/4/9b/59ef339334.jpg")
        list1.add("http://pic1.win4000.com/pic/4/9b/c417a71e7b.jpg")
        list1.add("http://pic1.win4000.com/pic/4/9b/14f47fbe3a.jpg")
        list.add(Person(0,"伊芙甜甜",2,22,"人事","1200","http://pic1.win4000.com/pic/4/9b/14f47fbe3a_250_350.jpg",list1))

        var list2=ArrayList<String>()
        list2.add("http://pic1.win4000.com/pic/b/20/ad5a2e0042.jpg")
        list2.add("http://pic1.win4000.com/pic/b/20/802b1f2238.jpg")
        list2.add("http://pic1.win4000.com/pic/b/20/2de6d4a808.jpg")
        list2.add("http://pic1.win4000.com/pic/b/20/6c899cf402.jpg")
        list2.add("http://pic1.win4000.com/pic/b/20/16eb25ff4c.jpg")
        list2.add("http://pic1.win4000.com/pic/b/20/b42b4ca4c5.jpg")
        list.add(Person(1,"秋秋哦",2,19,"驻唱","1500","http://pic1.win4000.com/pic/b/20/ad5a2e0042.jpg",list2))

        var list3=ArrayList<String>()
        list3.add("http://pic1.win4000.com/pic/4/74/bc1d1521006.jpg")
        list3.add("http://pic1.win4000.com/pic/4/74/bc1d1521010.jpg")
        list3.add("http://pic1.win4000.com/pic/4/74/bc1d1521011.jpg")
        list3.add("http://pic1.win4000.com/pic/4/74/bc1d1521012.jpg")
        list3.add("http://pic1.win4000.com/pic/4/74/bc1d1521013.jpg")
//        list3.add("http://pic1.win4000.com/pic/b/20/b42b4ca4c5.jpg")
        list.add(Person(2,"╰ 沐子",2,21,"大学生","1350","http://pic1.win4000.com/pic/4/74/bc1d1521016_250_350.jpg",list3))

        var list4=ArrayList<String>()
        list4.add("http://pic1.win4000.com/pic/3/1e/b5275d9286.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/f2def9ff1d.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/0fdbde05bf.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/9091568770.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/ccf0fdcafc.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/fc345d34b2.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/d7e1925205.jpg")
        list4.add("http://pic1.win4000.com/pic/3/1e/3c24496601.jpg")
        list.add(Person(3,"只倾心不倾城",2,24,"上班族","1800","http://pic1.win4000.com/pic/3/1e/fc345d34b2_250_350.jpg",list4))

        var list5=ArrayList<String>()
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311484.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311485.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311486.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311487.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311488.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311489.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311490.jpg")
        list5.add("http://pic1.win4000.com/pic/4/c1/c6fd1311491.jpg")
        list.add(Person(4,"女神大人",2,27,"律师","2000","http://pic1.win4000.com/pic/4/c1/c6fd1311487_250_350.jpg",list5))
    }

}