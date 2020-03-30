package com.example.shadow.heartrecreation.place

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class BitMap {
    // 饿汉式
    private val instance = BitMap()

    fun getInstance(): BitMap {
        return instance
    }

    /*
    *    get image from network
    *    @param [String]imageURL
    *    @return [BitMap]image
    */
    fun returnBitMap(url: String): Bitmap? {
        var myFileUrl: URL? = null
        var bitmap: Bitmap? = null
        try {
            myFileUrl = URL(url)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }

        try {
            val conn = myFileUrl!!.openConnection() as HttpURLConnection
            conn.setDoInput(true)
            conn.connect()
            val `is` = conn.getInputStream()
            bitmap = BitmapFactory.decodeStream(`is`)
            `is`.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return bitmap
    }
}