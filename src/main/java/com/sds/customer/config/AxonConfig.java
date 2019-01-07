package com.sds.customer.config;

import com.sds.customer.command.CreateCustomerCommand;
import com.sds.customer.handler.CreateCustomerCommandHandler;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.spring.config.annotation.AnnotationCommandHandlerBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Bean
    public CommandGateway defaultCommandGateway() {
        return DefaultCommandGateway.builder().commandBus(simpleCommandBus()).build();
    }

    @Bean
    public SimpleCommandBus simpleCommandBus() {
        SimpleCommandBus simpleCommandBus = new SimpleCommandBus.Builder().build();
        return simpleCommandBus;
    }

    @Bean
    public AnnotationCommandHandlerBeanPostProcessor annotationCommandHandlerBeanPostProcessor() {
        AnnotationCommandHandlerBeanPostProcessor annotationCommandHandlerBeanPostProcessor = new AnnotationCommandHandlerBeanPostProcessor();
        return annotationCommandHandlerBeanPostProcessor;
    }

}
