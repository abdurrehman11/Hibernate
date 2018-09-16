package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.service.EmployeeService;
import com.infotech.service.impl.EmployeeServiceImpl;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        //createEmployee(employeeService);
        getEmployeeById(employeeService);
        //updateEmployeeById(employeeService);
        //deleteEmployeeById(employeeService);

    }

    private static void createEmployee(EmployeeService employeeService) {
        employeeService.createEmployee(getEmployee());
    }

    private static void getEmployeeById(EmployeeService employeeService) {
        Employee employee = employeeService.getEmployeeById(1);
        System.out.println(employee);
    }

    private static void updateEmployeeById(EmployeeService employeeService) {
        employeeService.updateEmployeeById(1, 45000.00);
    }

    private static void deleteEmployeeById(EmployeeService employeeService) {
        employeeService.deleteEmployeeById(2);
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Kamil Niazi");
        employee.setEmail("Kamil@gmail.com");
        employee.setSalary(90000.00);
        employee.setDoj(new Date());

        return employee;
    }
}
