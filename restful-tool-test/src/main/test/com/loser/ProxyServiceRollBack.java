package com.loser;


import com.loser.entity.BaseResult;
import com.loser.entity.Pic;
import com.loser.entity.PicResult;
import com.loser.entity.QQ;
import com.loser.entity.QQResult;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ProxyServiceRollBack implements ProxyService {

    @Override
    public String getInfoByPhone(String mobile, String test) {
        return "404";
    }

    @Override
    public QQResult getInfoByQQ(String qq) {
        return new QQResult();
    }

    @Override
    public String getByJson(Map<String, Object> req) {
        return "404";
    }

    @Override
    public PicResult checkPick(Map<String, File> req) {
        return new PicResult();
    }

    @Override
    public BaseResult<QQ> getInfoByQQ2(String qq) {
        return new BaseResult<>();
    }

    @Override
    public BaseResult<List<Pic>> recognition(Map<String, File> body) {
        return new BaseResult<>();
    }

}
