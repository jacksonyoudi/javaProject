package org.jackson.jvm;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());


        System.out.println(System.getProperty("java.class.path"));
    }
}
