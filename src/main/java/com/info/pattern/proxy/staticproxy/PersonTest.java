package com.info.pattern.proxy.staticproxy;

import com.info.pattern.proxy.dynaproxy.DynaProxyFactory;
import com.info.pojo.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-14 下午 6:18
 **/
public class PersonTest {
    public static void main(String[] args) {
        // 静态代理
        IPerson proxy = new PersonProxy(new Person());

        proxy.eating();

        proxy.sleep();

        // 动态代理
        IPerson person = (IPerson) DynaProxyFactory.getProxy(new Person());

        //返回代理类,代理类是JVM在内存中动态创建的,该类实现传入的接口数组的全部接口(的全部方法).

        person.eating();

        person.sleep();


        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student s = new Student("张三", "李四");
            s.setId(i);
            studentList.add(s);
        }
        System.out.println(studentList.size());
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }
}
