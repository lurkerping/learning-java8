package com.xplmc.learning.learningjava8.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * three kinds' of method references
 * 1:static method
 * 2:arbitrary type
 * 3:existing object
 */
public class MethodReferenceNotes {

    public static void main(String[] args) {

        //static method as method reference
        Function<String, Integer> f1 = Integer::parseInt;
        System.out.println(f1);

        //arbitrary type as method reference
        Function<String, String> f2 = String::toString;
        System.out.println(f2);

        //existing object as method reference
        String test = "test";
        Supplier<String> f3 = test::toString;
        System.out.println(f3);

    }

}
