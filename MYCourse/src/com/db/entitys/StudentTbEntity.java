package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "student_tb", schema = "my_course", catalog = "")
public class StudentTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "StudentId")
    private int studentId;
    @Basic
    @Column(name = "StudentName")
    private String studentName;
    @Basic
    @Column(name = "StudentSex")
    private byte studentSex;
    @Basic
    @Column(name = "StudentIcon")
    private String studentIcon;
    @Basic
    @Column(name = "StudentBirth")
    private Timestamp studentBirth;
    @Basic
    @Column(name = "StudentBloodType")
    private Byte studentBloodType;
    @Basic
    @Column(name = "StudentInterest")
    private String studentInterest;
    @Basic
    @Column(name = "StudentMotto")
    private String studentMotto;
    @Basic
    @Column(name = "StudentCreateTime")
    private Timestamp studentCreateTime;
    @Basic
    @Column(name = "StudentUpdateTime")
    private Timestamp studentUpdateTime;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public byte getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(byte studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentIcon() {
        return studentIcon;
    }

    public void setStudentIcon(String studentIcon) {
        this.studentIcon = studentIcon;
    }

    public Timestamp getStudentBirth() {
        return studentBirth;
    }

    public void setStudentBirth(Timestamp studentBirth) {
        this.studentBirth = studentBirth;
    }

    public Byte getStudentBloodType() {
        return studentBloodType;
    }

    public void setStudentBloodType(Byte studentBloodType) {
        this.studentBloodType = studentBloodType;
    }

    public String getStudentInterest() {
        return studentInterest;
    }

    public void setStudentInterest(String studentInterest) {
        this.studentInterest = studentInterest;
    }

    public String getStudentMotto() {
        return studentMotto;
    }

    public void setStudentMotto(String studentMotto) {
        this.studentMotto = studentMotto;
    }

    public Timestamp getStudentCreateTime() {
        return studentCreateTime;
    }

    public void setStudentCreateTime(Timestamp studentCreateTime) {
        this.studentCreateTime = studentCreateTime;
    }

    public Timestamp getStudentUpdateTime() {
        return studentUpdateTime;
    }

    public void setStudentUpdateTime(Timestamp studentUpdateTime) {
        this.studentUpdateTime = studentUpdateTime;
    }
}
