package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private String messageFrequency;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
