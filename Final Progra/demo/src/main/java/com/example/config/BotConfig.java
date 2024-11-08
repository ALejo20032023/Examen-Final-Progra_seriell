package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class BotConfig {
    @Bean
    public MyTelegramBot telegramBot() {
        return new MyTelegramBot();
    }
}
