package com.rp.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 ** Demo map function
 **/
public class Chap3V1 {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> lifOfIntegers = new ArrayList<>(Arrays.asList(intArray));


        Function<Integer, Integer> timesTwo = (x) -> x * 2;

        List<Integer> doubled = lifOfIntegers
                .stream()
                .map(timesTwo)
                .collect(Collectors.toList());

        System.out.println(doubled);

    }
}
