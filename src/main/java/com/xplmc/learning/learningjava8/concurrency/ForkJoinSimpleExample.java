package com.xplmc.learning.learningjava8.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * this is java 7 feature, fork and join simple example
 * sum 1+2+3+···+N
 */
public class ForkJoinSimpleExample {

    private static final Logger logger = LoggerFactory.getLogger(ForkJoinSimpleExample.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //single thread
        long start = System.currentTimeMillis();
        final long n = Integer.MAX_VALUE * 10L;
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i;
        }
        logger.info("1+2+3+···+{}={}", n, sum);
        logger.info("single thread cost:{}", System.currentTimeMillis() - start);

        //fork join
        start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        Future<Long> f1 = pool.submit(new SumTask(1, n));
        logger.info("1+2+3+···+{}={}", n, f1.get());
        logger.info("fork join cost:{}", System.currentTimeMillis() - start);
    }

    /**
     * simple sum task that extends RecursiveTask
     */
    static class SumTask extends RecursiveTask<Long> {

        private static long THRESHOLD = 1000000;

        private static AtomicInteger COUNT = new AtomicInteger();

        private long start;

        private long end;

        SumTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            //end - start <= THRESHOLD, consider it a small task, compute it
            long sum = 0;
            if (end - start <= THRESHOLD) {
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                //consider it a large task, split it
                long middle = (start + end) / 2;
                SumTask t1 = new SumTask(start, middle);
                SumTask t2 = new SumTask(middle + 1, end);
                //fork
                t1.fork();
                t2.fork();
                //join
                sum = t1.join() + t2.join();
                logger.trace("split count:{}", COUNT.incrementAndGet());
            }
            return sum;
        }
    }

}
