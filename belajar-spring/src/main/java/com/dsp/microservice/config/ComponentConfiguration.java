package com.dsp.microservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.dsp.microservice.service"})
public class ComponentConfiguration {

}
