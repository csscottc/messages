package com.csscottc.messages.repository.interfaces;

public interface IRepository<T> {
    public void save(T t);
    public void update(T t);
    public T getById(String id);
    public void remove(T t);
} 