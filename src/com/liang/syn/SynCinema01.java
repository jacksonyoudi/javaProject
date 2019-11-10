package com.liang.syn;

import java.util.ArrayList;
import java.util.List;

public class SynCinema01 {
    public static void main(String[] args) {
        List<Integer> avaible = new ArrayList<Integer>();
        avaible.add(1);
        avaible.add(2);
        avaible.add(3);
        avaible.add(4);
        avaible.add(5);
        avaible.add(6);
        avaible.add(7);
        Cinema01 c = new Cinema01(avaible, "haha");


        ArrayList<Integer> seat1 = new ArrayList<Integer>();
        ArrayList<Integer> seat2 = new ArrayList<Integer>();
        seat1.add(1);
        seat1.add(2);

        seat2.add(1);
        seat2.add(6);
        seat2.add(7);


        new Thread(new Customer01(c, seat1), "liang").start();
        new Thread(new Customer01(c, seat2), "hello").start();
    }
}


class Customer01 implements Runnable {
    Cinema01 cinema;
    ArrayList<Integer> seats;

    public Customer01(Cinema01 cinema, ArrayList<Integer> seats) {
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


class Cinema01 {
    List<Integer> avaible;
    String name;

    public Cinema01(List<Integer> avaible, String name) {
        this.avaible = avaible;
        this.name = name;
    }

    public boolean bookTickets(List<Integer> seats) {
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(avaible);

        // 相减
        copy.removeAll(seats);

        if (avaible.size() - copy.size() != seats.size()) {
            return false;
        }
        avaible = copy;

        return true;
    }
}