package com.jlulife.zhangwenbin.mainpage.network;

import com.jlulife.zhangwenbin.netapi.listener.IRequestListener;
import com.jlulife.zhangwenbin.netapi.request.ApiRequest;

public class NetAPI {

    public static void requestMsg(IRequestListener listener){
        ApiRequest request = new ApiRequest("http://www.zwbnew.xin/web03/g.json");
        request.enqueueRequest(listener);
    }

}
