package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "familyuser_tb", schema = "my_course", catalog = "")
public class FamilyuserTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "FamilyUserId")
    private int familyUserId;
    @Basic
    @Column(name = "FamilyUserName")
    private String familyUserName;
    @Basic
    @Column(name = "FamilyUserSex")
    private byte familyUserSex;
    @Basic
    @Column(name = "FamilyUserPhone")
    private String familyUserPhone;
    @Basic
    @Column(name = "FamilyUserCreateTime")
    private Timestamp familyUserCreateTime;
    @Basic
    @Column(name = "FamilyUserUpdateTime")
    private Timestamp familyUserUpdateTime;

    public int getFamilyUserId() {
        return familyUserId;
    }

    public void setFamilyUserId(int familyUserId) {
        this.familyUserId = familyUserId;
    }

    public String getFamilyUserName() {
        return familyUserName;
    }

    public void setFamilyUserName(String familyUserName) {
        this.familyUserName = familyUserName;
    }

    public byte getFamilyUserSex() {
        return familyUserSex;
    }

    public void setFamilyUserSex(byte familyUserSex) {
        this.familyUserSex = familyUserSex;
    }

    public String getFamilyUserPhone() {
        return familyUserPhone;
    }

    public void setFamilyUserPhone(String familyUserPhone) {
        this.familyUserPhone = familyUserPhone;
    }

    public Timestamp getFamilyUserCreateTime() {
        return familyUserCreateTime;
    }

    public void setFamilyUserCreateTime(Timestamp familyUserCreateTime) {
        this.familyUserCreateTime = familyUserCreateTime;
    }

    public Timestamp getFamilyUserUpdateTime() {
        return familyUserUpdateTime;
    }

    public void setFamilyUserUpdateTime(Timestamp familyUserUpdateTime) {
        this.familyUserUpdateTime = familyUserUpdateTime;
    }
}
