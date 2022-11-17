package com.db.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "familystudent_tb", schema = "my_course", catalog = "")
//@IdClass(FamilystudentTbEntityPK.class)
public class FamilystudentTbEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "FamilyStudentFId")
    private int familyStudentFId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "FamilyStudentSId")
    private int familyStudentSId;
    @Basic
    @Column(name = "FamilyStudentRelateType")
    private byte familyStudentRelateType;
    @Basic
    @Column(name = "FamilyStudentCreateTime")
    private Timestamp familyStudentCreateTime;
    @Basic
    @Column(name = "FamilyStudentUpdateTime")
    private Timestamp familyStudentUpdateTime;

    public int getFamilyStudentFId() {
        return familyStudentFId;
    }

    public void setFamilyStudentFId(int familyStudentFId) {
        this.familyStudentFId = familyStudentFId;
    }

    public int getFamilyStudentSId() {
        return familyStudentSId;
    }

    public void setFamilyStudentSId(int familyStudentSId) {
        this.familyStudentSId = familyStudentSId;
    }

    public byte getFamilyStudentRelateType() {
        return familyStudentRelateType;
    }

    public void setFamilyStudentRelateType(byte familyStudentRelateType) {
        this.familyStudentRelateType = familyStudentRelateType;
    }

    public Timestamp getFamilyStudentCreateTime() {
        return familyStudentCreateTime;
    }

    public void setFamilyStudentCreateTime(Timestamp familyStudentCreateTime) {
        this.familyStudentCreateTime = familyStudentCreateTime;
    }

    public Timestamp getFamilyStudentUpdateTime() {
        return familyStudentUpdateTime;
    }

    public void setFamilyStudentUpdateTime(Timestamp familyStudentUpdateTime) {
        this.familyStudentUpdateTime = familyStudentUpdateTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyStudentFId, familyStudentSId,familyStudentRelateType,familyStudentCreateTime,familyStudentUpdateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilystudentTbEntity that = (FamilystudentTbEntity) o;
        return familyStudentFId == that.familyStudentFId && familyStudentSId == that.familyStudentSId &&
                familyStudentRelateType == that.familyStudentRelateType && familyStudentCreateTime == that.familyStudentCreateTime &&
                familyStudentUpdateTime == that.familyStudentUpdateTime;
    }
}
