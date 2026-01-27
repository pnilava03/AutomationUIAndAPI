package com.qa.opencart.JIRAAPI;

import com.qa.opencart.Builder.JiraPayLoadBuilder;
import com.qa.opencart.APIRequests.CreateIssueRequest;
import com.qa.opencart.APIRequests.IssueComment;
import com.qa.opencart.APIRequests.UpdateComments;
import com.qa.opencart.utils.APISpecifications;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateIssue {

    CreateIssueRequest createIssueRequest = JiraPayLoadBuilder.buildIssue();
    IssueComment issueComment = JiraPayLoadBuilder.buildComment();
    UpdateComments issueCommentUpdate = JiraPayLoadBuilder.updateCommentBuild();
    String IssueId;
    String commentID;

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://pnilava03-1768910101561.atlassian.net";
    }

    @Test(priority = 0, enabled = true, alwaysRun = true)
    public void createNewBug() {
        String response = RestAssured.given()
                .log().all()
                .spec(APISpecifications.createIssueSpecs())
                .body(createIssueRequest).when()
                .log().all().post("/rest/api/3/issue")
                .then()
                .log().all()
                .spec(APISpecifications.createIssueResponseSpecs(201))
                .extract().response().asString();


        String key = createIssueRequest.getFields().getProject().getKey();
        System.out.println("Key is::======================>" + key);
        JsonPath jsonPath = new JsonPath(response);
        IssueId = jsonPath.getString("id");
        System.out.println("ID is:: " + IssueId);


    }


    @Test(priority = 1, dependsOnMethods = "createNewBug")
    public void createComment() {

        String response = RestAssured.given().spec(APISpecifications.createIssueSpecs())
                .log().all().body(issueComment)
                .when().log().all()
                .post("/rest/api/3/issue/" + IssueId + "/comment")
                .then()
                .spec(APISpecifications.createIssueResponseSpecs(201))
                .extract().response().asString();

        System.out.println("Response is: " + response);
        JsonPath jsonPath = new JsonPath(response);
        commentID = jsonPath.getString("id");
        System.out.println("Comment id is:: " + commentID);
    }

    @Test(priority = 2, dependsOnMethods = "createComment")
    public void updateComments() {

        String response = RestAssured.given().log().all().spec(APISpecifications.createIssueSpecs())
                .body(issueCommentUpdate)
                .when().log().all()
                .put("/rest/api/3/issue/" + IssueId + "/comment/" + commentID)
                .then().log().all().
                spec(APISpecifications.createIssueResponseSpecs(200))
                .extract().response().asString();


        System.out.println("Response: ======>" + response);
        JsonPath jsonPath = new JsonPath(response);
        String UpdateCommentID = jsonPath.getString("id");
        System.out.println("Update Comment Id is: " + UpdateCommentID);

    }


    @Test
    public void authExample(){
        RestAssured.given().auth().oauth2("accessToken");
    }

}
