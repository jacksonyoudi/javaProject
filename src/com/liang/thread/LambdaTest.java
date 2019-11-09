package com.liang.thread;

/**
 * lambda推导
 */
public class LambdaTest {
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("2 lambda");
        }
    }


    public static void main(String[] args) {
        ILike i = new Like();
        i.lambda();

        ILike i2 = new Like2();
        i2.lambda();

        ILike like = new ILike() {
            public void lambda() {
                System.out.println("3 lambda");
            }
        };
        like.lambda();
        // lambda只能有一个方法
        like = () -> {
            System.out.println("4 lambda");
        };
        like.lambda();

    }
}


interface ILike {
    void lambda();
}


class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("test lambda");
    }
}