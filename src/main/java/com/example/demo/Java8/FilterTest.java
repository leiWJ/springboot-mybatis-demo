package com.example.demo.Java8;

import java.util.*;
import java.util.function.Predicate;

/**
 * @Author wen
 * @Date 2018/11/14 18:43
 * @Description
 **/
public class FilterTest {
    public static void main(String args[]) {

        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("刘", "玉溪", "Java programmer", "male", 43, 2000));
                add(new Person("赵", "塔山", "Java programmer", "female", 23, 1500));
                add(new Person("钱", "帝豪", "Java programmer", "male", 33, 1800));
                add(new Person("孙", "十渠", "Java programmer", "female", 32, 1600));
                add(new Person("李", "小苏", "Java programmer", "male", 22, 1200));
                add(new Person("周", "中华", "Java programmer", "female", 27, 1900));
                add(new Person("吴", "娇子", "Java programmer", "male", 30, 2300));
                add(new Person("郑", "利群", "Java programmer", "female", 35, 1700));
                add(new Person("王", "金叶", "Java programmer", "male", 33, 2000));
                add(new Person("董", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("山", "压缩", "PHP programmer", "male", 34, 1550));
                add(new Person("河", "剑圣", "PHP programmer", "female", 23, 1200));
                add(new Person("恋", "蛮王", "PHP programmer", "male", 32, 1600));
                add(new Person("美", "诺手", "PHP programmer", "female", 21, 1000));
                add(new Person("人", "石头", "PHP programmer", "male", 32, 1100));
                add(new Person("无", "猴子", "PHP programmer", "female", 25, 1300));
                add(new Person("泪", "武器", "PHP programmer", "male", 36, 1100));
                add(new Person("哈", "凯南", "PHP programmer", "female", 21, 1000));
                add(new Person("萨", "蚂蚱", "PHP programmer", "male", 38, 1600));
                add(new Person("尅", "安妮", "PHP programmer", "female", 40, 1800));
            }
        };

        System.out.println("所有程序员的姓名:");
        javaProgrammers.forEach((p) -> System.out.printf(p.getFirstName() + " " + p.getLastName() + "; "));
        System.out.println();
        phpProgrammers.forEach((p) -> System.out.printf(p.getFirstName() + " " + p.getLastName() + "; "));

        System.out.println();
        System.out.println("下面是月薪超过 $1,400 的PHP程序员:");
        phpProgrammers.stream()
                .filter((p) -> (p.getSalary() > 1400))
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // 定义 filters
        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

        System.out.println("");
        System.out.println("下面是年龄大于 25岁且月薪在$1,400以上的女PHP程序员:");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // 重用filters
        System.out.println("");
        System.out.println("年龄大于 25岁的女性 Java programmers:");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        //limit
        System.out.println("最前面的3个 Java programmers:");
        javaProgrammers.stream()
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

    }


}
