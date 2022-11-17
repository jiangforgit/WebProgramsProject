package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "school_tb", schema = "my_course", catalog = "")
public class SchoolTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SchoolId")
    private int schoolId;
    @Basic
    @Column(name = "SchoolName")
    private String schoolName;
    @Basic
    @Column(name = "SchoolAddr")
    private String schoolAddr;
    @Basic
    @Column(name = "SchoolType")
    private Byte schoolType;
    @Basic
    @Column(name = "SchoolCreatorType")
    private byte schoolCreatorType;
    @Basic
    @Column(name = "SchoolCreatorUserId")
    private int schoolCreatorUserId;
    @Basic
    @Column(name = "SchoolCreateTime")
    private Timestamp schoolCreateTime;
    @Basic
    @Column(name = "SchoolUpdateTime")
    private Timestamp schoolUpdateTime;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddr() {
        return schoolAddr;
    }

    public void setSchoolAddr(String schoolAddr) {
        this.schoolAddr = schoolAddr;
    }

    public Byte getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(Byte schoolType) {
        this.schoolType = schoolType;
    }

    public byte getSchoolCreatorType() {
        return schoolCreatorType;
    }

    public void setSchoolCreatorType(byte schoolCreatorType) {
        this.schoolCreatorType = schoolCreatorType;
    }

    public int getSchoolCreatorUserId() {
        return schoolCreatorUserId;
    }

    public void setSchoolCreatorUserId(int schoolCreatorUserId) {
        this.schoolCreatorUserId = schoolCreatorUserId;
    }

    public Timestamp getSchoolCreateTime() {
        return schoolCreateTime;
    }

    public void setSchoolCreateTime(Timestamp schoolCreateTime) {
        this.schoolCreateTime = schoolCreateTime;
    }

    public Timestamp getSchoolUpdateTime() {
        return schoolUpdateTime;
    }

    public void setSchoolUpdateTime(Timestamp schoolUpdateTime) {
        this.schoolUpdateTime = schoolUpdateTime;
    }
}
