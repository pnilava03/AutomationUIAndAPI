package com.qa.opencart.POJO;

import java.util.List;

public class Body {

    public Body(){}



    private String type;
    private List<ContentBlock> content;
    private int version;

    public List<ContentBlock> getContent() {
        return content;
    }

    public void setContent(List<ContentBlock> content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }







}
