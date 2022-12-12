package com.api.service;

public interface TestModelService <T> {
    void saveModel(T t);
    void findModel(String id);
    void findAllModel();

}
