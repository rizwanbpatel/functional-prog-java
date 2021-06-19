package com.rp.fp;

import java.util.function.Function;

public class Chap2V2 {

    public static void main(String[] args) {
        Function<Integer, Integer> absoluteValue = (x) -> x < 0 ? -x : x;

        Function<Integer,Integer> absoluteDetail = (x) -> {
            if(x < 0){
                return -x;
            }else {
                return x;
            }
        };

        System.out.println(absoluteDetail.apply(-5));
    }
}
