package com.rp.fp;

import java.util.function.BiFunction;

public class Chap2V3 {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;

        System.out.println(add.apply(7, 8));

        TriFunction<Integer, Integer, Integer, Integer> add3 = (x, y, z) -> x + y + z;

        System.out.println(add3.apply(7, 8, 4));

        NoArgFunction<String> sayHello = () -> "Hello";
        System.out.println(sayHello.apply());

    }
}
