package com.csscottc.messages.repository;

import javax.inject.Named;

import com.csscottc.messages.models.Message;
import com.csscottc.messages.repository.interfaces.IRepository;
import com.csscottc.messages.repository.qualifiers.InfluxDB;

@Named @InfluxDB
public class InfluxDBMessageRepository implements IRepository<Message> {
    public void save(Message message){
        throw new UnsupportedOperationException();
    }

    public void update(Message message){
        throw new UnsupportedOperationException();
    }

    public Message getById(String id){
        throw new UnsupportedOperationException();
    }

    public void remove(Message message){
        throw new UnsupportedOperationException();
    }
}