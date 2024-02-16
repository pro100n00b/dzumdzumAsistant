package com.example.dzumdzumAsistant.botConfig;

import com.example.dzumdzumAsistant.handlers.Handlers;
import com.example.dzumdzumAsistant.parser.PutInfo;
import com.example.dzumdzumAsistant.service.HeroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
public class Bot extends TelegramLongPollingBot {


    private HeroServiceImpl heroService;

    private Handlers handlers;
    private PutInfo putInfo;
    private final DeleteMessage deleteMessage = new DeleteMessage();


    @Autowired
    public Bot(HeroServiceImpl heroService, PutInfo putInfo, Handlers handlers) {
        this.heroService = heroService;
        this.putInfo = putInfo;
        this.handlers = handlers;
    }

    @Override
    public String getBotUsername() {
        return "dzumdzummAsistant";
    }

    @Override
    public String getBotToken() {
        return "5447733809:AAFRB1Q2yxTjzWygKoT8u2cvlHsC3nj8pPk";
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {

            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            deleteMessage.setChatId(chatId);
            deleteMessage.setMessageId(update.getMessage().getMessageId());

            try {
                execute(deleteMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }


            switch (messageText) {
                case "start" -> sendMessage(
                        chatId,
                        "Привет! Я помогу узнать винрейт твоего говна-героя"
                );

                case "top" -> {
                    sendMessage(chatId,

                            handlers.getTop());
                }
                case null, default -> {
                    putInfo.getHeroes(Integer.parseInt(messageText));
                }

            }

        }
    }

    public void sendMessage(Long chatId, String messageText) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(messageText);
        sendMessage.setChatId(chatId);
        try {
            executeAsync(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}



