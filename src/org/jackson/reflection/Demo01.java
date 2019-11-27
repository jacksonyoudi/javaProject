package org.jackson.reflection;

/**
 * 测试java.lang.Class对象的获取
 * 一个类只会加载一个反射对象
 */

public class Demo01 {
    public static void main(String[] args) {
        String path = "com.liang.oop.User";
        path.getClass();
        try {
            Class clazz = Class.forName(path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
