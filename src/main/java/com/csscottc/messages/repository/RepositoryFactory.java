package com.csscottc.messages.repository;

import javax.inject.Inject;
import javax.inject.Named;

import com.csscottc.messages.models.Message;
import com.csscottc.messages.repository.interfaces.IRepository;
import com.csscottc.messages.repository.qualifiers.InfluxDB;
import com.csscottc.messages.repository.qualifiers.MongoDB;

@Named
public class RepositoryFactory {
    
    private final IRepository<Message> _mongoMessageRepository;
    private final IRepository<Message> _influxMessageRepository;


    @Inject
    public RepositoryFactory(@MongoDB IRepository<Message> mongoMessageRepository,
        @InfluxDB IRepository<Message> influxDBMessageRepository){
            this._mongoMessageRepository = mongoMessageRepository;
            this._influxMessageRepository = influxDBMessageRepository;
    }

    public  IRepository<Message> getRepository(RepositoryType type) {
        switch(type){
            case MongoDB:
                return this._mongoMessageRepository;
            case InfluxDB:
                return this._influxMessageRepository;
            default:
                return null;
        }
    }

}