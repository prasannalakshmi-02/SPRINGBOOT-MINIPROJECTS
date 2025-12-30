package com.prasanna.atm_simulation.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AtmAspect {

    @Before("execution(* com.prasanna.atm_simulation.service.AtmService.withdraw(..)) && args(amount)")
    public void verifyPin(int amount) {
        System.out.println("🔒 [SECURITY] Asking user for PIN...");

        if (amount > 10000) {
            System.out.println("🚨 [SECURITY] ALERT! High value transaction. PIN Required.");
            throw new RuntimeException("Invalid PIN for high amount!");
        }
        System.out.println("✅ [SECURITY] PIN Verified.");
    }

    @After("execution(* com.prasanna.atm_simulation.service.AtmService.deposit(..))")
    public void printReceipt() {
        System.out.println("🧾 [PRINTER] Printing Receipt: 'Deposit Successful'");
    }

    @Around("execution(* com.prasanna.atm_simulation.service.AtmService.withdraw(..))")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("⏱️ [TIMER] Transaction Started...");
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println("⏱️ [TIMER] Transaction Finished in " + (end - start) + "ms");

        return result;
    }
}