package com.xplmc.learning.learningjava8.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * transfer array to collection simple example
 *
 * @author luke
 * @date 2018/7/24
 */
public class Array2CollectionExample {

    private static final Logger logger = LoggerFactory.getLogger(Array2CollectionExample.class);

    public static void main(String[] args) {
        String[] stringArray = new String[]{"yellow", "green", "yeah", "1314"};
        List<String> stringList = Arrays.asList(stringArray);

        logger.info("stringArray: {}", Arrays.toString(stringArray));
        logger.info("stringList: {}", stringList);

        // stringList can't modify?
        // seems in java 8, it's ok
        stringList.add("no");
    }

}
