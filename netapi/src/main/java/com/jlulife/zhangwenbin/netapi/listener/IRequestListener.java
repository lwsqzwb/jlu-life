package com.jlulife.zhangwenbin.netapi.listener;

import com.jlulife.zhangwenbin.netapi.result.ResponseData;

public interface IRequestListener {

    void success(ResponseData responseData);

    void fail(ResponseData responseData);

}
