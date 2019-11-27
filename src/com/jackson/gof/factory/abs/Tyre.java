package com.jackson.gof.factory.abs;

public interface Tyre {
    void revolve();
}

class LuxuryTyre implements Tyre {
    @Override
    public void revolve() {
        System.out.println("不磨损");
    }
}


class LowTyre implements Tyre {
    @Override
    public void revolve() {
        System.out.println("容易磨损");
    }
}