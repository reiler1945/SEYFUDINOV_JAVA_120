package ru.itis.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.web.models.Message;
import ru.itis.web.repositories.MessageRepository;

@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    @Transactional
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
