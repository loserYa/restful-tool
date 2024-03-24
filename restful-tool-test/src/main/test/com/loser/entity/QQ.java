package com.loser.entity;

public class QQ {

    private long user_id;
    private String nickname;
    private String sex;
    private int age;
    private String area;

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Result{" +
                "user_id=" + user_id +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", area='" + area + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

}