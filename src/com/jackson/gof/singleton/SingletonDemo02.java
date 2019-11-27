package com.jackson.gof.singleton;

/**
 * 测试懒汉式 单例模式
 * 1. 构造器私有化
 * 2. static 实例对象
 * 3. 全局唯一的访问入口
 */

public class SingletonDemo02 {
    // 类初始化的时候(延时加载),真正使用的时候才加载
    private static SingletonDemo02 instance = null;


    private SingletonDemo02() {  // 私有构造器
    }

    // 方法同步， 调用效率低
    public static synchronized SingletonDemo02 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo02();
        }
        return instance;
    }
}