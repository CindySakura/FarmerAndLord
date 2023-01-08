package com.itheima.domain;

import java.util.Objects;

public class User {
   //自己练习
    private String uname;
    private String pw;

    public User(){}

    public User(String uname, String pw) {
        this.uname = uname;
        this.pw = pw;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uname, user.uname) && Objects.equals(pw, user.pw);
    }

}
