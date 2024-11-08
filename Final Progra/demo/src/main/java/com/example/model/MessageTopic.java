package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MessageTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topicName;
}
