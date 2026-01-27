package com.qa.opencart.APIRequests;

import com.qa.opencart.POJO.Body;
import com.qa.opencart.POJO.Visibility;

public class UpdateComments {


    private Body body;

    public void setBody(Body body) {
        this.body = body;
    }

    private Visibility visibility;

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }



    public Body getBody() {
        return body;
    }


}
