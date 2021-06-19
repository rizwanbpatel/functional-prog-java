package com.rp.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Chap3V2 {
    public static void main(String[] args) {
        Integer[] intArra = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArra));


        Predicate<Integer> integerPredicate = (x) -> x % 2 == 0;

        List<Integer> listOfEvens = listOfIntegers
                .stream()
                .filter(integerPredicate)
                .collect(Collectors.toList());


        System.out.println(listOfEvens);

        String[] wordsArr = {"hello", "funcitonal", "programming", "is", "cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        Predicate<String> isLongerThan5 = (str) -> str.length() > 5;


        //Higher order predicate configurable length

        Function<Integer, Predicate<String>> createLengthTest = (minLength) -> {
            return (str) -> str.length() > minLength;
        };

        Predicate<String> isLongerThan3 = createLengthTest.apply(3);
        Predicate<String> isLongerThan10 = createLengthTest.apply(10);

        List<String> longWords = words
                .stream()
                .filter(isLongerThan10)
                .collect(Collectors.toList());

        System.out.println(longWords);


    }
}
