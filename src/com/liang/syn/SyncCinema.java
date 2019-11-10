package com.liang.syn;

public class SyncCinema {
    public static void main(String[] args) {
        Cinema c = new Cinema(5, "happy liang");
        new Thread(new Customer(c, 2), "liang").start();
        new Thread(new Customer(c, 5), "hello").start();
    }
}


class Customer implements Runnable {
    Cinema cinema;
    int seats;

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {

            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "位置数是:" + seats);
            } else {
                System.out.println("no tickets");
            }
        }
    }
}


class Cinema {
    int avaible;
    String name;

    public Cinema(int avaible, String name) {
        this.avaible = avaible;
        this.name = name;
    }

    public boolean bookTickets(int seats) {
        System.out.println("可用位置为:" + avaible);
        if (seats > avaible) {
            return false;
        }
        avaible -= seats;
        return true;
    }
}