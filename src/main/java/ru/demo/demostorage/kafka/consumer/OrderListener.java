package ru.demo.demostorage.kafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

/**
 * Лисенер для заказов.
 */
@RequiredArgsConstructor
@Slf4j
public class OrderListener {

    @Value("${kafka.topic.storage}")
    private final String topicName;

    @KafkaListener(topics = "storage", groupId = "storage-group", containerFactory = "singleFactory")
    public void listen(@Payload String message, @Headers Map<String, Object> headers) {
        log.debug("Получено сообщение {} в топик {}", message, topicName);
    }
}
