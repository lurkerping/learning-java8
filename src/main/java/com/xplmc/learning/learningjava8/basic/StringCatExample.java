package com.xplmc.learning.learningjava8.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * show difference between string+ and StringBuilder
 * truth is: compiled code are the same
 *
 * @author luke
 */
public class StringCatExample {

    private static final Logger logger = LoggerFactory.getLogger(StringCatExample.class);

    public static void main(String[] args) {
        String str1 = "100";
        String str2 = "200";
        String str3 = "abc";
        String a = str1 + str2 + str3;
        String b1 = new StringBuilder(str1).append(str2).append(str3).toString();
        String b2 = new StringBuilder().append(str1).append(str2).append(str3).toString();
        String c1 = new StringBuffer(str1).append(str2).append(str3).toString();
        String c2 = new StringBuffer().append(str1).append(str2).append(str3).toString();
        logger.info("string cat: {}", a);
        logger.info("string builder 1: {}", b1);
        logger.info("string builder 2: {}", b2);
        logger.info("string buffer 1: {}", c1);
        logger.info("string buffer 2: {}", c2);
    }

}
