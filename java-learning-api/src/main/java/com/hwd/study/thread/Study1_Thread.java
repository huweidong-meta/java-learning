package com.hwd.study.thread;

/**
 * 线程的学习：继承Thread类、实现Runnable接口、实现Callable接口、使用线程池
 *
 * 继承 Thread 类：Thread类也实现了Runnable接口
 *
 */
public class Study1_Thread {

    public static void main(String[] args) throws InterruptedException{
        MyThread myThread = new MyThread();
        myThread.start();   //  启动线程的方法。最终会执行MyThread的run方法。
//        myThread.run();   //  run方法就是一个普通方法，没有真正的启动一个线程，run方法执行完毕才会向下执行
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
            System.out.println("线程名：" + Thread.currentThread().getName());
        }
//        myThread.interrupt();
//        Thread.yield();
//        myThread.join();
    }


    static class MyThread extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println("线程名："+ Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

