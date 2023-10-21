package com.oracle.ocp.streams;

import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Statistics {


    public static void main(String[] args) {

    }


    private static int max(IntStream ints){
        OptionalInt optional = ints.max();
        return optional.orElseThrow(RuntimeException::new);
    }

    private static int range(IntStream ints){
        IntSummaryStatistics optional = ints.summaryStatistics();
        if(optional.getCount() == 0) throw new RuntimeException();
        return optional.getMax() - optional.getMin();
    }


}
