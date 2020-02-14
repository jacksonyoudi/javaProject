package com.jackson.gof.flyweight;

/**
 * 享元类
 */
public interface ChessFlyWeight {
    void setColor();

    String getColor();

    void display();
}


class ConcreteChess implements ChessFlyWeight {
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor() {

    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public void display() {
        System.out.println("");
    }
}