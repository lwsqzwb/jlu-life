package com.jlulife.zhangwenbin.netapi.request;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.jlulife.zhangwenbin.netapi.listener.IRequestListener;
import com.jlulife.zhangwenbin.netapi.result.ResponseData;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiManager {

    private volatile OkHttpClient mOkHttpClient;
    private InnerHandler mInnerHandler;

    public ApiManager(){
        mOkHttpClient = new OkHttpClient.Builder()
                .build();

        //.dns(new Dns() {
        //                    @NonNull
        //                    @Override
        //                    public List<InetAddress> lookup(@NonNull String hostname) throws UnknownHostException {
        //                        return Arrays.asList(InetAddress.getAllByName("10.60.65.8"));
        //                    }
        //                })
        mInnerHandler = new InnerHandler();
    }

    private static class InnerHandler extends Handler{
        public InnerHandler(){
            super(Looper.getMainLooper());
        }
    }

    private static class ApiManagerHolder{
        private static ApiManager Instance = new ApiManager();
    }

    public static ApiManager getInstance(){
        return ApiManagerHolder.Instance;
    }

    public void enqueueRequest(Request request, final IRequestListener requestListener){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                final ResponseData responseData = new ResponseData();
                mInnerHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        requestListener.fail(responseData);
                    }
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final ResponseData responseData = new ResponseData();
                if (response.body() != null) {
                    responseData.setData(response.body().string());
                }
                mInnerHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        requestListener.success(responseData);
                    }
                });
            }
        });
    }


}
