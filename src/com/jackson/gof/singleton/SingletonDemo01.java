package com.jackson.gof.singleton;

/**
 * 测试饿汉式 单例模式
 * 1. 构造器私有化
 * 2. static 实例对象
 * 3. 全局唯一的访问入口
 */

public class SingletonDemo01 {
    // 类初始化的时候，就先创建(没有延时加载), 线程安全的
    // 由于加载类的时候，天然的线程安全的。
    private static SingletonDemo01 instance = new SingletonDemo01();


    private SingletonDemo01() {
    }

    // 不需要同步，效率高
    public static SingletonDemo01 getInstance() {
        return instance;
    }
}
