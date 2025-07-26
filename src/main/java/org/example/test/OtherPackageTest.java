package org.example.test;

import org.example.perf.logger.PerformanceLog;

public class OtherPackageTest {
    @PerformanceLog("[Test] Executing test logic")
    public  void doSomething() throws InterruptedException {
        Thread.sleep(200);
        helper();
    }

    @PerformanceLog("[Test] Executing helper logic")
    private  void helper() throws InterruptedException {
        Thread.sleep(200);
    }
}
