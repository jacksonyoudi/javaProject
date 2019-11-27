package org.jackson.dynamic;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 测试javassit API
 */

@SuppressWarnings("all")
public class Demo04 {
    public static void main(String[] args) throws NotFoundException, IOException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();

        CtClass cc = pool.get("org.jackson.dynamic.Demo02");

//        byte[] bytes = cc.toBytecode();
//        System.out.println(Arrays.toString(bytes));
//
//        System.out.println(cc.getName());
//        System.out.println(cc.getSimpleName());
//        System.out.println(cc.getSuperclass());


        // 测试产生新方法

//        CtMethod m = CtNewMethod.make("public int add (int a, int b ) {return a+b;}", cc);
//        CtMethod m = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType, CtClass.intType}, cc);
//        m.setModifiers(Modifier.PUBLIC);
//        m.setBody("{return $1+$2;}");
//        cc.addMethod(m);
//
//        // 通过反射调用新生成的方法
//        Class clazz = cc.toClass();
//        Object obj = clazz.newInstance();
//
//        Method method = clazz.getDeclaredMethod("add", int.class, int.class);
//        Object re = method.invoke(obj, 200, 30);
//        System.out.println(re);


        // 动态修改代码
//        CtMethod m = cc.getDeclaredMethod("say", new CtClass[]{CtClass.intType});
//        m.insertBefore("System.out.println($1);");
//        m.insertAfter("System.out.println(\"end\");");


        //        // 通过反射调用新生成的方法
//        Class clazz = cc.toClass();
//        Object obj = clazz.newInstance();
//
//        Method method = clazz.getDeclaredMethod("say", int.class);
//        Object re = method.invoke(obj, 200);
    }



    public void test01() {
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass cc = pool.get("org.jackson.dynamic.Demo02");
            CtField f1 = new CtField(CtClass.intType, "no", cc);
            f1.setModifiers(Modifier.PRIVATE);
            cc.addField(f1);

            cc.getDeclaredField("no");

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }
}
