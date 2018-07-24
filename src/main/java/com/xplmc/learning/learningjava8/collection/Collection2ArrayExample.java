package com.xplmc.learning.learningjava8.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * transfer collection to array simple example
 *
 * @author luke
 * @date 2018/7/24
 */
public class Collection2ArrayExample {

    private static final Logger logger = LoggerFactory.getLogger(Collection2ArrayExample.class);

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("yellow");
        stringList.add("one");
        stringList.add("yeah");

        String[] stringArray = new String[stringList.size()];
        stringList.toArray(stringArray);
        logger.info("stringList: {}", stringList);
        logger.info("stringArray: {}", Arrays.toString(stringArray));
    }

}
