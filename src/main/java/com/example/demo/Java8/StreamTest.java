package com.example.demo.Java8;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Author wen
 * @Date 2018/11/14 18:19
 * @Description
 **/
public class StreamTest {
    public static void main(String[] args) {
        long l = System.nanoTime();
        System.out.println(l);
        new StreamTest().doTest();
    }

    private static void method1() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream
                .parallel()
                .filter(str -> str.length() >= 3)
                .map(str -> str.toUpperCase())
                .map(str -> str.charAt(0))
                .forEach(System.out::println);
    }

    public static void outTimeUs(long startTime, String msg, int times) {
        long ns_all = System.nanoTime() - startTime;
        double us_avg = (ns_all + 500.0) / 1000 / times;
        System.out.println(
                String.format("%s avg of %d = %.2f us", msg, times, us_avg));
    }

    public void doTest(){
        warmUp();
        int[] lengths = {
                10000,
                100000,
                1000000,
                10000000,
                20000000,
                40000000
        };
        for(int length : lengths){
            System.out.println(String.format("---List length: %d---", length));
            ArrayList<String> list = randomStringList(length);
            int times = 4;
            String min1 = "1";
            String min2 = "2";
            String min3 = "3";
            long startTime;

            startTime = System.nanoTime();
            for(int i=0; i<times; i++){
                min1 = minStringForLoop(list);
            }
            outTimeUs(startTime, "minStringForLoop time:", times);

            startTime = System.nanoTime();
            for(int i=0; i<times; i++){
                min2 = minStringStream(list);
            }
            outTimeUs(startTime, "minStringStream time:", times);

            startTime = System.nanoTime();
            for(int i=0; i<times; i++){
                min3 = minStringParallelStream(list);
            }
            outTimeUs(startTime, "minStringParallelStream time:", times);

            System.out.println(min1.equals(min2) && min2.equals(min3));
//			System.out.println(min1);
        }
    }
    private void warmUp(){
        ArrayList<String> list = randomStringList(10);
        for(int i=0; i<20000; i++){
            minStringForLoop(list);
            minStringStream(list);
            minStringParallelStream(list);

        }
    }
    private String minStringForLoop(ArrayList<String> list){
        String minStr = null;
        boolean first = true;
        for(String str : list){
            if(first){
                first = false;
                minStr = str;
            }
            if(minStr.compareTo(str)>0){
                minStr = str;
            }
        }
        return minStr;
    }
    private String minStringStream(ArrayList<String> list){
        return list.stream().min(String::compareTo).get();
    }
    private String minStringParallelStream(ArrayList<String> list){
        return list.stream().parallel().min(String::compareTo).get();
    }
    private ArrayList<String> randomStringList(int listLength){
        ArrayList<String> list = new ArrayList<>(listLength);
        Random rand = new Random();
        int strLength = 10;
        StringBuilder buf = new StringBuilder(strLength);
        for(int i=0; i<listLength; i++){
            buf.delete(0, buf.length());
            for(int j=0; j<strLength; j++){
                buf.append((char)('a'+rand.nextInt(26)));
            }
            list.add(buf.toString());
        }
        return list;
    }


}
