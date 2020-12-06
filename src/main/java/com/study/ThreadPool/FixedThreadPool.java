package com.study.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author： XCC
 * @date： 2020/12/6 6:33 下午
 * @description： TODO FixedThreadPool演示
 * @modifiedBy： 线程池练习
 * @version: 1.0
 */
public class FixedThreadPool {

    public static void main(String[] args) {

        /**
         *
         * FixedThreadPool，也就是可重用固定线程数的线程池。 它corePoolSize和 maximumPoolSize是一样的。
         * 并且他的keepAliveTime=0， 也就是当线程池中的线程数大于corePoolSize， 多余的空闲线程会被立即终止。
         *
         *
         * FixedThreadPool只有核心线程，且数量固定，没有非核心线程。
         * FixedThreadPool是一个有固定核心线程数的线程池，且这些核心线程不会被回收。
         * 当线程数超过corePoolSize时，就把任务存进任务队列。若线程池有空闲线程，就去任务队列中取任务。
         *
         * newFixedThreadPool
         * 由于传进去的LinkedBlockingQueue是没有容量上限的，所以当请求数越来越多，并且无法及时处理完毕的时候，
         * 也就是请求堆积的时候，会容易造成占用大量的内存，可能会导致0OM。
         *
         * 基本执行过程：
         * 1、如果当前运行的线程数少于corePoolSize，会立即创建新的线程执行任务。
         * 2、当线程数达到corePoolSize后，会将任务加入到LinkedBlockingQueue中。
         * 3、当线程执行完任务后，会循环从LinkedBlockingQueue中获取任务来执行。
         *
         */

        // FixedThreadPool是可重用固定线程数的线程池，nThreads为固定线程数
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i=0;i<1000;i++){
            executorService.execute(new Task());
        }
    }

}


class Task implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}