package com.info.streamApi.lambda;

import java.util.Arrays;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-16 上午 9:11
 **/
public class Lambda {

    public static void main(String[] args) {
        simpleExample();
    }

    private static void simpleExample() {
        Arrays.asList( "a", "b", "d").forEach(e -> System.out.println( e ) );
        Arrays.asList( "a", "b", "d").forEach( ( String e ) -> System.out.println( e ) );

        String separator = ",";
        // Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）
        Arrays.asList( "a", "b", "d").forEach(( String e ) -> System.out.print( e + separator ) );
        // Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。如果lambda的函数体只有一行的话，那么没有必要显式使用return语句。下面两个代码片段是等价的：
        Arrays.asList( "a", "b", "d").sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        Arrays.asList( "a", "b", "d").sort( ( e1, e2 ) -> {

            int result = e1.compareTo( e2 );

            return result;

        } );
    }
}
