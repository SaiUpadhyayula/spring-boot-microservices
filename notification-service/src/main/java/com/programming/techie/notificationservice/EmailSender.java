package com.programming.techie.notificationservice;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailSender {

    @SneakyThrows
    public void sendEmail(OrderDto orderDto) {
        log.info("Sending Email Confirmation for Order - {}", orderDto.getOrderNumber());
        Thread.sleep(100);
        log.info("Email Sent!!");
    }
}
