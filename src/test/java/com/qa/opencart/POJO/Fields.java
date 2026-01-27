package com.qa.opencart.POJO;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Fields {

    private Project project;
    private String summary;
    private Description description;
    private Priority priority;
    private Assignee assignee;

    @JsonProperty("issuetype")
    private Issuetype issueType;

    public Fields() {}


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public Issuetype getIssueType() {
        return issueType;
    }

    public void setIssueType(Issuetype issueType) {
        this.issueType = issueType;
    }

    }
