package com.donvi.thread.safe;

/**
 * @Description:
 * @Author: yangdongwei
 * @CreateDate: 2020/11/20
 * @Version: 1.0
 */
public class Singleton {

    // 假设线程a正在初始化单例，线程b可能读到一个不完全的单例对象，因此用volatile(对于volatile修饰的，write早于read)
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton(){
        // 若没有外层判断，每次都要走synchronized，浪费资源
        if (null == singleton){
            synchronized (Singleton.class){
                // 若没有内层判断，假如有a,b,c三个线程通过了外层判断，就要实例化3次，不符合单例思想
                if (null == singleton){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
