package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private String response;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "message_topic_id")
    private MessageTopic messageTopic;

    @Enumerated(EnumType.STRING)
    private Relevance relevance;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;
}
