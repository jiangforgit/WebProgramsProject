package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "studenthealth_tb", schema = "my_course", catalog = "")
public class StudenthealthTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "StudentHealthId")
    private int studentHealthId;
    @Basic
    @Column(name = "StudentHealthStature")
    private Double studentHealthStature;
    @Basic
    @Column(name = "StudentHealthWeight")
    private Double studentHealthWeight;
    @Basic
    @Column(name = "StudentHealthBlood")
    private Double studentHealthBlood;
    @Basic
    @Column(name = "StudentHealthBloodSugar")
    private Double studentHealthBloodSugar;
    @Basic
    @Column(name = "StudentHealthSpo")
    private Double studentHealthSpo;
    @Basic
    @Column(name = "StudentHealthStartSleep")
    private Timestamp studentHealthStartSleep;
    @Basic
    @Column(name = "StudentHealthEndSleep")
    private Timestamp studentHealthEndSleep;
    @Basic
    @Column(name = "StudentHealthSleepType")
    private Byte studentHealthSleepType;
    @Basic
    @Column(name = "StudentHealthStudentId")
    private int studentHealthStudentId;
    @Basic
    @Column(name = "StudentHealthCreateTime")
    private Timestamp studentHealthCreateTime;
    @Basic
    @Column(name = "StudentHealthUpdateTime")
    private Timestamp studentHealthUpdateTime;

    public int getStudentHealthId() {
        return studentHealthId;
    }

    public void setStudentHealthId(int studentHealthId) {
        this.studentHealthId = studentHealthId;
    }

    public Double getStudentHealthStature() {
        return studentHealthStature;
    }

    public void setStudentHealthStature(Double studentHealthStature) {
        this.studentHealthStature = studentHealthStature;
    }

    public Double getStudentHealthWeight() {
        return studentHealthWeight;
    }

    public void setStudentHealthWeight(Double studentHealthWeight) {
        this.studentHealthWeight = studentHealthWeight;
    }

    public Double getStudentHealthBlood() {
        return studentHealthBlood;
    }

    public void setStudentHealthBlood(Double studentHealthBlood) {
        this.studentHealthBlood = studentHealthBlood;
    }

    public Double getStudentHealthBloodSugar() {
        return studentHealthBloodSugar;
    }

    public void setStudentHealthBloodSugar(Double studentHealthBloodSugar) {
        this.studentHealthBloodSugar = studentHealthBloodSugar;
    }

    public Double getStudentHealthSpo() {
        return studentHealthSpo;
    }

    public void setStudentHealthSpo(Double studentHealthSpo) {
        this.studentHealthSpo = studentHealthSpo;
    }

    public Timestamp getStudentHealthStartSleep() {
        return studentHealthStartSleep;
    }

    public void setStudentHealthStartSleep(Timestamp studentHealthStartSleep) {
        this.studentHealthStartSleep = studentHealthStartSleep;
    }

    public Timestamp getStudentHealthEndSleep() {
        return studentHealthEndSleep;
    }

    public void setStudentHealthEndSleep(Timestamp studentHealthEndSleep) {
        this.studentHealthEndSleep = studentHealthEndSleep;
    }

    public Byte getStudentHealthSleepType() {
        return studentHealthSleepType;
    }

    public void setStudentHealthSleepType(Byte studentHealthSleepType) {
        this.studentHealthSleepType = studentHealthSleepType;
    }

    public int getStudentHealthStudentId() {
        return studentHealthStudentId;
    }

    public void setStudentHealthStudentId(int studentHealthStudentId) {
        this.studentHealthStudentId = studentHealthStudentId;
    }

    public Timestamp getStudentHealthCreateTime() {
        return studentHealthCreateTime;
    }

    public void setStudentHealthCreateTime(Timestamp studentHealthCreateTime) {
        this.studentHealthCreateTime = studentHealthCreateTime;
    }

    public Timestamp getStudentHealthUpdateTime() {
        return studentHealthUpdateTime;
    }

    public void setStudentHealthUpdateTime(Timestamp studentHealthUpdateTime) {
        this.studentHealthUpdateTime = studentHealthUpdateTime;
    }
}
