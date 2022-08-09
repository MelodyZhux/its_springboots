package com.bezkoder.spring.jdbc.oracle.model;

import java.util.Date;

public class Issue {
    private long issueId;
    private String issueSummary;
    private String issueDescription;
    private long identifiedByPersonId;
    private Date identifiedDate;
    private long relatedProject;
    private long assignedTo;
    private String status;
    private String priority;
    private Date targetResolutionDate;
    private String progress;
    private Date actualResolutionDate;
    private String resolutionSummary;
    private Date createdOn;
    private String createdBy;
    private Date modifiedOn;
    private String modifiedBy;

    public Issue() {

    }

    public Issue(long issueId, String issueSummary, String issueDescription, long identifiedByPersonId, Date identifiedDate, long relatedProject, long assignedTo, String status, String priority, Date targetResolutionDate, String progress, Date actualResolutionDate, String resolutionSummary, Date createdOn, String createdBy, Date modifiedOn, String modifiedBy) {
        this.issueId = issueId;
        this.issueSummary = issueSummary;
        this.issueDescription = issueDescription;
        this.identifiedByPersonId = identifiedByPersonId;
        this.identifiedDate = identifiedDate;
        this.relatedProject = relatedProject;
        this.assignedTo = assignedTo;
        this.status = status;
        this.priority = priority;
        this.targetResolutionDate = targetResolutionDate;
        this.progress = progress;
        this.actualResolutionDate = actualResolutionDate;
        this.resolutionSummary = resolutionSummary;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
    }

    public long getIssueId() {
        return issueId;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }

    public String getIssueSummary() {
        return issueSummary;
    }

    public void setIssueSummary(String issueSummary) {
        this.issueSummary = issueSummary;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public long getIdentifiedByPersonId() {
        return identifiedByPersonId;
    }

    public void setIdentifiedByPersonId(long identifiedByPersonId) {
        this.identifiedByPersonId = identifiedByPersonId;
    }

    public Date getIdentifiedDate() {
        return identifiedDate;
    }

    public void setIdentifiedDate(Date identifiedDate) {
        this.identifiedDate = identifiedDate;
    }

    public long getRelatedProject() {
        return relatedProject;
    }

    public void setRelatedProject(long relatedProject) {
        this.relatedProject = relatedProject;
    }

    public long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getTargetResolutionDate() {
        return targetResolutionDate;
    }

    public void setTargetResolutionDate(Date targetResolutionDate) {
        this.targetResolutionDate = targetResolutionDate;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Date getActualResolutionDate() {
        return actualResolutionDate;
    }

    public void setActualResolutionDate(Date actualResolutionDate) {
        this.actualResolutionDate = actualResolutionDate;
    }

    public String getResolutionSummary() {
        return resolutionSummary;
    }

    public void setResolutionSummary(String resolutionSummary) {
        this.resolutionSummary = resolutionSummary;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + issueId +
                ", issueSummary='" + issueSummary + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", identifiedByPersonId=" + identifiedByPersonId +
                ", identifiedDate=" + identifiedDate +
                ", relatedProject=" + relatedProject +
                ", assignedTo=" + assignedTo +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", targetResolutionDate=" + targetResolutionDate +
                ", progress='" + progress + '\'' +
                ", actualResolutionDate=" + actualResolutionDate +
                ", resolutionSummary='" + resolutionSummary + '\'' +
                ", createdOn=" + createdOn +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                '}';
    }
}
