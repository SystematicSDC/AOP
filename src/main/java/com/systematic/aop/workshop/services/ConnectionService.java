package com.systematic.aop.workshop.services;

import com.systematic.aop.workshop.model.Counter;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ConnectionService {

    Counter INSTANCE = Counter.getInstance();

    public void connect() throws InterruptedException {

        if (INSTANCE.getCounter() == 4) {
            System.out.println(".............................");
            System.out.println("Connection established ...");
            Counter.resetCounter();
        } else {
            System.out.println(".............................");
            System.out.println("Trying to connect ... #"+ INSTANCE.getCounter());
            TimeUnit.SECONDS.sleep(2);
            System.out.println("No response from third party ...");
            Counter.addToCounter();
            throw new IllegalStateException("This is exception");
        }
    }
}
