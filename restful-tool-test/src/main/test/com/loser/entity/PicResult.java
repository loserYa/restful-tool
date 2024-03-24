package com.loser.entity;

import java.util.List;

public class PicResult {

    private int code;
    private List<QQ> QQ;
    private String msg;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setResult(List<QQ> QQ) {
        this.QQ = QQ;
    }

    public List<QQ> getResult() {
        return QQ;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}