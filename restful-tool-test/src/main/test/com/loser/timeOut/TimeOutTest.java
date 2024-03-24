package com.loser.timeOut;

import com.alibaba.fastjson2.JSONObject;
import com.loser.RestTestApplication;
import com.loser.entity.BaseResult;
import com.loser.entity.Pic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = RestTestApplication.class)
@Component
public class TimeOutTest {

    @Resource
    private TimeOutService timeOutService;

    @Test
    public void timeOutTest() {
        Map<String, File> body = new HashMap<>();
        body.put("file", new File("G:\\pig.png"));
        BaseResult<List<Pic>> recognition = timeOutService.recognition(body);
        System.out.println(JSONObject.toJSONString(recognition));
        System.out.println(recognition);
    }

}