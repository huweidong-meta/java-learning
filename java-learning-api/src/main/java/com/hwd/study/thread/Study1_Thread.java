package com.hwd.study.thread;

/**
 * 线程的学习：继承Thread类、实现Runnable接口、实现Callable接口、使用线程池
 *
 * 继承 Thread 类：Thread类也实现了Runnable接口
 *
 */
public class Study1_Thread extends Thread{

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
    }
}
