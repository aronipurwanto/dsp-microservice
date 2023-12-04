package com.dsp.microservice.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {
    public void start(){
        log.info("Server start");
    }

    public void stop(){
        log.info("Server stop");
    }
}
