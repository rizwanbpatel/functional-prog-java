package com.rp.fp;

import java.util.function.Function;

/**
 * Demo partial funcitons
 */
public class Chap4V1 {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> add = (x, y, z) -> x + y + z;

        Function<Integer, Function<Integer, Function<Integer, Integer>>> addPartial =
                (x) -> (y) -> (z) -> add.apply(x, y, z);

        Function<Integer, Function<Integer, Integer>> add5 = addPartial.apply(5);
        Function<Integer, Integer> add5and = add5.apply(6);
        Integer sum = add5and.apply(7);
        System.out.println(sum);
    }
}
