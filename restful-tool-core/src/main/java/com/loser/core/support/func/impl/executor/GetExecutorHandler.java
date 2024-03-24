package com.loser.core.support.func.impl.executor;

import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.loser.entity.ReqBody;
import com.loser.entity.ReqHead;
import com.loser.entity.ReqMethod;
import com.loser.entity.RequestUrl;
import com.loser.entity.TimeOut;

public class GetExecutorHandler implements RestFulRequestMethod {

    @Override
    public ReqMethod getMethod() {
        return ReqMethod.GET;
    }

    @Override
    public String executor(ReqMethod reqMethod, RequestUrl requestUrl, TimeOut timeOut, ReqHead reqHead, ReqBody reqBody) {
        return HttpUtil.createRequest(Method.GET, requestUrl.getUrl()).headerMap(reqHead.getHeads(), true).timeout(timeOut.getTimeOut()).execute().body();
    }

}
