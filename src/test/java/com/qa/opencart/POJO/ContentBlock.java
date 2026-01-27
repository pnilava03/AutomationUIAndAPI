package com.qa.opencart.POJO;

import java.util.List;

public class ContentBlock {

    public ContentBlock(){}


   private String type;
    private List<TextNode> content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TextNode> getContent() {
        return content;
    }

    public void setContent(List<TextNode> content) {
        this.content = content;
    }




}
