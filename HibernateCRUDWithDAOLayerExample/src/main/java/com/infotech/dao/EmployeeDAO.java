package com.infotech.dao;

import com.infotech.entities.Employee;

public interface EmployeeDAO {

    public abstract void addEmployee(Employee employee);
    public abstract Employee fetchEmployeeById(int employeeId);
    public abstract void updateEmployeeById(int employeeId, double newSalary);
    public abstract void deleteEmployeeById(int employeeId);
}
