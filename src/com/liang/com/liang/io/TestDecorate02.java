package com.liang.com.liang.io;

/**
 * 抽象组件： 需要装饰的抽象对象(接口或抽象父类)
 * 具体组件： 需要装饰的的对象
 * 抽象装饰类： 包含了对抽象类组件的引用以及装饰着共有的方法
 * 具体装饰类： 被装饰的对象
 */


public class TestDecorate02 {
    public static void main(String[] args) {

    }
}


//  抽象组件
interface Drink {
    double cost();
    String info();
}

// 具体组件

class Coffee implements Drink {
    private String name = "原味咖啡";

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}


// 抽象装饰类
abstract class Decorate implements Drink {
    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return 100;
    }

    @Override
    public String info() {
        return null;
    }
}
