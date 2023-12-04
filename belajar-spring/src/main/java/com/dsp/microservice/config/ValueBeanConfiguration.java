package com.dsp.microservice.config;

import com.dsp.microservice.model.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ValueBeanConfiguration {

    @Primary
    @Bean(value = "fooFirst")
    public Foo foo1(){
        Foo foo = new Foo();
        return foo;
    }
    @Bean(value = "fooSecond")
    public Foo foo2(){
        Foo foo = new Foo();
        return foo;
    }
}
