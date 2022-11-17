package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "classroom_tb", schema = "my_course", catalog = "")
public class ClassroomTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ClassRoomId")
    private int classRoomId;
    @Basic
    @Column(name = "ClassRoomName")
    private String classRoomName;
    @Basic
    @Column(name = "ClassRoomLocation")
    private String classRoomLocation;
    @Basic
    @Column(name = "ClassRoomVideoId")
    private Integer classRoomVideoId;
    @Basic
    @Column(name = "ClassRoomShoolId")
    private int classRoomShoolId;
    @Basic
    @Column(name = "ClassRoomCreateTime")
    private Timestamp classRoomCreateTime;
    @Basic
    @Column(name = "ClassRoomUpdateTime")
    private Timestamp classRoomUpdateTime;

    public int getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(int classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public String getClassRoomLocation() {
        return classRoomLocation;
    }

    public void setClassRoomLocation(String classRoomLocation) {
        this.classRoomLocation = classRoomLocation;
    }

    public Integer getClassRoomVideoId() {
        return classRoomVideoId;
    }

    public void setClassRoomVideoId(Integer classRoomVideoId) {
        this.classRoomVideoId = classRoomVideoId;
    }

    public int getClassRoomShoolId() {
        return classRoomShoolId;
    }

    public void setClassRoomShoolId(int classRoomShoolId) {
        this.classRoomShoolId = classRoomShoolId;
    }

    public Timestamp getClassRoomCreateTime() {
        return classRoomCreateTime;
    }

    public void setClassRoomCreateTime(Timestamp classRoomCreateTime) {
        this.classRoomCreateTime = classRoomCreateTime;
    }

    public Timestamp getClassRoomUpdateTime() {
        return classRoomUpdateTime;
    }

    public void setClassRoomUpdateTime(Timestamp classRoomUpdateTime) {
        this.classRoomUpdateTime = classRoomUpdateTime;
    }
}
