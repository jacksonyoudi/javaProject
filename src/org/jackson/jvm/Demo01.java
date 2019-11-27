package org.jackson.jvm;

public class Demo01 {
    static {
        System.out.println("Demo01");
    }


    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.width);
        System.out.println(a.width);
    }
}

class A extends AF {
    public static int width = 100;

    static {
        System.out.println("static init A");
        width = 300;
    }

    public A() {
        System.out.println("class init A");
    }
}

class AF {
    static {
        System.out.println("A Father init");
    }
}