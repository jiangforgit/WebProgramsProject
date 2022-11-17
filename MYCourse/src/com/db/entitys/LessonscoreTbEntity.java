package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "lessonscore_tb", schema = "my_course", catalog = "")
public class LessonscoreTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LessonScoreId")
    private int lessonScoreId;
    @Basic
    @Column(name = "LessonScore")
    private Double lessonScore;
    @Basic
    @Column(name = "LessonScoreLId")
    private int lessonScoreLId;
    @Basic
    @Column(name = "LessonScoreSId")
    private int lessonScoreSId;
    @Basic
    @Column(name = "LessonScoreCreateTime")
    private Timestamp lessonScoreCreateTime;
    @Basic
    @Column(name = "LessonScoreUpdateTime")
    private Timestamp lessonScoreUpdateTime;

    public int getLessonScoreId() {
        return lessonScoreId;
    }

    public void setLessonScoreId(int lessonScoreId) {
        this.lessonScoreId = lessonScoreId;
    }

    public Double getLessonScore() {
        return lessonScore;
    }

    public void setLessonScore(Double lessonScore) {
        this.lessonScore = lessonScore;
    }

    public int getLessonScoreLId() {
        return lessonScoreLId;
    }

    public void setLessonScoreLId(int lessonScoreLId) {
        this.lessonScoreLId = lessonScoreLId;
    }

    public int getLessonScoreSId() {
        return lessonScoreSId;
    }

    public void setLessonScoreSId(int lessonScoreSId) {
        this.lessonScoreSId = lessonScoreSId;
    }

    public Timestamp getLessonScoreCreateTime() {
        return lessonScoreCreateTime;
    }

    public void setLessonScoreCreateTime(Timestamp lessonScoreCreateTime) {
        this.lessonScoreCreateTime = lessonScoreCreateTime;
    }

    public Timestamp getLessonScoreUpdateTime() {
        return lessonScoreUpdateTime;
    }

    public void setLessonScoreUpdateTime(Timestamp lessonScoreUpdateTime) {
        this.lessonScoreUpdateTime = lessonScoreUpdateTime;
    }
}
