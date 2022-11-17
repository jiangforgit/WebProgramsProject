package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "msgstatus_tb", schema = "my_course", catalog = "")
public class MsgstatusTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MsgStatusId")
    private int msgStatusId;
    @Basic
    @Column(name = "MsgStatus")
    private byte msgStatus;
    @Basic
    @Column(name = "MsgStatusMId")
    private int msgStatusMId;
    @Basic
    @Column(name = "MsgStatusCreatorType")
    private byte msgStatusCreatorType;
    @Basic
    @Column(name = "MsgStatusCreatorId")
    private int msgStatusCreatorId;
    @Basic
    @Column(name = "MsgStatusCreateTime")
    private Timestamp msgStatusCreateTime;
    @Basic
    @Column(name = "MsgStatusUpdateTime")
    private Timestamp msgStatusUpdateTime;

    public int getMsgStatusId() {
        return msgStatusId;
    }

    public void setMsgStatusId(int msgStatusId) {
        this.msgStatusId = msgStatusId;
    }

    public byte getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(byte msgStatus) {
        this.msgStatus = msgStatus;
    }

    public int getMsgStatusMId() {
        return msgStatusMId;
    }

    public void setMsgStatusMId(int msgStatusMId) {
        this.msgStatusMId = msgStatusMId;
    }

    public byte getMsgStatusCreatorType() {
        return msgStatusCreatorType;
    }

    public void setMsgStatusCreatorType(byte msgStatusCreatorType) {
        this.msgStatusCreatorType = msgStatusCreatorType;
    }

    public int getMsgStatusCreatorId() {
        return msgStatusCreatorId;
    }

    public void setMsgStatusCreatorId(int msgStatusCreatorId) {
        this.msgStatusCreatorId = msgStatusCreatorId;
    }

    public Timestamp getMsgStatusCreateTime() {
        return msgStatusCreateTime;
    }

    public void setMsgStatusCreateTime(Timestamp msgStatusCreateTime) {
        this.msgStatusCreateTime = msgStatusCreateTime;
    }

    public Timestamp getMsgStatusUpdateTime() {
        return msgStatusUpdateTime;
    }

    public void setMsgStatusUpdateTime(Timestamp msgStatusUpdateTime) {
        this.msgStatusUpdateTime = msgStatusUpdateTime;
    }
}
