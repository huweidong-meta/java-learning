package com.hwd.study.thread;

/**
 * 线程的几种状态
 */
public class Study3_State {

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName()+"状态"+t.getState());
        t.start();

        while (Thread.State.TERMINATED != t.getState()){
            System.out.println(t.getName()+"状态"+t.getState());
            Thread.sleep(800);
        }
        System.out.println(t.getName()+"状态"+t.getState());
    }

    static class T extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println("子线程："+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
