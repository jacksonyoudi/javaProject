package com.jackson.gof.builder;

public class YdAirShipBuilder implements AirShipBuilder {
    @Override
    public Engine builderEngine() {
        System.out.println("构建发动机");
        return new Engine("youdi发动机");
    }

    @Override
    public OrbitabModule builderOrbitabModule() {
        System.out.println("构建轨道仓");
        return new OrbitabModule("youdi轨道仓");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建逃逸仓");
        return new EscapeTower("youdi逃逸仓");
    }
}
