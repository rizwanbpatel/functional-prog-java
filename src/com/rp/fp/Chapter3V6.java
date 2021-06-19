package com.rp.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Demo ParallelStream
 *  Process data in parallel
 *  Performance
 *  Allow the data to be split across multiple threads
 *  Java splits in multiple pars and process on separate thread concurrently
 */
public class Chapter3V6 {

    public static void main(String[] args) {

        String[] wordsArr = {"hello", "funcitonal", "programming", "is", "cool","refreshment","need","of","hour"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        ForkJoinPool myPool = new ForkJoinPool(4);
        List<String> processedWords = words
                .parallelStream()
                .map((word) -> {
                    System.out.println(Thread.currentThread().getName()+":"+"Processing to Uppercase : "+word);
                    return word.toUpperCase();
                })
                .map((word) -> {
                    System.out.println(Thread.currentThread().getName()+":"+"Adding exclaimation point to : "+word);
                    return word + "!";
                })
                .collect(Collectors.toList());
        System.out.println(processedWords);


    }
}
