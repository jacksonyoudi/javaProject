package com.jackson.gof.factory.abs;

public interface CarFactory {
    Engine createEngine();

    Seat createSeat();

    Tyre createTyre();
}



