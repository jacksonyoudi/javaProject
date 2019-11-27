package org.jackson.jvm;

public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader loader = new FileSystemClassLoader("/Users/youdi/Project/javaProject/Video/out/production/Video");
        Class<?> c = loader.loadClass("com.liang.oop.User");
        System.out.println(c);

    }
}
