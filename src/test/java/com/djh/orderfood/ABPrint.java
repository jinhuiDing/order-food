package com.djh.orderfood;

import java.util.concurrent.locks.LockSupport;

public class ABPrint {
    public static Thread a = null;
    public static Thread b = null;

    public static void main(String[] args) {
        lockSupport();
    }

    public static void lockSupport() {
        char[] dataOne = "123456".toCharArray();
        char[] dataTwo = "ABCDEF".toCharArray();
        a = new Thread(() -> {
            for (char val : dataOne) {
                System.out.println(val);
                LockSupport.unpark(b);
                LockSupport.park();
            }
        });
        b = new Thread(() -> {
            for (char val : dataTwo) {
                LockSupport.park();
                System.out.println(val);
                LockSupport.unpark(a);
            }
        });

        a.start();
        b.start();
    }

}