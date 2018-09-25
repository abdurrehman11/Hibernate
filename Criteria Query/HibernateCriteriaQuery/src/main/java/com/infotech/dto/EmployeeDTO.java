package com.infotech.dto;

public class EmployeeDTO {

    private String employeeName;
    private String email;
    private Double salary;

    public EmployeeDTO(String employeeName, String email, Double salary) {
        this.employeeName = employeeName;
        this.email = email;
        this.salary = salary;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
