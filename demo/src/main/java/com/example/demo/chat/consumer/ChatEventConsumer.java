package com.example.demo.chat.consumer;

import com.example.demo.auth.User;
import com.example.demo.auth.UserRepository;
import com.example.demo.chat.entity.ChatMessage;
import com.example.demo.chat.entity.ChatRoom;
import com.example.demo.chat.event.ChatMessageEvent;
import com.example.demo.chat.repository.ChatMessageRepository;
import com.example.demo.chat.repository.ChatRoomRepository;
import com.example.demo.common.CustomException;
import com.example.demo.common.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChatEventConsumer {

    private final ChatMessageRepository messageRepository;
    private final ChatRoomRepository roomRepository;
    private final UserRepository userRepository;
    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "chat.message", groupId = "chat-group")
    @Transactional
    public void consumeMessage(ChatMessageEvent event) {
        log.info("==========================================");
        log.info("Kafka 메시지 수신!");
        log.info("roomId: {}", event.getRoomId());
        log.info("userId: {}", event.getUserId());
        log.info("username: {}", event.getUsername());
        log.info("content: {}", event.getContent());
        log.info("timestamp: {}", event.getTimestamp());
        log.info("==========================================");

        try {
            ChatMessage savedMessage = saveMessage(event);
            log.info("✓ DB 저장 완료 - Message ID: {}", savedMessage.getId());

            String destination = "/topic/chat/" + event.getRoomId();
            log.info("→ WebSocket 브로드캐스트 시도");
            log.info("  Destination: {}", destination);
            log.info("  Event: {}", event);

            messagingTemplate.convertAndSend(destination, event);

            log.info("✓ WebSocket 브로드캐스트 완료!");

        } catch (CustomException e) {
            log.error("✗ 비즈니스 로직 오류: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("✗ 메시지 처리 중 예상치 못한 오류!", e);
            throw new CustomException(ErrorMessage.CHAT_SEND_ERROR);
        }
    }

    private ChatMessage saveMessage(ChatMessageEvent event) {
        ChatRoom room = roomRepository.findById(event.getRoomId())
                .orElseThrow(() -> new CustomException(ErrorMessage.CHAT_LOAD_ERROR));

        User user = userRepository.findById(event.getUserId())
                .orElseThrow(() -> new CustomException(ErrorMessage.USER_NOT_FOUND));

        ChatMessage message = new ChatMessage();
        message.setChatRoom(room);
        message.setUser(user);
        message.setContent(event.getContent());

        return messageRepository.save(message);
    }
}