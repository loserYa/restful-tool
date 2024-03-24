package com.loser.entity;

public class BaseResult<T> {

    private int code;
    private T result;
    private String msg;

    public BaseResult() {
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
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
                ", result=" + result +
                ", msg='" + msg + '\'' +
                '}';
    }
}