package com.celloscope.accountinfoapi.account.adapter.out.persistence;



import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "account_info")
public class AccountHolderInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "account_holder_name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "address")
    private String presentAddress;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "gender")
    private String gender;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "account_create_date")
    private Date accountCreateDate;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountTypeEntity accountType;

    public AccountHolderInfoEntity(Long id, String name, int age, Date dob, String presentAddress, String contactNo, String gender, String hobby, Date accountCreateDate, AccountTypeEntity accountType) {
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

    public AccountHolderInfoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Date getAccountCreateDate() {
        return accountCreateDate;
    }

    public void setAccountCreateDate(Date accountCreateDate) {
        this.accountCreateDate = accountCreateDate;
    }

    public AccountTypeEntity getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypeEntity accountType) {
        this.accountType = accountType;
    }
}
