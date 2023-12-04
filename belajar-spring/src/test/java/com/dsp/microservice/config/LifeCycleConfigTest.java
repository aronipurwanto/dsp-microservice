package com.dsp.microservice.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LifeCycleConfigTest {
    @Test
    void testLifeCycle() {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        Connection connection = context.getBean(Connection.class);
        assertNotNull(connection);

        context.close();
    }
}