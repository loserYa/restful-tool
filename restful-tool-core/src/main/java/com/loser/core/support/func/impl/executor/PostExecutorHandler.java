package com.loser.core.support.func.impl.executor;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.alibaba.fastjson2.JSONObject;
import com.loser.entity.ReqBody;
import com.loser.entity.ReqBodyType;
import com.loser.entity.ReqHead;
import com.loser.entity.ReqMethod;
import com.loser.entity.RequestUrl;
import com.loser.entity.TimeOut;

public class PostExecutorHandler implements RestFulRequestMethod {

    @Override
    public ReqMethod getMethod() {
        return ReqMethod.POST;
    }

    @Override
    public String executor(ReqMethod reqMethod, RequestUrl requestUrl, TimeOut timeOut, ReqHead reqHead, ReqBody reqBody) {

        HttpRequest request = HttpUtil.createRequest(Method.POST, requestUrl.getUrl());
        ReqBodyType type = reqBody.getType();
        if (type == ReqBodyType.JSON) {
            request.body(JSONObject.toJSONString(reqBody.getBody()));
        }
        if (type == ReqBodyType.FORM) {
            request.form(reqBody.getBody());
        }
        return request.headerMap(reqHead.getHeads(), true).timeout(timeOut.getTimeOut()).execute().body();

    }

}
