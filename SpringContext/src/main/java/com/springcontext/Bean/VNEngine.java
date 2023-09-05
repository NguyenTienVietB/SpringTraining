package com.springcontext.Bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("VNEngine")
@Primary
public class VNEngine implements Engine {
    @Override
    public void run() {
        System.out.println("Running Vietnamese Engine");
    }
}

