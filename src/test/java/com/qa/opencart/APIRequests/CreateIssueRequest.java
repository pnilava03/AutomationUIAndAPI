package com.qa.opencart.APIRequests;


import com.qa.opencart.POJO.Fields;

public class CreateIssueRequest {

    private Fields fields;

    public CreateIssueRequest(Fields fields) {
        this.fields = fields;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }


}
