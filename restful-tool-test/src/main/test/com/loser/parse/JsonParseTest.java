package com.loser.parse;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.loser.entity.BaseResult;
import com.loser.entity.Pic;
import com.loser.entity.QQ;
import com.loser.entity.QQResult;
import com.loser.utils.JsonUtil;
import org.junit.Test;

import java.util.List;


public class JsonParseTest {

    @Test
    public void testByObj() throws Throwable {

        String json = "{\"code\":200,\"msg\":\"success\",\"result\":{\"age\":39,\"area\":\"\",\"nickname\":\"Loser\",\"sex\":\"male\",\"user_id\":1500162516}}\n";
        TypeReference<QQResult> listTypeReference = new TypeReference<QQResult>() {
        };
        QQResult res = JsonUtil.parse(json, listTypeReference.getType());
        System.out.println(res.getClass());
        System.out.println(JSONObject.toJSONString(res.getResult()));
        System.out.println(JSONObject.toJSONString(res));

    }

    @Test
    public void testTByObj() throws Throwable {

        String json = "{\"code\":200,\"msg\":\"success\",\"result\":{\"age\":39,\"area\":\"\",\"nickname\":\"Loser\",\"sex\":\"male\",\"user_id\":1500162516}}";
        TypeReference<BaseResult<QQ>> listTypeReference = new TypeReference<BaseResult<QQ>>() {
        };
        BaseResult<QQ> res = JsonUtil.parse(json, listTypeReference.getType());
        System.out.println(JSONObject.toJSONString(res.getResult()));
        System.out.println(res.getResult().getClass());
        System.out.println(JSONObject.toJSONString(res));

    }


    @Test
    public void testTByList() throws Throwable {

        String json = "{\"code\":200,\"msg\":\"获取成功\",\"result\":[{\"name\":\"卡通动漫人物\",\"root\":\"非自然图像-彩色动漫\",\"score\":0.390754},{\"name\":\"军装服\",\"root\":\"商品-服装\",\"score\":0.277825},{\"name\":\"光头强\",\"root\":\"非自然图像-彩色动漫\",\"score\":0.188484},{\"name\":\"军人\",\"root\":\"人物-人物特写\",\"score\":0.096034},{\"name\":\"屏幕截图\",\"root\":\"非自然图像-屏幕截图\",\"score\":0.006926}]}";
        TypeReference<BaseResult<List<Pic>>> listTypeReference = new TypeReference<BaseResult<List<Pic>>>() {
        };
        BaseResult<List<Pic>> res = JsonUtil.parse(json, listTypeReference.getType());
        System.out.println(JSONObject.toJSONString(res.getResult()));
        System.out.println(res.getResult().getClass());
        System.out.println(JSONObject.toJSONString(res));

    }


}