package com.db.entitys;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "authen_tb", schema = "user_center", catalog = "")
public class AuthenTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AuthNum")
    private int authNum;
    @Basic
    @Column(name = "AuthType")
    private int authType;
    @Basic
    @Column(name = "AuthRealName")
    private String authRealName;
    @Basic
    @Column(name = "AuthDateLine")
    private Date authDateLine;
    @Basic
    @Column(name = "AuthFace")
    private String authFace;
    @Basic
    @Column(name = "AuthFinger")
    private String authFinger;
    @Basic
    @Column(name = "AuthCountryId")
    private Integer authCountryId;
    @Basic
    @Column(name = "AuthProvinceId")
    private Integer authProvinceId;
    @Basic
    @Column(name = "AuthCityId")
    private Integer authCityId;
    @Basic
    @Column(name = "AuthAddr")
    private String authAddr;
    @Basic
    @Column(name = "AuthCreateTime")
    private Timestamp authCreateTime;
    @Basic
    @Column(name = "AuthUpdateTime")
    private Timestamp authUpdateTime;

    public int getAuthNum() {
        return authNum;
    }

    public void setAuthNum(int authNum) {
        this.authNum = authNum;
    }

    public int getAuthType() {
        return authType;
    }

    public void setAuthType(int authType) {
        this.authType = authType;
    }

    public String getAuthRealName() {
        return authRealName;
    }

    public void setAuthRealName(String authRealName) {
        this.authRealName = authRealName;
    }

    public Date getAuthDateLine() {
        return authDateLine;
    }

    public void setAuthDateLine(Date authDateLine) {
        this.authDateLine = authDateLine;
    }

    public String getAuthFace() {
        return authFace;
    }

    public void setAuthFace(String authFace) {
        this.authFace = authFace;
    }

    public String getAuthFinger() {
        return authFinger;
    }

    public void setAuthFinger(String authFinger) {
        this.authFinger = authFinger;
    }

    public Integer getAuthCountryId() {
        return authCountryId;
    }

    public void setAuthCountryId(Integer authCountryId) {
        this.authCountryId = authCountryId;
    }

    public Integer getAuthProvinceId() {
        return authProvinceId;
    }

    public void setAuthProvinceId(Integer authProvinceId) {
        this.authProvinceId = authProvinceId;
    }

    public Integer getAuthCityId() {
        return authCityId;
    }

    public void setAuthCityId(Integer authCityId) {
        this.authCityId = authCityId;
    }

    public String getAuthAddr() {
        return authAddr;
    }

    public void setAuthAddr(String authAddr) {
        this.authAddr = authAddr;
    }

    public Timestamp getAuthCreateTime() {
        return authCreateTime;
    }

    public void setAuthCreateTime(Timestamp authCreateTime) {
        this.authCreateTime = authCreateTime;
    }

    public Timestamp getAuthUpdateTime() {
        return authUpdateTime;
    }

    public void setAuthUpdateTime(Timestamp authUpdateTime) {
        this.authUpdateTime = authUpdateTime;
    }
}
