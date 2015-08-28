package org.zhiyan.test;

/**
 * @Title:
 * @Description:加载顺序为：静态变量、静态块、静态方法
 * @Author:zzy
 * @Since:2015年8月27日
 * @Version:1.1.0
 */
public class 静态加载顺序 {

    static int a = 3;
    static int b;

    static void meth(int x) {
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    static {
        System.out.println("static block initialized");
        b = a * 4;
    }

    public static void main(String[] args) {
        meth(42);
    }

}
