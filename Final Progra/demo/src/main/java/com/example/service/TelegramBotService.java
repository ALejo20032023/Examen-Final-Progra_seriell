/*package com.example.service;

import com.example.model.ChatMessage;
import com.example.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
@Service
public class TelegramBotService {
    private final ChatMessageRepository chatMessageRepository;
    private final String botToken;

    @Autowired
    public TelegramBotService(ChatMessageRepository chatMessageRepository, @Value("${telegram.bot.token}") String botToken) {
        this.chatMessageRepository = chatMessageRepository;
        this.botToken = botToken;
    }

    public void handleUpdate(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            Long Id = update.getMessage().getChatId();

            // Aquí se llama a la API de OpenAI para obtener una respuesta
            String botResponse = "Respuesta simulada de ChatGPT";

            // Guardar el mensaje en la base de datos
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.Id(Id);
            chatMessage.setmessage(message);
            chatMessage.setBotResponse(botResponse);
            chatMessage.settimestamp(System.currentTimeMillis());
            chatMessageRepository.save(chatMessage);

            // Aquí enviarías la respuesta al usuario usando Telegram API
        }
    }
}*/
package com.example.service;

import com.example.config.MyTelegramBot;
import com.example.model.ChatMessage;
import com.example.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.time.LocalDateTime;


@Service
public class TelegramBotService {
    private final ChatMessageRepository chatMessageRepository;
    private final MyTelegramBot telegramBot;
    private final String botToken;

    @Autowired
    public TelegramBotService(ChatMessageRepository chatMessageRepository, MyTelegramBot telegramBot, @Value("${telegram.bot.token}") String botToken) {
        this.chatMessageRepository = chatMessageRepository;
        this.telegramBot = telegramBot;
        this.botToken = botToken;
    }

    public void handleUpdate(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            Long Id = update.getMessage().getChatId();

            String botResponse = "Respuesta simulada de ChatGPT";

            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setId(Id);
            chatMessage.setMessage(message);
            chatMessage.setResponse(botResponse);
            chatMessage.setTimestamp(LocalDateTime.now());
            chatMessageRepository.save(chatMessage);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(Id.toString());
            sendMessage.setText(botResponse);

            try {
                telegramBot.execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}