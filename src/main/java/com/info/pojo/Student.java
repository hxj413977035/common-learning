package com.info.pojo;

import lombok.Data;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-15 下午 1:01
 **/

@Data
public class Student {

    private String name;

    private String age;

    private Integer id;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Student() {

    }
}
