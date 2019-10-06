package ru.itis.web.services;

import ru.itis.web.models.Message;

public interface MessageService {
    Message saveMessage(Message message);
}
