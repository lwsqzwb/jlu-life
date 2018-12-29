package com.jlulife.zhangwenbin.mainpage.network;

import com.jlulife.zhangwenbin.jlu_repo.request.BodyUtil;
import com.jlulife.zhangwenbin.netapi.listener.IRequestListener;
import com.jlulife.zhangwenbin.netapi.request.ApiRequest;

public class NetAPI {

    public static void requestMsg(IRequestListener listener){
        ApiRequest request = new ApiRequest("http://www.zwbnew.xin/web03/g.json");
        request.setRequestBody(BodyUtil.createScoreBody())
        .addHead("Content-Type","application/json; charset=utf-8")
        .enqueueRequest(listener);
    }

}
