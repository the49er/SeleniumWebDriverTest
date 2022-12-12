package com.api.service;

import com.api.model.AccountInfoModel;
import com.api.repository.ModelRepository;

public class TestModelServiceImp implements TestModelService<AccountInfoModel> {
    ModelRepository modelRepository = ModelRepository.getInstance();

    @Override
    public void saveModel(AccountInfoModel accountInfoModel) {
    }

    @Override
    public void findModel(String id) {

    }

    @Override
    public void findAllModel() {

    }
}
