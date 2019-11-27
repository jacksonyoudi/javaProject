package com.jackson.gof.factory.abs;

public interface Seat {
    void massage();
}


class LuxurySeat implements Seat {
    @Override
    public void massage() {
        System.out.println("high seat");
    }
}


class LowSeat implements Seat {
    @Override
    public void massage() {
        System.out.println("low seat");
    }
}