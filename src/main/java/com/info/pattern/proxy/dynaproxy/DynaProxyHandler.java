package com.info.pattern.proxy.dynaproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-14 下午 6:24
 **/
@Slf4j
public class DynaProxyHandler implements InvocationHandler {

    private Object target;//被代理对象

    public void setTarget(Object target) {

        this.target = target;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("执行开始时间:" + new Date());

        Object result = method.invoke(target, args);

        log.info("执行结束时间:" + new Date());

        return result;//返回method执行结果
    }
}
