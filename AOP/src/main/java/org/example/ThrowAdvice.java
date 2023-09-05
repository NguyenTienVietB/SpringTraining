package org.example;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThrowAdvice implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("throw advice method: " );
    }

    public static class App
    {
            public static void main(String[] args) throws Exception {
                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                Hello hello = (Hello) context.getBean("helloProxy");
                hello.method1();
                hello.method2();
                hello.method3();
            }
    }
}
