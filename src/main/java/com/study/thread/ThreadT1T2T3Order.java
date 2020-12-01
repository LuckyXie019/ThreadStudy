package com.study.thread;

/**
 * @program: test
 * @description:
 * @author: Mr.Xie
 * @create: 2020-12-01 17:49
 **/
public class ThreadT1T2T3Order {

    /**
     * 多线程题（一）：现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
     *
     * 要保证T1、T2、T3三个线程顺序执行，可以利用Thread类的join方法。
     *
     */

    public static void main(String[] args) throws InterruptedException {
        ThreadJoinTest t1 = new ThreadJoinTest("哈哈");
        ThreadJoinTest t2 = new ThreadJoinTest("嘎嘎");
        ThreadJoinTest t3 = new ThreadJoinTest("呵呵");
        // 通过join()方法来保证T1、T2、T3的顺序
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();

        /**
         * 输入结果：
         * 哈哈:0
         * 哈哈:1
         * 哈哈:2
         * 哈哈:3
         * 嘎嘎:0
         * 嘎嘎:1
         * 嘎嘎:2
         * 嘎嘎:3
         * 呵呵:0
         * 呵呵:1
         * 呵呵:2
         * 呵呵:3
         */

    }


    static class ThreadJoinTest extends Thread {

        public ThreadJoinTest(String name){
            super(name);
        }

        /**
         * If this thread was constructed using a separate
         * <code>Runnable</code> run object, then that
         * <code>Runnable</code> object's <code>run</code> method is called;
         * otherwise, this method does nothing and returns.
         * <p>
         * Subclasses of <code>Thread</code> should override this method.
         *
         * @see #start()
         * @see #stop()
         */
        @Override
        public void run() {
            for (int i=0;i<4;i++){
                System.out.println(this.getName()+":"+i);
            }
        }
    }


}
