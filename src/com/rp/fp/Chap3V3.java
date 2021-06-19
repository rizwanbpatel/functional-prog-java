package com.rp.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Reduce functionality demo
 * Special type of funciton BinaryOperator
 * We can also provide function representing starting value or identiy for accumulation
 */
public class Chap3V3 {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integerList = new ArrayList<>(Arrays.asList(intArray));

        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println("acc: " + acc + ", x: " + x + ", result: " + result);
            return result;
        };

        Integer sum = integerList
                .stream()
                .reduce(0, getSum);
        System.out.println(sum);
    }


}

