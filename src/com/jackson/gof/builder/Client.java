package com.jackson.gof.builder;

public class Client {
    public static void main(String[] args) {

        AirShipDirector director = new YdAirShipDirector(new YdAirShipBuilder());
        AirShip ship = director.directAirShip();
        System.out.println(ship.getEngine());
    }
}
