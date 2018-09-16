package com.infotech.entities;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_table")
@DynamicUpdate
public class Employee {

    /*
    Default Strategy is AUTO.
    AUTO -> Hibernate selects generation strategy based on the used dialect.
    AUTO -> in this strategy, customized PK table can also be created.
    */
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "empid_generator")
    //@SequenceGenerator(name = "empid_generator", initialValue = 1, allocationSize = 1, sequenceName = "empid_seq")

    /*
    IDENTITY -> Hibernate relies on auto-incremented database column to generate the PK.
    It is very efficient but it has drawback in batch operations.
    */
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    /*
    SEQUENCE -> It is useful in batch operations.
    Hibernate requests the PK value from a database sequence.
    */
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empid_generator")
    //@SequenceGenerator(name = "empid_generator", initialValue = 1, allocationSize = 1, sequenceName = "empid_seq")

    /*
    TABLE -> It is rarely used and it slows down the application.
    Hibernate uses a database table to simulate a sequence for PK generation.
    */
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "empid_generator")
    @TableGenerator(name = "empid_generator", initialValue = 1, allocationSize = 1, table = "empid_seq")

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name", length = 100, nullable = false)
    private String employeeName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "date_of_joining")
    private Date doj;

    @Column(name = "salary")
    private Double salary;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
