package com.info.pattern.proxy.dynaproxy;

import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-14 下午 6:27
 **/
public class DynaProxyFactory {

    //obj为被代理对象

    public static Object getProxy(Object obj) {

        DynaProxyHandler handler = new DynaProxyHandler();

        handler.setTarget(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);

    }
}
