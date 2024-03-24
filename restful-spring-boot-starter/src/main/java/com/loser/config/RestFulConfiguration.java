package com.loser.config;

import com.loser.core.cglib.AnnoCglibProxyCreator;
import com.loser.core.support.aop.RestFulCglibPluginReplaceHandler;
import com.loser.core.support.aop.RestFulJdkProxyHandler;
import com.loser.core.support.bean.RestFulPluginHandler;
import com.loser.util.CamelCaseConverter;
import org.springframework.context.annotation.Bean;

/**
 * 自动配置
 *
 * @author loser
 */
public class RestFulConfiguration {

    @Bean
    public RestFulJdkProxyHandler restFulJdkProxyHandler() {
        return new RestFulJdkProxyHandler();
    }

    @Bean
    public RestFulPluginHandler restFulPluginHandler(AnnoCglibProxyCreator annoCglibProxyCreator) {

        RestFulPluginHandler handler = new RestFulPluginHandler();
        String beanName = CamelCaseConverter.toLowerCamelCase(handler.getClass().getSimpleName());
        return (RestFulPluginHandler) annoCglibProxyCreator.wrapIfNecessary(handler, beanName, beanName);

    }

    @Bean
    public RestFulCglibPluginReplaceHandler restFulCglibPluginReplaceHandler() {
        return new RestFulCglibPluginReplaceHandler();
    }

}
