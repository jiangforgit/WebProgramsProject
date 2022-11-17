package com.db.entitys;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "scheduletask_tb", schema = "my_course", catalog = "")
public class ScheduletaskTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ScheduleTaskId")
    private int scheduleTaskId;
    @Basic
    @Column(name = "ScheduleTaskTitle")
    private String scheduleTaskTitle;
    @Basic
    @Column(name = "ScheduleTaskContent")
    private String scheduleTaskContent;
    @Basic
    @Column(name = "ScheduleTaskPicPath")
    private String scheduleTaskPicPath;
    @Basic
    @Column(name = "ScheduleTaskAudioPath")
    private String scheduleTaskAudioPath;
    @Basic
    @Column(name = "ScheduleTaskStatus")
    private byte scheduleTaskStatus;
    @Basic
    @Column(name = "ScheduleTaskFullShare")
    private Byte scheduleTaskFullShare;
    @Basic
    @Column(name = "ScheduleTaskStartDate")
    private Date scheduleTaskStartDate;
    @Basic
    @Column(name = "ScheduleTaskStartTime")
    private Time scheduleTaskStartTime;
    @Basic
    @Column(name = "ScheduleTaskEndDate")
    private Date scheduleTaskEndDate;
    @Basic
    @Column(name = "ScheduleTaskEndTime")
    private Time scheduleTaskEndTime;
    @Basic
    @Column(name = "ScheduleTaskRemindTime")
    private int scheduleTaskRemindTime;
    @Basic
    @Column(name = "ScheduleTaskIsReminded")
    private Byte scheduleTaskIsReminded;
    @Basic
    @Column(name = "ScheduleTaskType")
    private byte scheduleTaskType;
    @Basic
    @Column(name = "ScheduleTaskCreator")
    private int scheduleTaskCreator;
    @Basic
    @Column(name = "ScheduleTaskComment")
    private String scheduleTaskComment;
    @Basic
    @Column(name = "ScheduleTaskCreateTime")
    private Timestamp scheduleTaskCreateTime;
    @Basic
    @Column(name = "ScheduleTaskUpdateTime")
    private Timestamp scheduleTaskUpdateTime;

    public int getScheduleTaskId() {
        return scheduleTaskId;
    }

    public void setScheduleTaskId(int scheduleTaskId) {
        this.scheduleTaskId = scheduleTaskId;
    }

    public String getScheduleTaskTitle() {
        return scheduleTaskTitle;
    }

    public void setScheduleTaskTitle(String scheduleTaskTitle) {
        this.scheduleTaskTitle = scheduleTaskTitle;
    }

    public String getScheduleTaskContent() {
        return scheduleTaskContent;
    }

    public void setScheduleTaskContent(String scheduleTaskContent) {
        this.scheduleTaskContent = scheduleTaskContent;
    }

    public String getScheduleTaskPicPath() {
        return scheduleTaskPicPath;
    }

    public void setScheduleTaskPicPath(String scheduleTaskPicPath) {
        this.scheduleTaskPicPath = scheduleTaskPicPath;
    }

    public String getScheduleTaskAudioPath() {
        return scheduleTaskAudioPath;
    }

    public void setScheduleTaskAudioPath(String scheduleTaskAudioPath) {
        this.scheduleTaskAudioPath = scheduleTaskAudioPath;
    }

    public byte getScheduleTaskStatus() {
        return scheduleTaskStatus;
    }

    public void setScheduleTaskStatus(byte scheduleTaskStatus) {
        this.scheduleTaskStatus = scheduleTaskStatus;
    }

    public Byte getScheduleTaskFullShare() {
        return scheduleTaskFullShare;
    }

    public void setScheduleTaskFullShare(Byte scheduleTaskFullShare) {
        this.scheduleTaskFullShare = scheduleTaskFullShare;
    }

    public Date getScheduleTaskStartDate() {
        return scheduleTaskStartDate;
    }

    public void setScheduleTaskStartDate(Date scheduleTaskStartDate) {
        this.scheduleTaskStartDate = scheduleTaskStartDate;
    }

    public Time getScheduleTaskStartTime() {
        return scheduleTaskStartTime;
    }

    public void setScheduleTaskStartTime(Time scheduleTaskStartTime) {
        this.scheduleTaskStartTime = scheduleTaskStartTime;
    }

    public Date getScheduleTaskEndDate() {
        return scheduleTaskEndDate;
    }

    public void setScheduleTaskEndDate(Date scheduleTaskEndDate) {
        this.scheduleTaskEndDate = scheduleTaskEndDate;
    }

    public Time getScheduleTaskEndTime() {
        return scheduleTaskEndTime;
    }

    public void setScheduleTaskEndTime(Time scheduleTaskEndTime) {
        this.scheduleTaskEndTime = scheduleTaskEndTime;
    }

    public int getScheduleTaskRemindTime() {
        return scheduleTaskRemindTime;
    }

    public void setScheduleTaskRemindTime(int scheduleTaskRemindTime) {
        this.scheduleTaskRemindTime = scheduleTaskRemindTime;
    }

    public Byte getScheduleTaskIsReminded() {
        return scheduleTaskIsReminded;
    }

    public void setScheduleTaskIsReminded(Byte scheduleTaskIsReminded) {
        this.scheduleTaskIsReminded = scheduleTaskIsReminded;
    }

    public byte getScheduleTaskType() {
        return scheduleTaskType;
    }

    public void setScheduleTaskType(byte scheduleTaskType) {
        this.scheduleTaskType = scheduleTaskType;
    }

    public int getScheduleTaskCreator() {
        return scheduleTaskCreator;
    }

    public void setScheduleTaskCreator(int scheduleTaskCreator) {
        this.scheduleTaskCreator = scheduleTaskCreator;
    }

    public String getScheduleTaskComment() {
        return scheduleTaskComment;
    }

    public void setScheduleTaskComment(String scheduleTaskComment) {
        this.scheduleTaskComment = scheduleTaskComment;
    }

    public Timestamp getScheduleTaskCreateTime() {
        return scheduleTaskCreateTime;
    }

    public void setScheduleTaskCreateTime(Timestamp scheduleTaskCreateTime) {
        this.scheduleTaskCreateTime = scheduleTaskCreateTime;
    }

    public Timestamp getScheduleTaskUpdateTime() {
        return scheduleTaskUpdateTime;
    }

    public void setScheduleTaskUpdateTime(Timestamp scheduleTaskUpdateTime) {
        this.scheduleTaskUpdateTime = scheduleTaskUpdateTime;
    }
}
