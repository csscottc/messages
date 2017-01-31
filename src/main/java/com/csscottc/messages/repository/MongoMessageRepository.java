package com.csscottc.messages.repository;

import com.csscottc.messages.models.Message;
import com.csscottc.messages.repository.interfaces.IRepository;
import com.csscottc.messages.repository.qualifiers.MongoDB;
import com.google.gson.Gson;



import org.bson.Document;
import org.bson.types.ObjectId;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import javax.inject.Named;

@Named @MongoDB
public class MongoMessageRepository implements IRepository<Message> {
    public void save(Message message){
        try(MongoClient mongoClient = new MongoClient("localhost",27017)){ 
            MongoDatabase mongoDatabase = mongoClient.getDatabase("csscottc-messages");
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("messages");
            Document document = new Document();
            document.append("sender", message.getSender());
            document.append("message", message.getMessage());
            mongoCollection.insertOne(document);
        }catch(Error err){
            System.out.println(err);
        }
    }

    public void update(Message message){

    }

    public Message getById(String id){
        Message returnMessage = null;
        try(MongoClient mongoClient = new MongoClient("localhost",27017)){
            MongoDatabase mongoDatabase = mongoClient.getDatabase("csscottc-messages");
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("messages");
            ObjectId dbid = new ObjectId(id);
            String result = mongoCollection.find(eq("_id", dbid)).first().toJson();
            Gson gson = new Gson();
            Message msg = gson.fromJson(result, Message.class);
            return msg;
        }catch(Error err){
            System.out.println(err);
            return returnMessage;
        }
    }

    public void remove(Message message){

    }
}