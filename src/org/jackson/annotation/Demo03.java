package org.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 */

public class Demo03 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("org.jackson.annotation.Stu");
            Annotation[] annotations = clazz.getAnnotations();

            for (Annotation a : annotations) {
                System.out.println(a);
            }

            Table st = (Table) clazz.getAnnotation(Table.class);
            System.out.println(st.value());


            Field f = clazz.getDeclaredField("name");
            JcField field = f.getAnnotation(JcField.class);
            System.out.println(field.columnName() + field.type() + field.length());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
