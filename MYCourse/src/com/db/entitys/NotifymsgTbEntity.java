package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "notifymsg_tb", schema = "my_course", catalog = "")
public class NotifymsgTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NotifyMsgId")
    private int notifyMsgId;
    @Basic
    @Column(name = "NotifyMsgType")
    private byte notifyMsgType;
    @Basic
    @Column(name = "NotifyMsgContent")
    private String notifyMsgContent;
    @Basic
    @Column(name = "NotifyMsgRelatedType")
    private byte notifyMsgRelatedType;
    @Basic
    @Column(name = "NotifyMsgRelatedId")
    private int notifyMsgRelatedId;
    @Basic
    @Column(name = "NotifyMsgCreatorType")
    private byte notifyMsgCreatorType;
    @Basic
    @Column(name = "NotifyMsgCreatorId")
    private int notifyMsgCreatorId;
    @Basic
    @Column(name = "NotifyMsgCreateTime")
    private Timestamp notifyMsgCreateTime;
    @Basic
    @Column(name = "NotifyMsgUpdateTime")
    private Timestamp notifyMsgUpdateTime;

    public int getNotifyMsgId() {
        return notifyMsgId;
    }

    public void setNotifyMsgId(int notifyMsgId) {
        this.notifyMsgId = notifyMsgId;
    }

    public byte getNotifyMsgType() {
        return notifyMsgType;
    }

    public void setNotifyMsgType(byte notifyMsgType) {
        this.notifyMsgType = notifyMsgType;
    }

    public String getNotifyMsgContent() {
        return notifyMsgContent;
    }

    public void setNotifyMsgContent(String notifyMsgContent) {
        this.notifyMsgContent = notifyMsgContent;
    }

    public byte getNotifyMsgRelatedType() {
        return notifyMsgRelatedType;
    }

    public void setNotifyMsgRelatedType(byte notifyMsgRelatedType) {
        this.notifyMsgRelatedType = notifyMsgRelatedType;
    }

    public int getNotifyMsgRelatedId() {
        return notifyMsgRelatedId;
    }

    public void setNotifyMsgRelatedId(int notifyMsgRelatedId) {
        this.notifyMsgRelatedId = notifyMsgRelatedId;
    }

    public byte getNotifyMsgCreatorType() {
        return notifyMsgCreatorType;
    }

    public void setNotifyMsgCreatorType(byte notifyMsgCreatorType) {
        this.notifyMsgCreatorType = notifyMsgCreatorType;
    }

    public int getNotifyMsgCreatorId() {
        return notifyMsgCreatorId;
    }

    public void setNotifyMsgCreatorId(int notifyMsgCreatorId) {
        this.notifyMsgCreatorId = notifyMsgCreatorId;
    }

    public Timestamp getNotifyMsgCreateTime() {
        return notifyMsgCreateTime;
    }

    public void setNotifyMsgCreateTime(Timestamp notifyMsgCreateTime) {
        this.notifyMsgCreateTime = notifyMsgCreateTime;
    }

    public Timestamp getNotifyMsgUpdateTime() {
        return notifyMsgUpdateTime;
    }

    public void setNotifyMsgUpdateTime(Timestamp notifyMsgUpdateTime) {
        this.notifyMsgUpdateTime = notifyMsgUpdateTime;
    }
}
