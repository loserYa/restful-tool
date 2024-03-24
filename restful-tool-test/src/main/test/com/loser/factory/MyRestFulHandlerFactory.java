package com.loser.factory;

import com.loser.core.support.base.BaseRestFulHandlerFactory;
import com.loser.core.support.bean.RestFulHandlerFactory;
import com.loser.entity.RestFulFunction;
import com.loser.hardcode.Constant;
import org.springframework.stereotype.Component;

@Component(Constant.BEAN.FACTORY)
public class MyRestFulHandlerFactory implements BaseRestFulHandlerFactory {

    RestFulHandlerFactory factory = new RestFulHandlerFactory();

    @Override
    public RestFulFunction getInstance() {
        System.out.println("user my plugin");
        return factory.getInstance();
    }

}
