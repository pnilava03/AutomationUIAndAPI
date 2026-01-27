package com.qa.opencart.POJO;

public class Issuetype {

    public Issuetype(){}
    public Issuetype(String name){
        this.name=name;
    }


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
