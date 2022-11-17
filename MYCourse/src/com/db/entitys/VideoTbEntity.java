package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "video_tb", schema = "my_course", catalog = "")
public class VideoTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "VideoId")
    private int videoId;
    @Basic
    @Column(name = "VideoDescribe")
    private String videoDescribe;
    @Basic
    @Column(name = "VideoMaxOnlineNum")
    private byte videoMaxOnlineNum;
    @Basic
    @Column(name = "VideoType")
    private byte videoType;
    @Basic
    @Column(name = "VideoCreateTime")
    private Timestamp videoCreateTime;
    @Basic
    @Column(name = "VideoUpdateTime")
    private Timestamp videoUpdateTime;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoDescribe() {
        return videoDescribe;
    }

    public void setVideoDescribe(String videoDescribe) {
        this.videoDescribe = videoDescribe;
    }

    public byte getVideoMaxOnlineNum() {
        return videoMaxOnlineNum;
    }

    public void setVideoMaxOnlineNum(byte videoMaxOnlineNum) {
        this.videoMaxOnlineNum = videoMaxOnlineNum;
    }

    public byte getVideoType() {
        return videoType;
    }

    public void setVideoType(byte videoType) {
        this.videoType = videoType;
    }

    public Timestamp getVideoCreateTime() {
        return videoCreateTime;
    }

    public void setVideoCreateTime(Timestamp videoCreateTime) {
        this.videoCreateTime = videoCreateTime;
    }

    public Timestamp getVideoUpdateTime() {
        return videoUpdateTime;
    }

    public void setVideoUpdateTime(Timestamp videoUpdateTime) {
        this.videoUpdateTime = videoUpdateTime;
    }
}
