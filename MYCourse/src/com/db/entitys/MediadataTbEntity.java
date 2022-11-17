package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "mediadata_tb", schema = "my_course", catalog = "")
public class MediadataTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MediaDataId")
    private int mediaDataId;
    @Basic
    @Column(name = "MediaDataType")
    private byte mediaDataType;
    @Basic
    @Column(name = "MediaDataUri")
    private String mediaDataUri;
    @Basic
    @Column(name = "MediaDataMsg")
    private String mediaDataMsg;
    @Basic
    @Column(name = "MediaDataRelatedType")
    private byte mediaDataRelatedType;
    @Basic
    @Column(name = "MediaDataRelatedId")
    private int mediaDataRelatedId;
    @Basic
    @Column(name = "MediaDataCreateTime")
    private Timestamp mediaDataCreateTime;
    @Basic
    @Column(name = "MediaDataUpdateTime")
    private Timestamp mediaDataUpdateTime;

    public int getMediaDataId() {
        return mediaDataId;
    }

    public void setMediaDataId(int mediaDataId) {
        this.mediaDataId = mediaDataId;
    }

    public byte getMediaDataType() {
        return mediaDataType;
    }

    public void setMediaDataType(byte mediaDataType) {
        this.mediaDataType = mediaDataType;
    }

    public String getMediaDataUri() {
        return mediaDataUri;
    }

    public void setMediaDataUri(String mediaDataUri) {
        this.mediaDataUri = mediaDataUri;
    }

    public String getMediaDataMsg() {
        return mediaDataMsg;
    }

    public void setMediaDataMsg(String mediaDataMsg) {
        this.mediaDataMsg = mediaDataMsg;
    }

    public byte getMediaDataRelatedType() {
        return mediaDataRelatedType;
    }

    public void setMediaDataRelatedType(byte mediaDataRelatedType) {
        this.mediaDataRelatedType = mediaDataRelatedType;
    }

    public int getMediaDataRelatedId() {
        return mediaDataRelatedId;
    }

    public void setMediaDataRelatedId(int mediaDataRelatedId) {
        this.mediaDataRelatedId = mediaDataRelatedId;
    }

    public Timestamp getMediaDataCreateTime() {
        return mediaDataCreateTime;
    }

    public void setMediaDataCreateTime(Timestamp mediaDataCreateTime) {
        this.mediaDataCreateTime = mediaDataCreateTime;
    }

    public Timestamp getMediaDataUpdateTime() {
        return mediaDataUpdateTime;
    }

    public void setMediaDataUpdateTime(Timestamp mediaDataUpdateTime) {
        this.mediaDataUpdateTime = mediaDataUpdateTime;
    }
}
