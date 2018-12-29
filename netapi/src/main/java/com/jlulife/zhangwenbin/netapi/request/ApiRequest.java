package com.jlulife.zhangwenbin.netapi.request;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.jlulife.zhangwenbin.netapi.listener.IRequestListener;

import okhttp3.Request;
import okhttp3.RequestBody;

public class ApiRequest {

    private Request.Builder mRequestBuilder;

    public ApiRequest(@NonNull String url){
        mRequestBuilder = new Request.Builder();
        mRequestBuilder.url(url);
    }

    public void enqueueRequest(IRequestListener requestListener){
        ApiManager.getInstance().enqueueRequest(mRequestBuilder.build(),requestListener);
    }

    public ApiRequest setRequestBody(String requestBody){
        if (!TextUtils.isEmpty(requestBody)){
            mRequestBuilder.post(RequestBody.create(null,requestBody));
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
