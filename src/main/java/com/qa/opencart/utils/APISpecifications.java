package com.qa.opencart.utils;

import com.qa.opencart.constants.AppConstant;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class APISpecifications {

    public static RequestSpecification createIssueSpecs() {
      return new RequestSpecBuilder().setContentType(ContentType.JSON)
                .addHeader("Authorization", AppConstant.AUTHORIZATION).build();

    }

    public static ResponseSpecification createIssueResponseSpecs(int statusCode){
      return new ResponseSpecBuilder().expectStatusCode(statusCode).build();
    }

}
