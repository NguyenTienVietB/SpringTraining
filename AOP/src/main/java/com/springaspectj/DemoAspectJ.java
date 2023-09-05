package com.springaspectj;

import com.springaspectj.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoAspectJ {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = (Hello) context.getBean("helloAspect");
        hello.method1();
        hello.method2();
        hello.method3();
    }
}
