package com.loser;


import com.loser.core.annotation.GetMapping;
import com.loser.core.annotation.PathVariable;
import com.loser.core.annotation.PostMapping;
import com.loser.core.annotation.RequestBody;
import com.loser.core.annotation.RequestParam;
import com.loser.core.annotation.RequestRetry;
import com.loser.core.annotation.RequestRollBack;
import com.loser.core.annotation.RestFulClient;
import com.loser.entity.BaseResult;
import com.loser.entity.Pic;
import com.loser.entity.PicResult;
import com.loser.entity.QQ;
import com.loser.entity.QQResult;
import com.loser.entity.ReqBodyType;

import java.io.File;
import java.util.List;
import java.util.Map;

@RestFulClient(host = "https://api.oioweb.cn", timeOut = 10000)
@RequestRetry(retryNum = 2, sleepTime = 50)
@RequestRollBack(rollBack = ProxyServiceRollBack.class)
public interface ProxyService {

    @GetMapping("/api/common/teladress/{test}")
    String getInfoByPhone(@RequestParam("mobile") String mobile, @PathVariable("test") String test);

    @GetMapping(value = "/api/qq/info", timeOut = 500, headers = {"anchor=loser"})
    QQResult getInfoByQQ(@RequestParam("qq") String qq);

    @PostMapping("/test/json")
    String getByJson(@RequestBody Map<String, Object> req);

    @PostMapping(value = "/api/ocr/recognition", timeOut = 60000, bodyType = ReqBodyType.FORM)
    PicResult checkPick(@RequestBody Map<String, File> req);

    @GetMapping(value = "/api/qq/info", timeOut = 500, headers = {"anchor=loser"})
    BaseResult<QQ> getInfoByQQ2(@RequestParam("qq") String qq);

    @PostMapping(value = "/api/ocr/recognition", timeOut = 10000, bodyType = ReqBodyType.FORM)
    BaseResult<List<Pic>> recognition(@RequestBody Map<String, File> body);

}
