package org.jackson.dynamic;

import javassist.*;

import java.io.IOException;

/**
 * 测试javassist
 */
public class Demo03 {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        // 获取类池
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("com.liang.oop.User");

        // 创建属性
        CtField f1 = CtField.make("private int no;", cc);
        CtField f2 = CtField.make("private String face;", cc);
        cc.addField(f1);
        cc.addField(f2);

        // method
        CtMethod m1 = CtMethod.make("public int getFace(){return face;}", cc);
        CtMethod m2 = CtMethod.make("public int getNo(){return no;}", cc);
        cc.addMethod(m1);
        cc.addMethod(m2);

        // 添加构造器

        CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")}, cc);
        constructor.setBody("{this.no=no;this.face=face;}");
        cc.addConstructor(constructor);
        cc.writeFile("/Users/youdi/Project/javaProject/Video/src/org/jackson/dynamic");

        System.out.println("生成类，成功");

    }
}
