package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "teacher_tb", schema = "my_course", catalog = "")
public class TeacherTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TeacherId")
    private int teacherId;
    @Basic
    @Column(name = "TeacherName")
    private String teacherName;
    @Basic
    @Column(name = "TeacherSex")
    private byte teacherSex;
    @Basic
    @Column(name = "TeacherBirth")
    private Timestamp teacherBirth;
    @Basic
    @Column(name = "TeacherSchoolId")
    private int teacherSchoolId;
    @Basic
    @Column(name = "TeacherCreateTime")
    private Timestamp teacherCreateTime;
    @Basic
    @Column(name = "TeacherUpdateTime")
    private Timestamp teacherUpdateTime;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public byte getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(byte teacherSex) {
        this.teacherSex = teacherSex;
    }

    public Timestamp getTeacherBirth() {
        return teacherBirth;
    }

    public void setTeacherBirth(Timestamp teacherBirth) {
        this.teacherBirth = teacherBirth;
    }

    public int getTeacherSchoolId() {
        return teacherSchoolId;
    }

    public void setTeacherSchoolId(int teacherSchoolId) {
        this.teacherSchoolId = teacherSchoolId;
    }

    public Timestamp getTeacherCreateTime() {
        return teacherCreateTime;
    }

    public void setTeacherCreateTime(Timestamp teacherCreateTime) {
        this.teacherCreateTime = teacherCreateTime;
    }

    public Timestamp getTeacherUpdateTime() {
        return teacherUpdateTime;
    }

    public void setTeacherUpdateTime(Timestamp teacherUpdateTime) {
        this.teacherUpdateTime = teacherUpdateTime;
    }
}
