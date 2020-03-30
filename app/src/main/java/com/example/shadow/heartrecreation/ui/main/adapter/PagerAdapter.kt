package com.example.shadow.heartrecreation.ui.main.adapter

import android.content.Context
import android.graphics.Color
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MainBean
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.ui.main.view.BannerView
import com.example.shadow.heartrecreation.ui.test.util.intentUtils
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast

class PagerAdapter(var list: MutableList<MainBean.DataBean.ShowBean>, var mContext: Context, var views: BannerView) : PagerAdapter() {


    override fun isViewFromObject(view: View, objects: Any): Boolean {
        return view == objects
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(mContext).inflate(R.layout.item_main_context_banner, null)
        var mainContextType = view.findViewById<TextView>(R.id.mainContextType)
        var mainTypeImage = view.findViewById<ImageView>(R.id.mainTypeImage)
        var mainContextImage = view.findViewById<ImageView>(R.id.mainContextImage)
        var mainContextGo = view.findViewById<TextView>(R.id.mainContextGo)
//        list.forEach { ImageLoad.setImage(it, mainContextImage) }
        mainContextType.setText(list.get(position).typeDescride)
        ImageLoad.setImage(list.get(position).typePhoto, mainTypeImage)
        ImageLoad.setImage(list.get(position).showPhoto, mainContextImage)
        mainContextGo.setText(list.get(position).showName)
        when(list.get(position).typeId){
            1 -> mainContextGo.setBackgroundColor(Color.parseColor("#FE849B"))
            2 -> mainContextGo.setBackgroundColor(Color.parseColor("#84CEFE"))
            3 -> mainContextGo.setBackgroundColor(Color.parseColor("#FEA984"))
        }
//        if (list.get(position).state == 1) mainContextGo.setBackgroundColor(Color.parseColor("#FE849B"))
//        else mainContextGo.setBackgroundColor(Color.parseColor("#999999"))
        Click.viewClick(mainContextGo).subscribe {
            if (list.get(position).state == 1) {
                user.setYueName(list.get(position).showName)
                user.setYueID(list.get(position).typeId.toString())
                intentUsils.intentYue(0)
//                views.OnClickListener(list.get(position))
            }
                //为了应付傻逼小米应用市场审核
//            else if (list.get(position).typeId==2){
//                intentUtils.intentSwimming()
//            }
//              else if (list.get(position).typeId==3){
//                list.get(3)
//                intentUtils.intentMountain()
//            }

            else {
                Toast.Tips("该功能暂未开放,敬请期待")
            }
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}