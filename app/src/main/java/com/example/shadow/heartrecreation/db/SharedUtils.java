package com.example.shadow.heartrecreation.db;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedUtils {
    private static String fileName="tag";//共享参数文件名字
    public static void saveTag( Context context){
        SharedPreferences sp=context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean("tag",true);//存入标签值true
        editor.commit();
    }

    public static boolean getTag(Context context){
        SharedPreferences sp=context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getBoolean("tag",false);//没取到默认值是false
    }
}
