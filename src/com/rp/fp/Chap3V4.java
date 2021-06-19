package com.rp.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demo for Collect
 * Collector interface how to combine all the elements from the stream into final values or objects
 * joining
 * groupBy
 * counting
 * collections
 * partitioning
 */
public class Chap3V4 {

    public static void main(String[] args) {
        String[] wordsArr = {"hello", "programming","functional","is","cool","im"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        Map<Boolean, List<String>> listMap = words
                .stream()
                .collect(Collectors.partitioningBy(
                        (word) -> word.length() > 5
                ));
        System.out.println(listMap);
    }
}
