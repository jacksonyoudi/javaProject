package com.jackson.gof.prototype;

import java.io.Serializable;
import java.util.Date;

public class Sheep implements Cloneable, Serializable {
    private String name;
    private Date birthday;

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();  // 直接调用c的克隆方法
        return obj;
    }
}
