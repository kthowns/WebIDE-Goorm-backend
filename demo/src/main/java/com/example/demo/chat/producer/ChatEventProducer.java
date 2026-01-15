package com.example.demo.chat.producer;

import com.example.demo.chat.event.ChatMessageEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatEventProducer {

    private static final String CHAT_MESSAGE_TOPIC = "chat.message";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishMessage(ChatMessageEvent event) {
        kafkaTemplate.send(
                CHAT_MESSAGE_TOPIC,
                String.valueOf(event.getRoomId()),
                event
        );
    }
}