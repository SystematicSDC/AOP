package com.systematic.aop.workshop.controllers;

import com.systematic.aop.workshop.services.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;


@Controller
public class ConnectionController {

    ConnectionService connectionService;

    @Autowired
    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @PostConstruct
    public void init() throws InterruptedException {
        connectionService.connect();
    }
}
