package com.info.streamApi;

import com.info.pojo.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-01 上午 9:28
 **/
public class StreamApiDemo {

    public static void main(String[] args) {
//        learnSream();
//        learningStream();
        testCompartor();
    }


    private static void learnSream() {
        // 创建一个1-6乱序的List
        List<Integer> lists = new ArrayList<>(8);
        lists.add(6);
        lists.add(2);
        lists.add(3);
        lists.add(5);
        lists.add(4);
        lists.add(1);
        lists.forEach(e -> System.out.println(e));
        System.out.println("---------------------------");
        // 获取最小值
        System.out.println("lists中最小值为：");
        Optional<Integer> min = lists.stream().min(Integer::compareTo);
        if (min.isPresent()) {
            System.out.println(min.get());
        }
        System.out.println("---------------------------");
        // 获取最大值
        System.out.println("lists中最大值为：");
        lists.stream().max(Integer::compareTo).ifPresent(System.out::print);
        System.out.println();
        System.out.println("---------------------------");
        // 排序
        System.out.println("lists排序后：");
        List<Integer> list = new ArrayList<>(lists.size());
        lists.stream().sorted().forEach(e -> {
            list.add(e);
            System.out.println(e);
        });
        System.out.println("---------------------------");
        list.forEach(l -> System.out.println(l));
        // 过滤list
        System.out.println("过虑lists，只留下大于3的元素：");
        lists.stream().filter(e -> e > 3).forEach(e -> System.out.println(e));
        System.out.println("---------------------------");
        System.out.println("过虑lists，只留下大于0且小于4的元素：");
        lists.stream().filter(e -> e > 0).filter(e -> e < 4).forEach(e -> System.out.println(e));
        System.out.println("---------------------------");
        System.out.println("原lists中数据：");
        lists.forEach(e -> System.out.println(e));

    }


    public static void learningStream() {
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(6);

        Optional<Integer> sum = lists.stream().reduce((a, b) -> a + b);
        if (sum.isPresent()) {
            System.out.println("lists总合为：" + sum.get());
        }

        lists.stream().reduce((a, b) -> a + b).ifPresent(System.out::print);

        Integer sum2 = lists.stream().reduce(0, (a, b) -> a + b);
        System.out.println("list的总和为:" + sum2);

        Optional<Integer> product = lists.stream().reduce((a, b) -> a * b);
        if (product.isPresent()) {
            System.out.println("list的乘积为:" + product.get());
        }

        Integer reduce1 = lists.stream().reduce(1, (a, b) -> a * b);
        System.out.println("list的乘积为:" + reduce1);

    }


    public static void testCompartor() {
        List<Student> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            Student s = new Student();
            s.setId(i);
            s.setAge(String.valueOf(i * 2));
            s.setName("张" + i);
            list.add(s);
        }
        Optional<Student> min = list.stream().max(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        Student sss = null;
        if (min.isPresent()) {
            sss = min.get();
        }
        System.out.println(sss.toString());
    }
}
