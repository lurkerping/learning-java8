package com.xplmc.learning.learningjava8.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * this is java 7 feature, final rethrow
 *
 * @author luke
 */
public class FinalRethrow {

    public static void main(String[] args) throws IOException {
        try {
            new FileInputStream("pom.xml").close();
        } catch (final Exception e) {
            if (e instanceof IOException) {
                System.out.println("IOException");
                throw e;
            } else {
                System.out.println(e.getMessage());
            }
        }
    }

}
