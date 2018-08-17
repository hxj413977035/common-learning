package com.info.timeApi;

import java.time.*;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-16 上午 9:55
 **/
public class TimeApiExample {

    public static void main(String[] args) {
        // Clock可以替换System.currentTimeMillis()与TimeZone.getDefault()
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());

        /**
         * 我们需要关注的其他类是LocaleDate与LocalTime。
         * LocaleDate只持有ISO-8601格式且无时区信息的日期部分。
         * 相应的，LocaleTime只持有ISO-8601格式且无时区信息的时间部分。
         * LocaleDate与LocalTime都可以从Clock中得到。
         *
         * Get the local date and local time
         */
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateFromClock);

        System.out.println("============华丽丽的分割线================");
        /**
         * Get the local date and local time
         */
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromLock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeFromLock);

        System.out.println("============华丽丽的分割线================");
        /**
         * LocaleDateTime把LocaleDate与LocaleTime的功能合并起来，
         * 它持有的是ISO-8601格式无时区信息的日期与时间。下面是一个快速入门的例子。
         */
        final LocalDateTime dateTime = LocalDateTime.now();
        final LocalDateTime dateTimeFromClock = LocalDateTime.now(clock);
        System.out.println(dateTime);
        System.out.println(dateTimeFromClock);

        System.out.println("============华丽丽的分割线================");
        /**
         * 如果你需要特定时区的日期/时间，那么ZonedDateTime是你的选择。
         * 它持有ISO-8601格式具具有时区信息的日期与时间。下面是一些不同时区的例子：
         *
         * Get the zoned date/time
         */
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDateTimeFromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println( zonedDateTime );
        System.out.println( zonedDateTimeFromClock );
        System.out.println( zonedDateTimeFromZone );

        /**
         * Duration类：在秒与纳秒级别上的一段时间。Duration使计算两个日期间的不同变的十分简单。下面让我们看一个这方面的例子
         *
         * Get duration between two dates
         */
        final LocalDateTime from = LocalDateTime.of(2014,Month.APRIL,16,0,0,0);
        final LocalDateTime to = LocalDateTime.of(2015,Month.APRIL,16,23,59,59);
        final Duration duration = Duration.between(from,to);
        System.out.println( "Duration in days: "+ duration.toDays() );
        System.out.println( "Duration in hours: "+ duration.toHours() );

        System.out.println("============华丽丽的分割线================");

    }
}
