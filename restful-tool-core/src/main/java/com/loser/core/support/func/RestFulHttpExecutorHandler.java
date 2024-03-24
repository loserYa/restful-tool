package com.loser.core.support.func;

import com.loser.core.support.base.BaseRequestFunction;
import com.loser.entity.ReqBody;
import com.loser.entity.ReqHead;
import com.loser.entity.ReqMethod;
import com.loser.entity.RequestUrl;
import com.loser.entity.TimeOut;

/**
 * 请求执行器构建插件
 *
 * @author loser
 */
public interface RestFulHttpExecutorHandler extends BaseRequestFunction {

    String executor(ReqMethod reqMethod, RequestUrl requestUrl, TimeOut timeOut, ReqHead reqHead, ReqBody reqBody);

}
