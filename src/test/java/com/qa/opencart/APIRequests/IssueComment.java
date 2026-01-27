package com.qa.opencart.APIRequests;

import com.qa.opencart.POJO.Body;

public class IssueComment {

    public  IssueComment(Body body){
        this.body=body;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    private Body body;




}
