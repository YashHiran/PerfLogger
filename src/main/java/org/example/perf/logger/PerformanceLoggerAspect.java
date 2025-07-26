package org.example.perf.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public final class PerformanceLoggerAspect {

    @Around("execution(@org.example.perf.logger.PerformanceLog * *(..)) && @annotation(performanceLog)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, PerformanceLog performanceLog) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        long duration = System.nanoTime() - start;

        String methodName = joinPoint.getSignature().getName();

        String logMsg = "Time Taken: " +
                (duration / 1_000_000) + " ms" +
                " | Method: " + methodName +
                (performanceLog.value().isEmpty() ? "" : " | " + performanceLog.value());


        System.out.println(logMsg);

        return result;
    }
}
