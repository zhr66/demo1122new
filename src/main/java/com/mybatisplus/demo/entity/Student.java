package com.mybatisplus.demo.entity;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private int age;

    public  Student(){}

    public Student(Integer id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    /*public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }*/
}
