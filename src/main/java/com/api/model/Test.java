package com.api.model;

public class Test {
    public static void main(String[] args) {
        AccountInfoModel accountInfoModel = new AccountInfoModel();
        accountInfoModel.setId("1");
        accountInfoModel.setAccountName("Test");
        accountInfoModel.setAccountType("Savings");
        accountInfoModel.setBalance("123");
        accountInfoModel.setCurrency("USD");

        System.out.println("testModel = " + accountInfoModel);
    }
}
