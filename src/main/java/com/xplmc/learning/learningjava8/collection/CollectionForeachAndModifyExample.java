package com.xplmc.learning.learningjava8.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Modify collection in foreach example
 *
 * @author luke
 * @date 2018/7/24
 */
public class CollectionForeachAndModifyExample {

    private static final Logger logger = LoggerFactory.getLogger(CollectionForeachAndModifyExample.class);

    public static void main(String[] args) {
        rightWay("1");
        rightWay("2");
        wrongWay("1");
        wrongWay("2");
    }

    /**
     * right way to add/remove in foreach
     */
    private static void rightWay(String targetString) {
        List<String> stringList = exampleList();
        logger.info("right way, targetString: {}, before: {}", targetString, stringList);
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            if (targetString.equals(iterator.next())) {
                iterator.remove();
            }
        }
        logger.info("right way, targetString: {}, after: {}", targetString, stringList);
    }

    /**
     * wrong way to add/remove in foreach
     */
    private static void wrongWay(String targetString) {
        try {
            List<String> stringList = exampleList();
            logger.info("wrong way, targetString: {}, before: {}", targetString, stringList);
            for (String item : stringList) {
                if (targetString.equals(item)) {
                    stringList.remove(item);
                }
            }
            logger.info("wrong way, targetString: {}, after: {}", targetString, stringList);
        } catch (Exception e) {
            logger.error("error add/removing in foreach", e);
        }
    }

    /**
     * create an example list for test
     *
     * @return sample ArrayList
     */
    static List<String> exampleList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        return stringList;
    }

}
