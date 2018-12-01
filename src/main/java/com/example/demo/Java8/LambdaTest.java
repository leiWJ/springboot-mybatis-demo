package com.example.demo.Java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author wen
 * @Date 2018/11/14 18:20
 * @Description
 **/
public class LambdaTest {

    public static void main(String[] args) {
        //method1();
        method2();
    }


    private static void method1() {
        String[] sArray = new String[4];
        sArray[0] = "D";
        sArray[1] = "C";
        sArray[2] = "F";
        sArray[3] = "E";
        //1将数组排序，
        List<String> collect = Arrays.stream(sArray).sorted().collect(Collectors.toList());
        System.out.println(collect);

        //将数组排序并转化成 以逗号分隔的字符串
        String s = Arrays.stream(sArray).sorted().collect(Collectors.joining(","));
        System.out.println(s);
    }

    //基本方法
    private static void method2() {
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "23", "", "jkl");
        long count;
        count = list.stream().filter(String::isEmpty).count();
        System.out.println("空字符串数量为: " + count);

        count = list.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("(并行处理)空字符串的数量为: " + count);

        count = list.stream().filter(string -> string.length() == 3).count();
        System.out.println("字符串长度为3的数量为: " + count);

        List<String> collect = list.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("(去除空)筛选后的列表: " + collect);

    }

    //计算数值
    private static void method3() {
        List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    //遍历及过滤器使用
    private static void method4() {

    }
}
