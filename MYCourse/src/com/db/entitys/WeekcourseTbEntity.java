package com.db.entitys;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "weekcourse_tb", schema = "my_course", catalog = "")
public class WeekcourseTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "WeekCourseId")
    private int weekCourseId;
    @Basic
    @Column(name = "WeekCourseWeekDay")
    private byte weekCourseWeekDay;
    @Basic
    @Column(name = "WeekCourseStartDate")
    private Date weekCourseStartDate;
    @Basic
    @Column(name = "WeekCourseStartTime")
    private Time weekCourseStartTime;
    @Basic
    @Column(name = "WeekCourseEndDate")
    private Date weekCourseEndDate;
    @Basic
    @Column(name = "WeekCourseEndTime")
    private Time weekCourseEndTime;
    @Basic
    @Column(name = "WeekCourseType")
    private byte weekCourseType;
    @Basic
    @Column(name = "WeekCourseCId")
    private int weekCourseCId;
    @Basic
    @Column(name = "WeekCourseSId")
    private int weekCourseSId;
    @Basic
    @Column(name = "WeekCourseCreateTime")
    private Timestamp weekCourseCreateTime;
    @Basic
    @Column(name = "WeekCourseUpdateTime")
    private Timestamp weekCourseUpdateTime;

    public int getWeekCourseId() {
        return weekCourseId;
    }

    public void setWeekCourseId(int weekCourseId) {
        this.weekCourseId = weekCourseId;
    }

    public byte getWeekCourseWeekDay() {
        return weekCourseWeekDay;
    }

    public void setWeekCourseWeekDay(byte weekCourseWeekDay) {
        this.weekCourseWeekDay = weekCourseWeekDay;
    }

    public Date getWeekCourseStartDate() {
        return weekCourseStartDate;
    }

    public void setWeekCourseStartDate(Date weekCourseStartDate) {
        this.weekCourseStartDate = weekCourseStartDate;
    }

    public Time getWeekCourseStartTime() {
        return weekCourseStartTime;
    }

    public void setWeekCourseStartTime(Time weekCourseStartTime) {
        this.weekCourseStartTime = weekCourseStartTime;
    }

    public Date getWeekCourseEndDate() {
        return weekCourseEndDate;
    }

    public void setWeekCourseEndDate(Date weekCourseEndDate) {
        this.weekCourseEndDate = weekCourseEndDate;
    }

    public Time getWeekCourseEndTime() {
        return weekCourseEndTime;
    }

    public void setWeekCourseEndTime(Time weekCourseEndTime) {
        this.weekCourseEndTime = weekCourseEndTime;
    }

    public byte getWeekCourseType() {
        return weekCourseType;
    }

    public void setWeekCourseType(byte weekCourseType) {
        this.weekCourseType = weekCourseType;
    }

    public int getWeekCourseCId() {
        return weekCourseCId;
    }

    public void setWeekCourseCId(int weekCourseCId) {
        this.weekCourseCId = weekCourseCId;
    }

    public int getWeekCourseSId() {
        return weekCourseSId;
    }

    public void setWeekCourseSId(int weekCourseSId) {
        this.weekCourseSId = weekCourseSId;
    }

    public Timestamp getWeekCourseCreateTime() {
        return weekCourseCreateTime;
    }

    public void setWeekCourseCreateTime(Timestamp weekCourseCreateTime) {
        this.weekCourseCreateTime = weekCourseCreateTime;
    }

    public Timestamp getWeekCourseUpdateTime() {
        return weekCourseUpdateTime;
    }

    public void setWeekCourseUpdateTime(Timestamp weekCourseUpdateTime) {
        this.weekCourseUpdateTime = weekCourseUpdateTime;
    }
}
