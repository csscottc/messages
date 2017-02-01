package com.csscottc.messages.business_logic;

import javax.inject.Inject;
import javax.inject.Named;
import com.csscottc.messages.models.Message;
import com.csscottc.messages.business_logic.interfaces.IMessageBusinessLogic;
import com.csscottc.messages.repository.RepositoryFactory;
import com.csscottc.messages.repository.RepositoryType;
import com.csscottc.messages.repository.interfaces.IRepository;

@Named
public class MessageBusinessLogic implements IMessageBusinessLogic {

    //This might not be required
    private RepositoryFactory _repositoryFactory;

    @Inject
    public MessageBusinessLogic(RepositoryFactory repositoryFactory){
        this._repositoryFactory = repositoryFactory;
        this._messageRepository = _repositoryFactory.getRepository(RepositoryType.MongoDB);
    }

    private IRepository<Message> _messageRepository;

    public Message getMessage(String messageId) {
        return _messageRepository.getById(messageId);
    }
    public void createMessage(Message message) {
        _messageRepository.save(message);
    }
}