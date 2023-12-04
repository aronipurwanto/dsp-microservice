package com.dsp.microservice.service;

import com.dsp.microservice.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void start(){
        log.info("Product service start");
    }

    @PreDestroy
    public void stop(){
        log.info("Product service stop");
    }
}
