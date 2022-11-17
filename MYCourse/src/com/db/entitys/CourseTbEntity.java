package com.db.entitys;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "course_tb", schema = "my_course", catalog = "")
public class CourseTbEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CourseId")
    private int courseId;
    @Basic
    @Column(name = "CourseName")
    private String courseName;
    @Basic
    @Column(name = "CourseDescribe")
    private String courseDescribe;
    @Basic
    @Column(name = "CourseGeneralView")
    private String courseGeneralView;
    @Basic
    @Column(name = "CourseSchoolId")
    private int courseSchoolId;
    @Basic
    @Column(name = "CourseCreateTime")
    private Timestamp courseCreateTime;
    @Basic
    @Column(name = "CourseUpdateTime")
    private Timestamp courseUpdateTime;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescribe() {
        return courseDescribe;
    }

    public void setCourseDescribe(String courseDescribe) {
        this.courseDescribe = courseDescribe;
    }

    public String getCourseGeneralView() {
        return courseGeneralView;
    }

    public void setCourseGeneralView(String courseGeneralView) {
        this.courseGeneralView = courseGeneralView;
    }

    public int getCourseSchoolId() {
        return courseSchoolId;
    }

    public void setCourseSchoolId(int courseSchoolId) {
        this.courseSchoolId = courseSchoolId;
    }

    public Timestamp getCourseCreateTime() {
        return courseCreateTime;
    }

    public void setCourseCreateTime(Timestamp courseCreateTime) {
        this.courseCreateTime = courseCreateTime;
    }

    public Timestamp getCourseUpdateTime() {
        return courseUpdateTime;
    }

    public void setCourseUpdateTime(Timestamp courseUpdateTime) {
        this.courseUpdateTime = courseUpdateTime;
    }
}
