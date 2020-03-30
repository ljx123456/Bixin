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

class MountaionDetailsActivity:BaseActivity(){
    private var list=ArrayList<Person>()
    private var id=0
    private var info: Person?=null

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

    override fun getActivityLayout(): Int = R.layout.z_activity_swimming_details

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
        list1.add("http://pic1.win4000.com/pic/2/eb/40cb53dba5.jpg")
        list1.add("http://pic1.win4000.com/pic/2/eb/16a7873d41.jpg")
        list1.add("http://pic1.win4000.com/pic/2/eb/2df1f174de.jpg")
        list1.add("http://pic1.win4000.com/pic/2/eb/f5bfad0547.jpg")
        list1.add("http://pic1.win4000.com/pic/2/eb/985ea7dc09.jpg")
        list1.add("http://pic1.win4000.com/pic/2/eb/414cc0bf0e.jpg")
        list.add(Person(0,"锦瑟、华年",2,26,"健身教练","1800","http://pic1.win4000.com/pic/2/eb/985ea7dc09_250_350.jpg",list1))

        var list2=ArrayList<String>()
        list2.add("http://pic1.win4000.com/pic/4/b9/f5511249470.jpg")
        list2.add("http://pic1.win4000.com/pic/4/b9/f5511249471.jpg")
        list2.add("http://pic1.win4000.com/pic/4/b9/f5511249472.jpg")
//        list2.add("http://pic1.win4000.com/pic/b/20/6c899cf402.jpg")
//        list2.add("http://pic1.win4000.com/pic/b/20/16eb25ff4c.jpg")
//        list2.add("http://pic1.win4000.com/pic/b/20/b42b4ca4c5.jpg")
        list.add(Person(1,"绾痞",2,24,"品酒师","2200","http://pic1.win4000.com/pic/4/b9/f5511249474_250_350.jpg",list2))

        var list3=ArrayList<String>()
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528879.jpg")
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528894.jpg")
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528895.jpg")
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528899.jpg")
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528901.jpg")
        list3.add("http://pic1.win4000.com/pic/5/cd/5ea71528902.jpg")
        list.add(Person(2,"雪儿",2,26,"摄影爱好者","2500","http://pic1.win4000.com/pic/5/cd/5ea71528895_250_350.jpg",list3))
    }

}