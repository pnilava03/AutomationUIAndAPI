package com.qa.opencart.POJO;

import java.util.List;

public class Description {

    public Description(){}

    private String type;
    private Integer version;
    private List<ContentBlock> content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<ContentBlock> getContent() {
        return content;
    }

    public void setContent(List<ContentBlock> content) {
        this.content = content;
    }



}
