package com.info.pattern.proxy.staticproxy;


import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-14 下午 6:14
 **/

@Slf4j
public class PersonProxy implements IPerson {

    private IPerson person;

    public PersonProxy(IPerson person) {
        this.person = person;

    }

    @Override
    public void sleep() {
        log.info("开始执行时间:" + new Date());
        person.sleep();
        log.info("“执行结束时间:" + new Date());
    }

    @Override
    public void eating() {
        log.info("开始执行时间:" + new Date());
        person.eating();
        log.info("“执行结束时间:" + new Date());
    }
}
