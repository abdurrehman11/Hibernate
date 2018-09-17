package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.model.Address;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            // ====  CRUD Operations  =====
            createEmployee(session);
            //getEmployeeById(session);
            //updateEmployeeById(session);      // update query can be made efficient by using @Dynamic annotation on table
            //deleteEmployeeById(session);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void deleteEmployeeById(Session session) {
        Employee employee = session.get(Employee.class, 2);
        if (employee != null) {
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        } else {
            System.out.println("Employee does not exists with provided id");
        }
    }

    private static void updateEmployeeById(Session session) {
        Employee employee = session.get(Employee.class, 2);
        if (employee != null) {
            employee.setSalary(80000.00);

            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        } else {
            System.out.println("Employee does not exists with provided id");
        }
    }

    private static void getEmployeeById(Session session) {
        Employee employee = session.get(Employee.class, 2);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee does not exists with provided id");
        }
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Kamil Niazi");
        employee.setEmail("Kamil@gmail.com");
        employee.setSalary(90000.00);
        employee.setDoj(new Date());

        Address homeAddress = new Address();
        homeAddress.setCity("Lahore");
        homeAddress.setStreet("Gulshan Town");
        homeAddress.setState("Pakistan");
        homeAddress.setPincode(123456L);

        Address officeAddress = new Address();
        officeAddress.setCity("Sahiwal");
        officeAddress.setStreet("Gulshan Town");
        officeAddress.setState("Pakistan");
        officeAddress.setPincode(123456L);

        employee.setHomeAddress(homeAddress);
        employee.setOfficeAddress(officeAddress);
        return employee;
    }

    private static void createEmployee(Session session) {
        session.beginTransaction();
        Integer id = (Integer) session.save(getEmployee());
        System.out.println("Employee created with id: " +id);
        session.getTransaction().commit();
    }
}
