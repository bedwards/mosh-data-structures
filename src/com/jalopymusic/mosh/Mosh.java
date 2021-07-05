package com.jalopymusic.mosh;

import java.util.Arrays;

public class Mosh {
    public static void main(String[] args) {
        MoshArray numbers1 = new MoshArray(Integer.class, 3);
        numbers1.add(10);
        numbers1.add(20);
        numbers1.add(30);
        numbers1.add(40);
        numbers1.print();
        numbers1.remove(1);
        numbers1.print();
        System.out.println(numbers1.indexOf(30));
        numbers1.remove(5);
    }
}
