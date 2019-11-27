package com.jackson.gof.builder;


/**
 *
 */
public class AirShip {
    private OrbitabModule orbitabModule;
    private Engine engine;
    private EscapeTower escapeTower;


    public OrbitabModule getOrbitabModule() {
        return orbitabModule;
    }

    public void setOrbitabModule(OrbitabModule orbitabModule) {
        this.orbitabModule = orbitabModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }
}


class OrbitabModule {
    private String name;

    public OrbitabModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Engine {
    private String name;

    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class EscapeTower {
    private String name;

    public EscapeTower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}