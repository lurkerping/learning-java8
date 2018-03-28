package com.xplmc.learning.learningjava8.methodhandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

/**
 * simple method handle example
 * simple conclusion: MethodHandle are not easy to use,
 * in some cases, MethodHandle didn't seem to faster either.
 *
 * @author luke
 */
public class MethodHandleSimpleExample {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandleSimpleExample.class);

    private static AtomicLong counter = new AtomicLong();

    public static void main(String[] args) {
        int loopCount = 1000000;
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            methodhandles();
            counter.incrementAndGet();
        }
        logger.info("method handles cost: {}", System.currentTimeMillis() - t1);
        t1 = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            reflection();
            counter.incrementAndGet();
        }
        logger.info("reflection cost: {}", System.currentTimeMillis() - t1);
    }

    private static void methodhandles() {
        GirlFriend girlFriend = new GirlFriend();
        try {
            GirlFriendMeta2.SETTER.forEach(m -> {
                try {
                    m.invokeExact(girlFriend, String.valueOf(Math.random()));
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            });
            GirlFriendMeta2.GETTER.forEach(m -> {
                try {
                    String value = (String) m.invokeExact(girlFriend);
                    //
                    if (counter.get() % 1000000 == 0) {
                        logger.info("{}={}", m.toString(), value);
                    }
                } catch (Throwable e) {
                    //ignore
                }
            });
        } catch (Exception e) {
            //ignore
        }
    }

    /**
     * set and get all girl friend's field using reflection
     */
    private static void reflection() {
        GirlFriend girlFriend = new GirlFriend();
        try {
            GirlFriendMeta1.SETTER.forEach(m -> {
                try {
                    m.invoke(girlFriend, String.valueOf(Math.random()));
                } catch (Exception e) {
                    logger.error("what?", e);
                }
            });
            GirlFriendMeta1.GETTER.forEach(m -> {
                try {
                    String value = (String) m.invoke(girlFriend);
                    //
                    if (counter.get() % 1000000 == 0) {
                        logger.info("{}={}", m.getName(), value);
                    }
                } catch (Exception e) {
                    logger.error("what?", e);
                }
            });
        } catch (Exception e) {
            //ignore
        }
    }

}
