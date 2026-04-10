package com.AALife.Base;

import com.AALife.APISpecifictions.RequestSpec;
import com.AALife.APISpecifictions.ResponseSpec;
import com.AALife.utils.PropertiesFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class BaseAPI {

    private final PropertiesFile propertiesFile = new PropertiesFile("configFile.properties");

    public void setBaseURI(String baseURL) {
        RestAssured.baseURI = baseURL;
    }

    public Response getRequest(String endPoint) {
        return RestAssured.given()
                .spec(RequestSpec.getRequestSpecification(propertiesFile.getPropertiesValue("Restful_Booker")))
                .when()
                .get(endPoint)
                .then()
                .assertThat()
                .extract()
                .response();
    }

    public Response getRequestWithQueryParams(String endPoint, Map<String, String> queryParams) {
        return RestAssured.given()
                .spec(RequestSpec.getRequestSpecification(propertiesFile.getPropertiesValue("Restful_Booker")))
                .queryParams(queryParams)
                .when()
                .get(endPoint)
                .then()
                .assertThat()
                .extract()
                .response();
    }

    public Response postRequest(String endPoint, Object payload) {
        return RestAssured.given()
                .spec(RequestSpec.getRequestSpecification(propertiesFile.getPropertiesValue("Restful_Booker")))
                .body(payload)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .extract()
                .response();
    }

}
