package com.jackson.gof.builder;

public class YdAirShipDirector implements AirShipDirector {
    private AirShipBuilder builder;

    public YdAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        Engine e = builder.builderEngine();
        OrbitabModule orbitabModule = builder.builderOrbitabModule();
        EscapeTower escapeTower = builder.builderEscapeTower();


        //  组装
        AirShip ship = new AirShip();
        ship.setEngine(e);
        ship.setEscapeTower(escapeTower);
        ship.setOrbitabModule(orbitabModule);

        return ship;
    }
}
