package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "scoretype_tb", schema = "my_course", catalog = "")
public class ScoretypeTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ScoreTypeId")
    private int scoreTypeId;
    @Basic
    @Column(name = "ScoreTypeName")
    private String scoreTypeName;
    @Basic
    @Column(name = "ScoreTypeMax")
    private double scoreTypeMax;
    @Basic
    @Column(name = "ScoreTypePercent")
    private double scoreTypePercent;
    @Basic
    @Column(name = "ScoreTypeDisplayType")
    private int scoreTypeDisplayType;
    @Basic
    @Column(name = "ScoreTypeDisplay")
    private String scoreTypeDisplay;
    @Basic
    @Column(name = "ScoreTypeRelateType")
    private int scoreTypeRelateType;
    @Basic
    @Column(name = "ScoreTypeRelateId")
    private Integer scoreTypeRelateId;
    @Basic
    @Column(name = "ScoreTypeCreateTime")
    private Timestamp scoreTypeCreateTime;
    @Basic
    @Column(name = "ScoreTypeUpdateTime")
    private Timestamp scoreTypeUpdateTime;

    public int getScoreTypeId() {
        return scoreTypeId;
    }

    public void setScoreTypeId(int scoreTypeId) {
        this.scoreTypeId = scoreTypeId;
    }

    public String getScoreTypeName() {
        return scoreTypeName;
    }

    public void setScoreTypeName(String scoreTypeName) {
        this.scoreTypeName = scoreTypeName;
    }

    public double getScoreTypeMax() {
        return scoreTypeMax;
    }

    public void setScoreTypeMax(double scoreTypeMax) {
        this.scoreTypeMax = scoreTypeMax;
    }

    public double getScoreTypePercent() {
        return scoreTypePercent;
    }

    public void setScoreTypePercent(double scoreTypePercent) {
        this.scoreTypePercent = scoreTypePercent;
    }

    public int getScoreTypeDisplayType() {
        return scoreTypeDisplayType;
    }

    public void setScoreTypeDisplayType(int scoreTypeDisplayType) {
        this.scoreTypeDisplayType = scoreTypeDisplayType;
    }

    public String getScoreTypeDisplay() {
        return scoreTypeDisplay;
    }

    public void setScoreTypeDisplay(String scoreTypeDisplay) {
        this.scoreTypeDisplay = scoreTypeDisplay;
    }

    public int getScoreTypeRelateType() {
        return scoreTypeRelateType;
    }

    public void setScoreTypeRelateType(int scoreTypeRelateType) {
        this.scoreTypeRelateType = scoreTypeRelateType;
    }

    public Integer getScoreTypeRelateId() {
        return scoreTypeRelateId;
    }

    public void setScoreTypeRelateId(Integer scoreTypeRelateId) {
        this.scoreTypeRelateId = scoreTypeRelateId;
    }

    public Timestamp getScoreTypeCreateTime() {
        return scoreTypeCreateTime;
    }

    public void setScoreTypeCreateTime(Timestamp scoreTypeCreateTime) {
        this.scoreTypeCreateTime = scoreTypeCreateTime;
    }

    public Timestamp getScoreTypeUpdateTime() {
        return scoreTypeUpdateTime;
    }

    public void setScoreTypeUpdateTime(Timestamp scoreTypeUpdateTime) {
        this.scoreTypeUpdateTime = scoreTypeUpdateTime;
    }
}
