package com.xplmc.learning.learningjava8.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * collection removeIf simple example
 *
 * @author luke
 * @date 2018/7/24
 */
public class RemoveIfExample {

    private static final Logger logger = LoggerFactory.getLogger(RemoveIfExample.class);

    public static void main(String[] args) {
        List<String> stringList = CollectionForeachAndModifyExample.exampleList();
        logger.info("removeIf, before: {}", stringList);
        stringList.removeIf("1"::equals);
        logger.info("removeIf, after: {}", stringList);
    }

}
