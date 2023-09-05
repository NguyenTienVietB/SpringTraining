package com.springcontext.SpringContext;

import com.springcontext.Bean.Engine;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class SpringContextDemo {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringContextApplication.class, args);
        Engine engine = context.getBean(Engine.class);
        engine.run();
    }
}
