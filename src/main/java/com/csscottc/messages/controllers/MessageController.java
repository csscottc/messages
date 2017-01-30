package com.csscottc.messages.controllers;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.csscottc.messages.business_logic.interfaces.IMessageBusinessLogic;
import com.csscottc.messages.models.Message;

@RestController
@RequestMapping("/messages")
public class MessageController {

    public MessageController(IMessageBusinessLogic messageBusinessLogic){
        this._messageBusinessLogic = messageBusinessLogic;
    }

    @Inject
    IMessageBusinessLogic _messageBusinessLogic;

    @RequestMapping(method = RequestMethod.GET)
    public Message getMessage(@RequestParam String id){
        return _messageBusinessLogic.getMessage(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createMessage(@RequestBody Message message){
        System.out.println(message.toString());
        _messageBusinessLogic.createMessage(message);
    }

}