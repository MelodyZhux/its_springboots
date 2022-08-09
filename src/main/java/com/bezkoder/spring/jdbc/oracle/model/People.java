package com.bezkoder.spring.jdbc.oracle.model;

import java.util.Date;

public class People {
    private long personId;
    private String personName;
    private String personEmail;
    private String personRole;
    private String userName;
    private int assignedProject;
    private Date createdOn;
    private String createdBy;
    private Date modifiedOn;
    private String modifiedBy;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonRole() {
        return personRole;
    }

    public void setPersonRole(String personRole) {
        this.personRole = personRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAssignedProject() {
        return assignedProject;
    }

    public void setAssignedProject(int assignedProject) {
        this.assignedProject = assignedProject;
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


    public People(long personId, String personName, String personEmail, String personRole, String userName, int assignedProject, Date createdOn, String createdBy, Date modifiedOn, String modifiedBy) {
        this.personId = personId;
        this.personName = personName;
        this.personEmail = personEmail;
        this.personRole = personRole;
        this.userName = userName;
        this.assignedProject = assignedProject;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
    }

    public People(String personName, String personEmail, String personRole, String userName, int assignedProject, Date createdOn, String createdBy, Date modifiedOn, String modifiedBy) {
        this.personName = personName;
        this.personEmail = personEmail;
        this.personRole = personRole;
        this.userName = userName;
        this.assignedProject = assignedProject;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.modifiedOn = modifiedOn;
        this.modifiedBy = modifiedBy;
    }

    public People() {
    }

    @Override
    public String toString() {
        return "People{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personEmail='" + personEmail + '\'' +
                ", personRole='" + personRole + '\'' +
                ", username='" + userName + '\'' +
                ", assignedProject=" + assignedProject +
                ", createdOn=" + createdOn +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedOn=" + modifiedOn +
                ", modifiedBy='" + modifiedBy + '\'' +
                '}';
    }
}
