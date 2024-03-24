package com.loser.core.support.func.impl.executor;

import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.loser.entity.ReqBody;
import com.loser.entity.ReqHead;
import com.loser.entity.ReqMethod;
import com.loser.entity.RequestUrl;
import com.loser.entity.TimeOut;

public class DeleteExecutorHandler implements RestFulRequestMethod {

    @Override
    public ReqMethod getMethod() {
        return ReqMethod.DELETE;
    }

    @Override
    public String executor(ReqMethod reqMethod, RequestUrl requestUrl, TimeOut timeOut, ReqHead reqHead, ReqBody reqBody) {
        return HttpUtil.createRequest(Method.DELETE, requestUrl.getUrl()).timeout(timeOut.getTimeOut()).headerMap(reqHead.getHeads(), true).execute().body();
    }

}
