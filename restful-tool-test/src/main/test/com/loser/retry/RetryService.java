package com.loser.retry;


import com.loser.core.annotation.PostMapping;
import com.loser.core.annotation.RequestBody;
import com.loser.core.annotation.RequestRetry;
import com.loser.core.annotation.RestFulClient;
import com.loser.entity.BaseResult;
import com.loser.entity.Pic;
import com.loser.entity.ReqBodyType;

import java.io.File;
import java.util.List;
import java.util.Map;

@RestFulClient(host = "https://api.oioweb.cn")
public interface RetryService {

    @RequestRetry(retryNum = 5, sleepTime = 200)
    @PostMapping(value = "/api/ocr/recognition", timeOut = 100, bodyType = ReqBodyType.FORM)
    BaseResult<List<Pic>> recognition(@RequestBody Map<String, File> body);

}
