package com.db.entitys;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "users_tb", schema = "user_center", catalog = "")
public class UsersTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "UserId")
    private int userId;
    @Basic
    @Column(name = "UserName")
    private String userName;
    @Basic
    @Column(name = "UserSex")
    private int userSex;
    @Basic
    @Column(name = "UserBirth")
    private Date userBirth;
    @Basic
    @Column(name = "UserIcon")
    private String userIcon;
    @Basic
    @Column(name = "UserPhone")
    private String userPhone;
    @Basic
    @Column(name = "UserEmail")
    private String userEmail;
    @Basic
    @Column(name = "UserPassword")
    private String userPassword;
    @Basic
    @Column(name = "UserRegistType")
    private int userRegistType;
    @Basic
    @Column(name = "UserSignature")
    private String userSignature;
    @Basic
    @Column(name = "UserMainAddrId")
    private Integer userMainAddrId;
    @Basic
    @Column(name = "UserCreateTime")
    private Timestamp userCreateTime;
    @Basic
    @Column(name = "UserUpdateTime")
    private Timestamp userUpdateTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserRegistType() {
        return userRegistType;
    }

    public void setUserRegistType(int userRegistType) {
        this.userRegistType = userRegistType;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public Integer getUserMainAddrId() {
        return userMainAddrId;
    }

    public void setUserMainAddrId(Integer userMainAddrId) {
        this.userMainAddrId = userMainAddrId;
    }

    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Timestamp userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Timestamp getUserUpdateTime() {
        return userUpdateTime;
    }

    public void setUserUpdateTime(Timestamp userUpdateTime) {
        this.userUpdateTime = userUpdateTime;
    }
}
