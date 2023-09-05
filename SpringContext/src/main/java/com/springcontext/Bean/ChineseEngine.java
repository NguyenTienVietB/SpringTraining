package com.springcontext.Bean;

import org.springframework.stereotype.Component;

@Component("CNEngine")
public class ChineseEngine implements Engine {
    @Override
    public void run() {
        System.out.println("Running ChineseEngine");
    }
}
