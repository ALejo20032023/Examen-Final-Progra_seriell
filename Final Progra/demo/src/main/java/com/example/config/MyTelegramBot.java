package com.example.config;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyTelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "AlejandroMorales_bot";
    }

    @Override
    public String getBotToken() {
        return "8035815183:AAHYVwr-8B3F6cVuhvHL9x9Aie0MbhrnM6I";
    }

    @Override
    public void onUpdateReceived(Update update) {
    }
}
