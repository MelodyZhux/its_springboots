package com.bezkoder.spring.jdbc.oracle.model;

import java.util.Date;

public class Project {

    private long projectId;
    private String projectName;
    private Date startDate;

    private Date targetEndDate;

    private Date actualEndDate;

    private Date createdOn;

    private String createdBy;

    private Date modifiedOn;

    private String modifiedBy;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getTargetEndDate() {
        return targetEndDate;
    }

    public void setTargetEndDate(Date targetEndDate) {
        this.targetEndDate = targetEndDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
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

    public Project(long projectId, String projectName, Date startDate, Date targetEndDate, Date actualEndDate, Date createdOn, String createdBy, Date modifiedOn, String modifiedBy) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.targetEndDate = targetEndDate;
        this.actualEndDate = actualEndDate;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
    }

    public Project() {

    }

    public Project(String projectName, Date startDate, Date targetEndDate, Date actualEndDate, Date createdOn, String createdBy, Date modifiedOn, String modifiedBy) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.targetEndDate = targetEndDate;
        this.actualEndDate = actualEndDate;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
    }

    public Project(long projectId, String projectName, Date startDate, Date targetEndDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.targetEndDate = targetEndDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", startDate=" + startDate +
                ", targetEndDate=" + targetEndDate +
                ", actualEndDate=" + actualEndDate +
                ", createdOn=" + createdOn +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                '}';
    }

}
