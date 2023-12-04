package com.dsp.microservice.config;

import com.dsp.microservice.model.Bar;
import com.dsp.microservice.model.Foo;
import com.dsp.microservice.model.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionConfiguration {
    @Bean(value = "fooFirst")
    public Foo foo(){
        return new Foo();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public FooBar fooBar(@Qualifier("fooFirst") Foo foo, Bar bar){
        return new FooBar(foo, bar);
    }
}
