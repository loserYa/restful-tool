package com.loser;

import com.alibaba.fastjson2.JSONObject;
import com.loser.entity.BaseResult;
import com.loser.entity.Pic;
import com.loser.entity.QQ;
import com.loser.entity.QQResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = RestTestApplication.class)
@Component
public class RestProxyTest {

    @Resource
    private ProxyService proxyService;

    /**
     * 测试入口
     */
    @Test
    public void test() throws Throwable {

        System.out.println(JSONObject.toJSONString(proxyService.getInfoByQQ("1500162516")));

        System.out.println(proxyService.getInfoByPhone("13800138000", "115"));

        Method getInfoByQQ2 = ProxyService.class.getMethod("getInfoByQQ2", String.class);

        QQResult byQQ = proxyService.getInfoByQQ("1500162516");
        System.out.println(byQQ);

        BaseResult<QQ> infoByQQ2 = proxyService.getInfoByQQ2("1500162516");

        Map<String, File> body = new HashMap<>();
        body.put("file", new File("G:\\pig.png"));
        BaseResult<List<Pic>> recognition = proxyService.recognition(body);
        System.out.println(JSONObject.toJSONString(recognition));
        System.out.println(recognition);

    }


}