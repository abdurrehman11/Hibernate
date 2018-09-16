package com.infotech.service.impl;

import com.infotech.dao.impl.EmployeeDAOImpl;
import com.infotech.entities.Employee;
import com.infotech.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void createEmployee(Employee employee) {
        new EmployeeDAOImpl().addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return new EmployeeDAOImpl().fetchEmployeeById(employeeId);
    }

    @Override
    public void updateEmployeeById(int employeeId, double newSalary) {
        new EmployeeDAOImpl().updateEmployeeById(employeeId, newSalary);
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        new EmployeeDAOImpl().deleteEmployeeById(employeeId);
    }
}
