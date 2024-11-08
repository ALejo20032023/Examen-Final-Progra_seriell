package com.example.controller;

import com.example.service.TelegramBotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;


@RestController
public class TelegramBotController {

    private final TelegramBotService telegramBotService;
    public TelegramBotController(TelegramBotService telegramBotService) {
        this.telegramBotService = telegramBotService;
    }
    @PostMapping("/webhook")
    public void handleUpdate(@RequestBody Update update) {
        telegramBotService.handleUpdate(update);
    }
}
