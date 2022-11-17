package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "lesson_tb", schema = "my_course", catalog = "")
public class LessonTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LessonId")
    private int lessonId;
    @Basic
    @Column(name = "LessonDescribe")
    private String lessonDescribe;
    @Basic
    @Column(name = "LessonCourseId")
    private int lessonCourseId;
    @Basic
    @Column(name = "LessonClassRoomId")
    private int lessonClassRoomId;
    @Basic
    @Column(name = "LessonType")
    private byte lessonType;
    @Basic
    @Column(name = "LessonWeekCourseId")
    private Integer lessonWeekCourseId;
    @Basic
    @Column(name = "LessonCreateTime")
    private Timestamp lessonCreateTime;
    @Basic
    @Column(name = "LessonUpdateTime")
    private Timestamp lessonUpdateTime;

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonDescribe() {
        return lessonDescribe;
    }

    public void setLessonDescribe(String lessonDescribe) {
        this.lessonDescribe = lessonDescribe;
    }

    public int getLessonCourseId() {
        return lessonCourseId;
    }

    public void setLessonCourseId(int lessonCourseId) {
        this.lessonCourseId = lessonCourseId;
    }

    public int getLessonClassRoomId() {
        return lessonClassRoomId;
    }

    public void setLessonClassRoomId(int lessonClassRoomId) {
        this.lessonClassRoomId = lessonClassRoomId;
    }

    public byte getLessonType() {
        return lessonType;
    }

    public void setLessonType(byte lessonType) {
        this.lessonType = lessonType;
    }

    public Integer getLessonWeekCourseId() {
        return lessonWeekCourseId;
    }

    public void setLessonWeekCourseId(Integer lessonWeekCourseId) {
        this.lessonWeekCourseId = lessonWeekCourseId;
    }

    public Timestamp getLessonCreateTime() {
        return lessonCreateTime;
    }

    public void setLessonCreateTime(Timestamp lessonCreateTime) {
        this.lessonCreateTime = lessonCreateTime;
    }

    public Timestamp getLessonUpdateTime() {
        return lessonUpdateTime;
    }

    public void setLessonUpdateTime(Timestamp lessonUpdateTime) {
        this.lessonUpdateTime = lessonUpdateTime;
    }
}
