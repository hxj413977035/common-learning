package com.info.pattern.calculate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-03 下午 4:39
 **/
public class Calculate {

    public static void main(String[] args) {
        int[] list = {1, 2, 10, 89, 100, 1000, -1, -89};
        // 求最大值
//        求最大值(list);
        // 排序
    }


    private static void 求最大值(int[] list) {

        Integer max = list[0];
        for (Integer item : list) {
            if (item > max) {
                max = item;
            }
        }
        System.out.println("最大值为 ： " + max);
    }



}
