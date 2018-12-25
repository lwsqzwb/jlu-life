package com.jlulife.zhangwenbin.netapi.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.jlulife.zhangwenbin.netapi.listener.IRequestListener;

import okhttp3.FormBody;
import okhttp3.Request;

public class ApiRequest {

    private Request.Builder mRequestBuilder;
    private FormBody.Builder mBodyBuilder;

    public ApiRequest(@NonNull String url){
        mRequestBuilder = new Request.Builder();
        mBodyBuilder = new FormBody.Builder();
        mRequestBuilder.url(url);
    }

    public void enqueueRequest(IRequestListener requestListener){
        mRequestBuilder.post(mBodyBuilder.build());
        ApiManager.getInstance().enqueueRequest(mRequestBuilder.build(),requestListener);
    }

    public ApiRequest addParam(@Nullable String key, @Nullable String value){
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)){
            mBodyBuilder.add(key, value);
        }
        return this;
    }

    public ApiRequest addHead(@Nullable String key, @Nullable String value){
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)){
            mRequestBuilder.addHeader(key, value);
        }
        return this;
    }

}
