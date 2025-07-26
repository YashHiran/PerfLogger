package org.example;

import org.example.perf.logger.PerformanceLog;
import org.example.test.OtherPackageTest;

public class Main {

    @PerformanceLog("Executing test logic")
    public static void doSomething() throws InterruptedException {
        Thread.sleep(200);
        helper();
    }

    @PerformanceLog("Executing helper logic")
    private static void helper() throws InterruptedException {
        Thread.sleep(200);
    }

    @PerformanceLog
    public static void main(String[] args) throws InterruptedException {
        doSomething();
        new OtherPackageTest().doSomething();
    }
}
