package com.api.model;

import lombok.Data;


@Data
public class AccountInfoModel {
    private String id;
    private String accountName;
    private String accountType;
    private String currency;
    private String balance;
}
