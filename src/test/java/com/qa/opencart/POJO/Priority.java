package com.qa.opencart.POJO;

import com.qa.opencart.enums.PriorityType;

public class Priority {

    public Priority(){}

    public Priority(String name){
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
