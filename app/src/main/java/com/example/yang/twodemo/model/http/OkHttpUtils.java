package com.example.yang.twodemo.model.http;

import android.os.Looper;

import com.example.yang.twodemo.model.callback.NetWorkCallback;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class OkHttpUtils implements IHttp {
    private static OkHttpUtils okHttpUtils;
    private final OkHttpClient httpClient;

    private OkHttpUtils(){

        httpClient = new OkHttpClient.Builder().build();
    }
    public static OkHttpUtils getInstance(){
        if (okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                if (okHttpUtils==null){
                    okHttpUtils=new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }

    @Override
    public <T> void doGet(String url, final NetWorkCallback<T> callback) {

        Request request = new Request.Builder().url(url).build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                T t = parseData(result, callback);
                Looper.prepare();
                callback.onSuccess(t);
                Looper.loop();
            }
        });
    }



    @Override
    public <T> void doPost(String url, Map<String, String> params, final NetWorkCallback<T> callback) {
        FormBody.Builder builder = new FormBody.Builder();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            String value = params.get(keys);
            builder.add(key,value);
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                T t = parseData(result, callback);
                Looper.prepare();
                callback.onSuccess(t);
                Looper.loop();
            }
        });

    }
    private <T> T parseData(String jsonData,NetWorkCallback<T> callback){

        Type[] interfacesTypes = callback.getClass().getGenericInterfaces();

        Type[] genericType2 = ((ParameterizedType) interfacesTypes[0]).getActualTypeArguments();
        Class<T> classes = (Class<T>) genericType2[0];
        Gson gson = new Gson();
        T t = gson.fromJson(jsonData, classes);
        return t;

    }
}
