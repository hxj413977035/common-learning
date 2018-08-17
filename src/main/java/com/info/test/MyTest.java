package com.info.test;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-13 上午 11:55
 **/
public class MyTest {
    public static void main(String[] args) {
        Integer a = 0;

        System.out.println(a == 0);
        System.out.println(a.equals(0));

        int i = 0;
        System.out.println(++i);
        System.out.println(i++);
        int d = i ++;
        System.out.println("c = " + d);
        System.out.println("i = " + i);
        System.out.println("00000000000000000000");
//        int d = i ++;
//        System.out.println(c);
//        System.out.println(d);
//        System.out.println(c + d);
    }

}
