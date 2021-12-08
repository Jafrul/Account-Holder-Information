package com.celloscope.accountinfoapi.account.domain;

import java.util.Date;

public class AccountHolderInfo {
    private Long id;
    private String name;
    private int age;
    private Date dob;
    private String presentAddress;
    private String contactNo;
    private String gender;
    private String hobby;
    private Date accountCreateDate;
    private AccountType accountType;

    public AccountHolderInfo(Long id, String name, int age, Date dob, String presentAddress, String contactNo, String gender, String hobby, Date accountCreateDate, AccountType accountType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.presentAddress = presentAddress;
        this.contactNo = contactNo;
        this.gender = gender;
        this.hobby = hobby;
        this.accountCreateDate = accountCreateDate;
        this.accountType = accountType;
    }

    public AccountHolderInfo() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDob() {
        return dob;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getGender() {
        return gender;
    }

    public String getHobby() {
        return hobby;
    }

    public Date getAccountCreateDate() {
        return accountCreateDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setAccountCreateDate(Date accountCreateDate) {
        this.accountCreateDate = accountCreateDate;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
