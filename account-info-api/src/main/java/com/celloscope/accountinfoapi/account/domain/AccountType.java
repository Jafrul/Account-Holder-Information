package com.celloscope.accountinfoapi.account.domain;

public class AccountType {

    private Long id;
    private String type;

    public AccountType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public AccountType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
