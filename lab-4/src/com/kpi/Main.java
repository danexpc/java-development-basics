package com.kpi;

import java.util.LinkedList;

public class Main {

    private static final LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            add((int) (Math.random() * 100));
            System.out.println(list);
        }
        System.out.println("Size = " + list.size());
    }

    public static void add(int num) {
        if ( list.size() == 0 ) {
            list.addFirst(num);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (num <= list.get(i)) {
                list.add(i, num);
                return;
            }

            if (i == list.size() - 1) {
                list.addLast(num);
                return;
            }

        }
    }
}
