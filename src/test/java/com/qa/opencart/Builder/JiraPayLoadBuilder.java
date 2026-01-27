package com.qa.opencart.Builder;

import com.qa.opencart.APIRequests.CreateIssueRequest;
import com.qa.opencart.APIRequests.IssueComment;
import com.qa.opencart.APIRequests.UpdateComments;
import com.qa.opencart.POJO.*;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.enums.PriorityType;

import java.util.List;

public class JiraPayLoadBuilder {

    public static CreateIssueRequest buildIssue() {
        Project project = new Project(AppConstant.PROJECT_KEY);
        Priority priority = new Priority(String.valueOf(PriorityType.Medium.toString()));
        Assignee assignee = new Assignee(AppConstant.ASSIGNEE);
        Issuetype issueType = new Issuetype(AppConstant.ISSUE_TYPE);

        String desText = "Steps to Reproduce:\n" +
                "1. Open the application.\n" +
                "2. Navigate to the User Registration page.\n" +
                "3. Enter valid user details.\n" +
                "4. Click on the Continue button.\n" +
                "\nExpected Result:" +
                "\nUser should proceed to the next registration step." +
                "\nActual Result:" +
                "\nContinue button does not respond and user remains on the same page.\n" +
                "\nEnvironment:" +
                "\nBrowser: Chrome" +
                "\nOS: Windows" +
                "\nBuild: QA Environment";


        TextNode textNode = new TextNode();
        textNode.setType("text");
        textNode.setText(desText);

        ContentBlock contentBlock = new ContentBlock();
        contentBlock.setType("paragraph");
        contentBlock.setContent(List.of(textNode));

        Description description = new Description();
        description.setType("doc");
        description.setVersion(1);
        description.setContent(List.of(contentBlock));


        Fields fields = new Fields();
        fields.setProject(project);
        fields.setSummary("Continue Button is not working on user registration page");
        fields.setDescription(description);
        fields.setPriority(priority);
        fields.setAssignee(assignee);
        fields.setIssueType(issueType);

        return new CreateIssueRequest(fields);
    }

    public static IssueComment buildComment() {
        TextNode textNode = new TextNode();
        textNode.setText("Hi Team, work has been reviewed and validated. Please proceed with the next action");
        textNode.setType("text");
        ContentBlock paragraph = new ContentBlock();
        paragraph.setType("paragraph");
        paragraph.setContent(List.of(textNode));

        Body body = new Body();
        body.setType("doc");
        body.setVersion(1);
        body.setContent(List.of(paragraph));

        return new IssueComment(body);


    }

    public static UpdateComments updateCommentBuild(){
        TextNode textNode= new TextNode();
        textNode.setText("Comment Update By Nilava: Bug has been reviewed, please proceed with next action");
        textNode.setType("text");
        ContentBlock contentBlock = new ContentBlock();
        contentBlock.setType("paragraph");
        contentBlock.setContent(List.of(textNode));
        Visibility visibility = new Visibility();
        visibility.setIdentifier("Administrators");
        Body body= new Body();
        body.setType("doc");
        body.setVersion(1);
        body.setContent(List.of(contentBlock));
        UpdateComments updateComments= new UpdateComments();
        updateComments.setBody(body);
        updateComments.setVisibility(visibility);

        return updateComments;





    }

}
