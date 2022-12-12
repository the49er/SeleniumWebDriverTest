package com.api.repository;

import com.api.model.AccountInfoModel;

import java.util.HashMap;
import java.util.Map;

public class ModelRepository {
    private static ModelRepository instance;
    private Map<String, AccountInfoModel> testModelList;


    private ModelRepository(){
        testModelList = new HashMap<>();
    }

    public static ModelRepository getInstance() {
        if(instance == null){
            instance = new ModelRepository();
        }
        return instance;
    }

    private Map<String, AccountInfoModel> getTestModelList(){
        return testModelList;
    }

    public void addModel(AccountInfoModel accountInfoModel){
        //getTestModelList().put(testModel.getId(), testModel);
    }


    public AccountInfoModel findModel(String id){
        return getTestModelList().get(id);
    }





}
