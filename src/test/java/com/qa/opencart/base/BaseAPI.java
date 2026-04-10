package com.qa.opencart.base;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.APISpecifications;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseAPI {
    public void setBaseURI(String baseURL) {
        RestAssured.baseURI = baseURL;
    }

    public Response postRequest(String endPoint, Object payload) {
        return RestAssured.given()
                .spec(APISpecifications.createIssueSpecs())
                .body(payload)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .extract()
                .response();
    }

    public Response postIssueComment(String postIssueEndPoint, String issueId, Object payload){
        String finalEndPoint= AppConstant.CREATE_ISSUE+issueId+postIssueEndPoint;
        return RestAssured.given()
                .spec(APISpecifications.createIssueSpecs())
                .body(payload)
                .when()
                .post(finalEndPoint)
                .then()
                .assertThat()
                .extract()
                .response();
    }


    public Response updateIssueComment(String postIssueEndPoint, String issueId, String commentId, Object payload){
        String finalEndPoint= AppConstant.CREATE_ISSUE+issueId+postIssueEndPoint+commentId;
        return RestAssured.given()
                .spec(APISpecifications.createIssueSpecs())
                .body(payload)
                .when()
                .post(finalEndPoint)
                .then()
                .assertThat()
                .extract()
                .response();
    }

}
