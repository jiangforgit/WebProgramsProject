package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "scorevalue_tb", schema = "my_course", catalog = "")
public class ScorevalueTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ScoreValueId")
    private int scoreValueId;
    @Basic
    @Column(name = "ScoreValue")
    private double scoreValue;
    @Basic
    @Column(name = "ScoreValueSTypeId")
    private int scoreValueSTypeId;
    @Basic
    @Column(name = "ScoreValueScoreId")
    private int scoreValueScoreId;
    @Basic
    @Column(name = "ScoreValueCreateTime")
    private Timestamp scoreValueCreateTime;
    @Basic
    @Column(name = "ScoreValueUpdateTime")
    private Timestamp scoreValueUpdateTime;

    public int getScoreValueId() {
        return scoreValueId;
    }

    public void setScoreValueId(int scoreValueId) {
        this.scoreValueId = scoreValueId;
    }

    public double getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(double scoreValue) {
        this.scoreValue = scoreValue;
    }

    public int getScoreValueSTypeId() {
        return scoreValueSTypeId;
    }

    public void setScoreValueSTypeId(int scoreValueSTypeId) {
        this.scoreValueSTypeId = scoreValueSTypeId;
    }

    public int getScoreValueScoreId() {
        return scoreValueScoreId;
    }

    public void setScoreValueScoreId(int scoreValueScoreId) {
        this.scoreValueScoreId = scoreValueScoreId;
    }

    public Timestamp getScoreValueCreateTime() {
        return scoreValueCreateTime;
    }

    public void setScoreValueCreateTime(Timestamp scoreValueCreateTime) {
        this.scoreValueCreateTime = scoreValueCreateTime;
    }

    public Timestamp getScoreValueUpdateTime() {
        return scoreValueUpdateTime;
    }

    public void setScoreValueUpdateTime(Timestamp scoreValueUpdateTime) {
        this.scoreValueUpdateTime = scoreValueUpdateTime;
    }
}
