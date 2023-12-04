package com.dsp.microservice.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductService {
    @PostConstruct
    public void start(){
        log.info("Product service start");
    }

    @PreDestroy
    public void stop(){
        log.info("Product service stop");
    }
}
