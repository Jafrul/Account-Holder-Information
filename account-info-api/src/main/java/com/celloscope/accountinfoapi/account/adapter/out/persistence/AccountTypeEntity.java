package com.celloscope.accountinfoapi.account.adapter.out.persistence;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class AccountTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_type_id")
    private Long id;

    @Column(name = "account_type")
    private String type;

    public AccountTypeEntity(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public AccountTypeEntity() {
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
