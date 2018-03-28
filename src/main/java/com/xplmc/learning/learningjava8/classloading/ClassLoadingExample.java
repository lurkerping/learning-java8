package com.xplmc.learning.learningjava8.classloading;

import com.sun.nio.zipfs.ZipInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * class loading parent-delegation model example
 *
 * @author luke
 */
public class ClassLoadingExample {

    private static final Logger logger = LoggerFactory.getLogger(ClassLoadingExample.class);

    public static void main(String[] args) {
        //Bootstrap ClassLoader
        logger.info("BigDecimal's classloader: {}", BigDecimal.class.getClassLoader());
        logger.info("Integer's classloader: {}", Integer.class.getClassLoader());

        //Extension ClassLoader
        logger.info("ZipInfo's classloader: {}", ZipInfo.class.getClassLoader());

        //App ClassLoader
        logger.info("ClassLoadingExample's classloader: {}", ClassLoadingExample.class.getClassLoader());
    }

}
