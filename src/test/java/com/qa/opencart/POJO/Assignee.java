package com.qa.opencart.POJO;

public class Assignee {

    public Assignee(){}
    public Assignee(String accountId){
        this.accountId=accountId;
    }


    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
