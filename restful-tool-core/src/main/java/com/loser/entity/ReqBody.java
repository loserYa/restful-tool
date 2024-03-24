package com.loser.entity;

import java.util.Map;

public class ReqBody {

    private ReqBodyType type = ReqBodyType.NONE;

    private Map<String, Object> body;

    public ReqBodyType getType() {
        return type;
    }

    public void setType(ReqBodyType type) {
        this.type = type;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
