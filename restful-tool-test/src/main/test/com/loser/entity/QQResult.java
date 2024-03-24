/**
 * Copyright 2024 json.cn
 */
package com.loser.entity;

public class QQResult {

    private int code;
    private QQ QQ;
    private String msg;

    public QQResult() {
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setResult(QQ QQ) {
        this.QQ = QQ;
    }

    public QQ getResult() {
        return QQ;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "QQResult{" +
                "code=" + code +
                ", result=" + QQ +
                ", msg='" + msg + '\'' +
                '}';
    }
}