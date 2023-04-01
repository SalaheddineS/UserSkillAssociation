package com.services.UserSkillAssociation.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class UserSkillAssociationEntity {
    @Id
    @GeneratedValue
    private int id;
    private String userEmail;
    private int skillId;
    private Date skillAdditionDate=new Date();

    public UserSkillAssociationEntity(int id, String userEmail, int skillId) {
        this.id = id;
        this.userEmail = userEmail;
        this.skillId = skillId;
    }

    public UserSkillAssociationEntity(String userEmail, int skillId) {
        this.userEmail = userEmail;
        this.skillId = skillId;
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

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public Date getSkillAdditionDate() {
        return skillAdditionDate;
    }

    public void setSkillAdditionDate(Date skillAdditionDate) {
        this.skillAdditionDate = skillAdditionDate;
    }
}

