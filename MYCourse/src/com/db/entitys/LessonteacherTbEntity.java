package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "lessonteacher_tb", schema = "my_course", catalog = "")
public class LessonteacherTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LessonTeacherId")
    private int lessonTeacherId;
    @Basic
    @Column(name = "LessonTeacherType")
    private byte lessonTeacherType;
    @Basic
    @Column(name = "LessonTeacherName")
    private String lessonTeacherName;
    @Basic
    @Column(name = "LessonTeacherDes")
    private String lessonTeacherDes;
    @Basic
    @Column(name = "LessonTeacherTId")
    private Integer lessonTeacherTId;
    @Basic
    @Column(name = "LessonTeacherRoomId")
    private Integer lessonTeacherRoomId;
    @Basic
    @Column(name = "LessonTeacherCreateTime")
    private Timestamp lessonTeacherCreateTime;
    @Basic
    @Column(name = "LessonTeacherUpdateTime")
    private Timestamp lessonTeacherUpdateTime;

    public int getLessonTeacherId() {
        return lessonTeacherId;
    }

    public void setLessonTeacherId(int lessonTeacherId) {
        this.lessonTeacherId = lessonTeacherId;
    }

    public byte getLessonTeacherType() {
        return lessonTeacherType;
    }

    public void setLessonTeacherType(byte lessonTeacherType) {
        this.lessonTeacherType = lessonTeacherType;
    }

    public String getLessonTeacherName() {
        return lessonTeacherName;
    }

    public void setLessonTeacherName(String lessonTeacherName) {
        this.lessonTeacherName = lessonTeacherName;
    }

    public String getLessonTeacherDes() {
        return lessonTeacherDes;
    }

    public void setLessonTeacherDes(String lessonTeacherDes) {
        this.lessonTeacherDes = lessonTeacherDes;
    }

    public Integer getLessonTeacherTId() {
        return lessonTeacherTId;
    }

    public void setLessonTeacherTId(Integer lessonTeacherTId) {
        this.lessonTeacherTId = lessonTeacherTId;
    }

    public Integer getLessonTeacherRoomId() {
        return lessonTeacherRoomId;
    }

    public void setLessonTeacherRoomId(Integer lessonTeacherRoomId) {
        this.lessonTeacherRoomId = lessonTeacherRoomId;
    }

    public Timestamp getLessonTeacherCreateTime() {
        return lessonTeacherCreateTime;
    }

    public void setLessonTeacherCreateTime(Timestamp lessonTeacherCreateTime) {
        this.lessonTeacherCreateTime = lessonTeacherCreateTime;
    }

    public Timestamp getLessonTeacherUpdateTime() {
        return lessonTeacherUpdateTime;
    }

    public void setLessonTeacherUpdateTime(Timestamp lessonTeacherUpdateTime) {
        this.lessonTeacherUpdateTime = lessonTeacherUpdateTime;
    }
}
