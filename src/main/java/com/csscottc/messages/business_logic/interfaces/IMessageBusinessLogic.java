package com.csscottc.messages.business_logic.interfaces;

import com.csscottc.messages.models.Message;

public interface IMessageBusinessLogic {
    public Message getMessage(String messageId);
    public void createMessage(Message message);
}
