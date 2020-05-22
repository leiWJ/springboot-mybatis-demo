package com.example.demo.designPatterns.singleton;

/**
 * @author wen
 * @date 2020/5/22 10:28
 * @Description 单例模式 -> 饿汉模式  线程安全  缺点：浪费内存空间
 **/
public class Arg1 {

    //创建唯一实例
    private static Arg1 instance = new Arg1();

    //创建一个私有的构造方法，防止外部直接调用
    private Arg1() {}

    public static Arg1 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Arg1 a = Arg1.getInstance();
        Arg1 b = Arg1.getInstance();
        System.out.println(a == b);
    }
}
