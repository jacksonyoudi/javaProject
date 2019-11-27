package org.jackson.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API，获取类的信息
 */

public class Demo02 {
    public static void main(String[] args) {
        String path = "com.liang.oop.User";
        try {
            Class clazz = Class.forName(path);
            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName());


            // 获取属性
//            Field[] fields = clazz.getFields();
            Field[] fields = clazz.getDeclaredFields();  // 获取所有属性

            Field f = clazz.getDeclaredField("age");
            System.out.println(f.getName());

            System.out.println(fields.length);

            for (Field tp : fields
            ) {
                System.out.println("attr:" + tp);
            }


            // 获取方法
            Method[] methods = clazz.getDeclaredMethods();
//            Method m = clazz.getDeclaredMethod("id", null);  // 参数类型， 是Class类型
            for (Method method : methods
            ) {
                System.out.println(method);
            }


            // 获得构造信息
            Constructor[] constructors = clazz.getDeclaredConstructors();

            for (Constructor con : constructors
            ) {
                System.out.println(con);
            }


            Constructor c = clazz.getDeclaredConstructor(int.class, int.class, String.class);

            System.out.println(c);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
