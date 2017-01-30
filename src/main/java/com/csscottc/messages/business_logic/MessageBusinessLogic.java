package com.csscottc.messages.business_logic;

import javax.inject.Inject;
import javax.inject.Named;
import com.csscottc.messages.models.Message;
import com.csscottc.messages.business_logic.interfaces.IMessageBusinessLogic;
import com.csscottc.messages.repository.interfaces.IRepository;

@Named
public class MessageBusinessLogic implements IMessageBusinessLogic {

    public MessageBusinessLogic(IRepository<Message> messageRepository){
        this._messageRepository = messageRepository;
    }

    @Inject
    public IRepository<Message> _messageRepository;

    public Message getMessage(String messageId) {
        return _messageRepository.getById(messageId);
    }
    public void createMessage(Message message) {
        _messageRepository.save(message);
    }
}