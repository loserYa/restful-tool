package com.loser.plugin;

import com.alibaba.fastjson2.JSONObject;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class MyRestConverterHandlerInPlugin implements RestConverterHandlerInPlugin {

    @Override
    public Object converter(Object target, Object res, MethodInvocation methodInvocation) throws Throwable {

        System.out.println("user my plugin");
        System.out.println(JSONObject.toJSONString(res));
        Object proceed = methodInvocation.proceed();
        System.out.println(JSONObject.toJSONString(proceed));
        return proceed;

    }

}
