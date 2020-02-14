package com.jackson.gof.bridge;

public class Computer {
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }


    public void sale() {
        brand.sale();
    }
}


class Desktop extends Computer {
    public Desktop(Brand b) {
        super(b);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("Desktop");
    }
}


class Laptop extends Computer {
    public Laptop(Brand b) {
        super(b);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("Laptop");
    }
}
