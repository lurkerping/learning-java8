package com.xplmc.learning.learningjava8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * flatMap simple example
 */
public class FlatMapSimpleExample {

    public static void main(String[] args) {
        //return list1 with list2's combination
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);

        list1
                .stream()
                .flatMap(i -> list2
                        .stream()
                        .map(j -> new Integer[]{i, j}))
                .forEach(a -> System.out.println("(" + a[0] + ", " + a[1] + ")"));
    }

}
