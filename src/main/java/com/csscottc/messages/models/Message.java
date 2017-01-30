package com.csscottc.messages.models;

public class Message {

    private String sender;
    private String message;

    public String getSender(){
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public void setSender(String sender){
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return this.sender + ": " + this.message;
    }
}
