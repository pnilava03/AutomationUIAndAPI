package com.qa.opencart.CommonMethods;

import io.restassured.response.Response;
import org.testng.Assert;

public class AssertionUtil {

    //verify statusCode
    public static void verifyStatusCode(Response response, int expectedStatusCode){
        Assert.assertEquals(response.getStatusCode(),expectedStatusCode,"Status Code mismatch");

    }

    //Verify response time
    public static void verifyResponseTime(Response response, long maxTime) {
        Assert.assertTrue(response.getTime() <= maxTime,
                "Response time exceeded. Actual: " + response.getTime());
    }

    // Field Value Validation
    public static void verifyField(Response response, String jsonPath, Object expectedValue){
        Object actualValue= response.jsonPath().get(jsonPath);
        Assert.assertEquals(actualValue,expectedValue,"Mismatch for field "+jsonPath);
    }

    //verify field not null
    public static void verifyFieldNotNull(Response response, String jsonPath){
        Object value= response.jsonPath().get(jsonPath);
        Assert.assertNotNull(value,"Filed is null:: "+jsonPath);
    }

    //verify field exists
    public static void verifyFieldExists(Response response, String jsonPath){
        boolean exists= response.jsonPath().get(jsonPath)!=null;
        Assert.assertTrue(exists,"Field does not exists :: "+jsonPath);
    }

    //Header validation
    public static void headerValidation(Response response, String headerName, String expectedValue){
        String actualHeader= response.getHeader(headerName);
        Assert.assertEquals(actualHeader, expectedValue,"Header mismatch:: "+headerName);
    }

    //contentType validation
    public static void contentTypeValidation(Response response, String expectedContentType){
        String actualContent= response.getContentType();
        Assert.assertTrue(actualContent.contains(expectedContentType),"Invalid Content Type ::"+actualContent);
    }
}
