package com.db.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "coursestudent_tb", schema = "my_course", catalog = "")
//@IdClass(CoursestudentTbEntityPK.class)
public class CoursestudentTbEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CourseStudentCId")
    private int courseStudentCId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CourseStudentSId")
    private int courseStudentSId;
    @Basic
    @Column(name = "CourseTotalNum")
    private Integer courseTotalNum;
    @Basic
    @Column(name = "CourseStudentCreateTime")
    private Timestamp courseStudentCreateTime;
    @Basic
    @Column(name = "CourseStudentUpdateTime")
    private Timestamp courseStudentUpdateTime;

    public int getCourseStudentCId() {
        return courseStudentCId;
    }

    public void setCourseStudentCId(int courseStudentCId) {
        this.courseStudentCId = courseStudentCId;
    }

    public int getCourseStudentSId() {
        return courseStudentSId;
    }

    public void setCourseStudentSId(int courseStudentSId) {
        this.courseStudentSId = courseStudentSId;
    }

    public Integer getCourseTotalNum() {
        return courseTotalNum;
    }

    public void setCourseTotalNum(Integer courseTotalNum) {
        this.courseTotalNum = courseTotalNum;
    }

    public Timestamp getCourseStudentCreateTime() {
        return courseStudentCreateTime;
    }

    public void setCourseStudentCreateTime(Timestamp courseStudentCreateTime) {
        this.courseStudentCreateTime = courseStudentCreateTime;
    }

    public Timestamp getCourseStudentUpdateTime() {
        return courseStudentUpdateTime;
    }

    public void setCourseStudentUpdateTime(Timestamp courseStudentUpdateTime) {
        this.courseStudentUpdateTime = courseStudentUpdateTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseStudentCId, courseStudentSId,courseTotalNum,courseStudentCreateTime,courseStudentUpdateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursestudentTbEntity that = (CoursestudentTbEntity) o;
        return courseStudentCId == that.courseStudentCId && courseStudentSId == that.courseStudentSId &&
                courseTotalNum == that.courseTotalNum && courseStudentCreateTime == that.courseStudentCreateTime &&
                courseStudentUpdateTime == that.courseStudentUpdateTime;
    }
}
