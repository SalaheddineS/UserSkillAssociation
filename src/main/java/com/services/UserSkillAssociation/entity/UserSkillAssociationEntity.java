package com.services.UserSkillAssociation.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class UserSkillAssociationEntity {
    @Id
    @GeneratedValue
    private int id;
    private String userEmail;
    private String skill;
    private Date skillAdditionDate=new Date();

    public UserSkillAssociationEntity(int id, String userEmail, String skill) {
        this.id = id;
        this.userEmail = userEmail;
        this.skill = skill;
    }

    public UserSkillAssociationEntity(String userEmail, String skill) {
        this.userEmail = userEmail;
        this.skill = skill;
    }

    public UserSkillAssociationEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Date getSkillAdditionDate() {
        return skillAdditionDate;
    }

    public void setSkillAdditionDate(Date skillAdditionDate) {
        this.skillAdditionDate = skillAdditionDate;
    }
}

