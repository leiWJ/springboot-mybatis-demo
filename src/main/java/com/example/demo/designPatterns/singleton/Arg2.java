package com.example.demo.designPatterns.singleton;

/**
 * @author wen
 * @date 2020/5/22 10:38
 * @Description 双重校验锁形式（DCL）：double-checked-locking
 * 懒汉模式为线程不安全的，在此基础上加上并发控制，保证线程安全，对外存一个对象
 * 实现：
 * 1.  构造器私有化：避免外部new 构造器
 * 2.  提供私有静态属性：存储对象地址
 * 3.  提供公共静态方法：获取属性
 **/
public class Arg2 {
    // volatile 关键字 防止发生指令重排序
    private static volatile Arg2 instance;

    private Arg2() {}

    public static Arg2 getInstance() {
        if (null != instance) {
            return instance;
        }
        synchronized (Arg2.class) {
            if (null == instance) {
                /* new一个对象分为三步：
                 * 1. 开辟内存空间
                 * 2. 初始化对象
                 * 3. 将对象指向分配的内存空间
                 */
                instance = new Arg2();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + Arg2.getInstance().hashCode());
            }).start();
        }
    }

}
