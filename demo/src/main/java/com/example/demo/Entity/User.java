package com.example.demo.Entity;

import java.io.Serializable;

/**
 * <p>文档描述：</p>
 *
 * @Author User
 * @Date 2021/4/9 0009 下午 3:55
 * @Version 1.0
 */
public class User{
     private String name;
     private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
