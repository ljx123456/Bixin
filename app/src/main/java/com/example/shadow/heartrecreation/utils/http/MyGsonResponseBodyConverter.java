/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.shadow.heartrecreation.utils.http;


import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.example.shadow.heartrecreation.utils.http.CodeException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import static okhttp3.internal.Util.UTF_8;

final class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    MyGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {

        int code = 0;
        String msg = null;
        JSONObject jsonObject;
        String response = value.string();
        ErrorDrinks data=null;

        try {
            jsonObject = new JSONObject(response);
            code = jsonObject.getInt("code");
            msg = jsonObject.getString("message");
//            LogUtils.a("测试错误code："+code);
//            if (code==-3030){
//                JSONArray str=jsonObject.getJSONArray("data");
//                String s=str.getJSONObject(0).getString("wines");
//                LogUtils.a("测试错误："+s);
//                data=JSON.parseObject(s,ErrorDrinks.class);
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MediaType mediaType = value.contentType();
        Charset charset = mediaType != null ? mediaType.charset(UTF_8) : UTF_8;
        InputStream inputStream = new ByteArrayInputStream(response.getBytes());
        JsonReader jsonReader = gson.newJsonReader(new InputStreamReader(inputStream, charset));

        if (code != 0 && code != -1101) {
            value.close();
            throw new CodeException(code, msg,data);
        }

        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
//            inputStream.close();
        }
    }
}
