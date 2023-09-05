package org.example;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // same with MethodBeforeAdvice
        System.out.println("around - before method: " + invocation.getMethod().getName());
        try {
            // proceed to original method call
            Object result = invocation.proceed();
            // same with AfterReturningAdvice
            System.out.println("around - after method: " + invocation.getMethod().getName());
            return result;
        } catch (IllegalArgumentException e) {
            // same with ThrowsAdvice
            System.out.println("around - throw advice method: " + invocation.getMethod().getName());
            throw e;
        }
    }
}
