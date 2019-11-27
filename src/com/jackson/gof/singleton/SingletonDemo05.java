package com.jackson.gof.singleton;

/**
 * 枚举本身就是单例模式
 * 不会有反射和序列化的漏洞
 * 没有延时加载
 */

public enum SingletonDemo05 {
    INSTACE;

    // 添加自己的操作
    public void singletonOperation() {

    }

    public SingletonDemo05 getInstance() {
        return INSTACE;
    }

}
