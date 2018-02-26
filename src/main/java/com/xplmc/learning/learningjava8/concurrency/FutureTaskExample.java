package com.xplmc.learning.learningjava8.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * this is java 5 feature, FutureTask
 * 1/A Future that is runnable
 * 2/can run only one time
 */
public class FutureTaskExample {

    private static final Logger logger = LoggerFactory.getLogger(FutureTaskExample.class);

    public static void main(String[] args) throws Exception {
        //future task use case
        ExecutorService es = Executors.newFixedThreadPool(5);
        //old way
        Future<String> f1 = es.submit(new ComputationTask(), "ok1");
        logger.info("f1, submitted");
        logger.info("f1.get={}", f1.get());
        logger.info("f1.get={}", f1.get());

        //using FutureTask
        FutureTask<String> f2 = new FutureTask<>(new ComputationTask(), "ok2");
        Future<String> f3 = es.submit(f2, "ok3");
        logger.info("f2, submitted");
        logger.info("f2={}, f2.get={}", f2, f2.get());
        logger.info("f3={}, f3.get={}", f3, f3.get());
        //the Future return by submit FutureTask, is not the same with FutureTask...

        //using FutureTask.run
        FutureTask<String> f4 = new FutureTask<>(new ComputationTask(), "ok4");
        logger.info("f4, submitted");
        f4.run();
        logger.info("f4={}, f4.get={}", f4, f4.get());
        logger.info("f4, submitted again");
        //FutureTask can only run one time
        f4.run();
        logger.info("f4={}, f4.get={}", f4, f4.get());
        logger.info("f4, submitted again again");
        es.submit(f4);
        logger.info("f4={}, f4.get={}", f4, f4.get());

        //shutdown
        es.shutdown();
    }

    /**
     * fake computation task, just sleep for a while
     */
    static class ComputationTask implements Runnable {

        @Override
        public void run() {
            try {
                logger.info("start doing heavy work now!", Thread.currentThread().getId());
                Thread.sleep(1000L);
                logger.info("work done", Thread.currentThread().getId());
            } catch (InterruptedException e) {
                logger.info("something happened", e);
            }
        }
    }

}
