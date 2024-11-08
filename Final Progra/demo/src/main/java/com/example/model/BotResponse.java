package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class BotResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String responseContent;
    private LocalDateTime timestamp;

    @OneToOne
    @JoinColumn(name = "chat_message_id")
    private ChatMessage chatMessage;
}
