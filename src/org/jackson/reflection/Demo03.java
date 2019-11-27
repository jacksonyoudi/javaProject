package org.jackson.reflection;

import com.liang.oop.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过API动态的操作，构造器 方法 属性
 */

@SuppressWarnings("all")
public class Demo03 {

    public static void main(String[] args) {
        String path = "com.liang.oop.User";
        try {
            Class<User> clazz = (Class<User>) Class.forName(path);
            User u = clazz.newInstance(); // 是调用无惨构造方法
            System.out.println(u);

            Constructor<User> constructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            User u2 = constructor.newInstance(1001, 18, "heehh");
            System.out.println(u2.getName());


            // 通过反射API调用普通方法
            User u3 = clazz.newInstance();

            Method method = clazz.getDeclaredMethod("setName", String.class);
            method.invoke(u3, "hello");
            System.out.println(u3.getName());


            // 通过反射API操作属性
            User u4 = clazz.newInstance();
            Field f = clazz.getDeclaredField("name");
            f.setAccessible(true); //设置这个属性不做安全检查了，可以直接访问
            f.set(u4, "world");
            System.out.println(u4.getName());
            System.out.println(f.get(u4));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
