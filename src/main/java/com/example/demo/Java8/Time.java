package com.example.demo.Java8;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;

/**
 * @Author wen
 * @Date 2018/11/21 14:58
 * @Description
 **/
public class Time {
    public static void main(String[] args) {
        String limittime = "00:15:00";
        String usetime = "00:06:00";


        Date date = DateUtil.parse(limittime, "HH:mm:ss");
        Date date1 = DateUtil.parse(usetime, "HH:mm:ss");
        long between = DateUtil.between(date, date1, DateUnit.MS);

        System.out.println(between);
        String gapTime = getGapTime(between);
        System.out.println(gapTime);


    }

    public static String getGapTime(long time) {
        long hours = time / (1000 * 60 * 60);
        long minutes = (time - hours * (1000 * 60 * 60)) / (1000 * 60);
        String diffTime = "";
        if (minutes < 10) {
            diffTime = hours + ":0" + minutes;
        } else {
            diffTime = hours + ":" + minutes;
        }
        return diffTime;
    }


    private static void method1() {
        String s = "00:59:16";
        String[] split = s.split(":");
        Integer time;
        time = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        System.out.println(time);
    }

    private static void method2() {
        Map<String, Object> hashMap = new HashMap<>();
        ConcurrentMap<String, Object> concurrentMap = new ConcurrentHashMap<>();

    }

    private static void method3() {
        int number = 10;
        //原始数二进制
        printInfo(number);
        number = number << 1;
        //左移一位
        printInfo(number);
        number = number >> 1;
        //右移一位
        printInfo(number);

    }

    private static void printInfo(int num) {
        System.out.println(Integer.toBinaryString(num));
    }

    /**
     * 计算两个时间的时间差
     *
     * @param strTime1
     * @param strTime2
     * @return 00:00:00
     */
    public static String getTimeDifference(String strTime1, String strTime2) {
        Date date1 = cn.hutool.core.date.DateUtil.parse(strTime1, "HH:mm:ss");
        Date date2 = cn.hutool.core.date.DateUtil.parse(strTime2, "HH:mm:ss");

        long l = date1.getTime() - date2.getTime();       //获取时间差
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

        System.out.println("" + day + "天" + hour + "小时" + min + "分" + s + "秒");
        StringBuilder sb = new StringBuilder();
        if (hour < 10) {
            sb.append("0");
        }
        sb.append(hour).append(":");
        if (min < 10) {
            sb.append("0");
        }
        sb.append(min).append(":");
        if (s < 10) {
            sb.append("0");
        }
        sb.append(s);
        return sb.toString();
    }
}
