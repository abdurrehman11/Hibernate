package com.infotech.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student extends Person {

    @Column(name = "school_name", length = 50)
    private String schoolName;

    @Column(name = "section_name", length = 50)
    private String sectionName;

    @Column(name = "fee")
    private Float fee;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student{" +
                "schoolName='" + schoolName + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", fee=" + fee +
                '}';
    }

}
