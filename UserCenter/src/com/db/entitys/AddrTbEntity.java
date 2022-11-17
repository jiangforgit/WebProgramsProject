package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "addr_tb", schema = "user_center", catalog = "")
public class AddrTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AddrId")
    private int addrId;
    @Basic
    @Column(name = "AddrCountryId")
    private Integer addrCountryId;
    @Basic
    @Column(name = "AddrProvinceId")
    private Integer addrProvinceId;
    @Basic
    @Column(name = "AddrCityId")
    private Integer addrCityId;
    @Basic
    @Column(name = "AddrStreet")
    private String addrStreet;
    @Basic
    @Column(name = "AddrBuilding")
    private Integer addrBuilding;
    @Basic
    @Column(name = "AddrHomeNum")
    private Integer addrHomeNum;
    @Basic
    @Column(name = "AddrPostCode")
    private Integer addrPostCode;
    @Basic
    @Column(name = "AddrPhone")
    private String addrPhone;
    @Basic
    @Column(name = "AddrUserId")
    private Integer addrUserId;
    @Basic
    @Column(name = "AddrCreateTime")
    private Timestamp addrCreateTime;
    @Basic
    @Column(name = "AddrUpdateTime")
    private Timestamp addrUpdateTime;

    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    public Integer getAddrCountryId() {
        return addrCountryId;
    }

    public void setAddrCountryId(Integer addrCountryId) {
        this.addrCountryId = addrCountryId;
    }

    public Integer getAddrProvinceId() {
        return addrProvinceId;
    }

    public void setAddrProvinceId(Integer addrProvinceId) {
        this.addrProvinceId = addrProvinceId;
    }

    public Integer getAddrCityId() {
        return addrCityId;
    }

    public void setAddrCityId(Integer addrCityId) {
        this.addrCityId = addrCityId;
    }

    public String getAddrStreet() {
        return addrStreet;
    }

    public void setAddrStreet(String addrStreet) {
        this.addrStreet = addrStreet;
    }

    public Integer getAddrBuilding() {
        return addrBuilding;
    }

    public void setAddrBuilding(Integer addrBuilding) {
        this.addrBuilding = addrBuilding;
    }

    public Integer getAddrHomeNum() {
        return addrHomeNum;
    }

    public void setAddrHomeNum(Integer addrHomeNum) {
        this.addrHomeNum = addrHomeNum;
    }

    public Integer getAddrPostCode() {
        return addrPostCode;
    }

    public void setAddrPostCode(Integer addrPostCode) {
        this.addrPostCode = addrPostCode;
    }

    public String getAddrPhone() {
        return addrPhone;
    }

    public void setAddrPhone(String addrPhone) {
        this.addrPhone = addrPhone;
    }

    public Integer getAddrUserId() {
        return addrUserId;
    }

    public void setAddrUserId(Integer addrUserId) {
        this.addrUserId = addrUserId;
    }

    public Timestamp getAddrCreateTime() {
        return addrCreateTime;
    }

    public void setAddrCreateTime(Timestamp addrCreateTime) {
        this.addrCreateTime = addrCreateTime;
    }

    public Timestamp getAddrUpdateTime() {
        return addrUpdateTime;
    }

    public void setAddrUpdateTime(Timestamp addrUpdateTime) {
        this.addrUpdateTime = addrUpdateTime;
    }
}
