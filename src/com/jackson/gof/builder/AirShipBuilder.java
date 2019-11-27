package com.jackson.gof.builder;

public interface AirShipBuilder {
    Engine builderEngine();

    OrbitabModule builderOrbitabModule();

    EscapeTower builderEscapeTower();
}
