package com.infotech.model;

public class EmployeeStatistics {

    private Long empCount;
    private Double avgSalary;
    private Double minSalary;
    private Double sumSalary;

    public EmployeeStatistics(Long empCount, Double avgSalary, Double minSalary, Double sumSalary) {
        super();
        this.empCount = empCount;
        this.avgSalary = avgSalary;
        this.minSalary = minSalary;
        this.sumSalary = sumSalary;
    }

    public Long getEmpCount() {
        return empCount;
    }

    public void setEmpCount(Long empCount) {
        this.empCount = empCount;
    }

    public Double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(Double avgSalary) {
        this.avgSalary = avgSalary;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getSumSalary() {
        return sumSalary;
    }

    public void setSumSalary(Double sumSalary) {
        this.sumSalary = sumSalary;
    }

    @Override
    public String toString() {
        return "EmployeeStatistics{" +
                "empCount=" + empCount +
                ", avgSalary=" + avgSalary +
                ", minSalary=" + minSalary +
                ", sumSalary=" + sumSalary +
                '}';
    }
}
