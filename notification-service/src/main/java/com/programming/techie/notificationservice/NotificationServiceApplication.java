package com.programming.techie.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@SpringBootApplication
@EnableEurekaClient
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @Bean
    public Consumer<Message<OrderDto>> notificationEventSupplier() {
        return message -> {
            try {
                new EmailSender().sendEmail(message.getPayload());
            } catch (InterruptedException e) {
                throw new RuntimeException("Something went wrong while sending email");
            }
        };
    }
}
