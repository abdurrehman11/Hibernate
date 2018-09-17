package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class SaveDataClientTest {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            createEmployee(session);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Ali Ahmad");
        employee.setEmail("ali@gmail.com");
        employee.setSalary(70000.00);
        employee.setDoj(new Date());
        return employee;
    }

    private static void createEmployee(Session session) {
        session.beginTransaction();
        session.save(getEmployee());
        session.getTransaction().commit();
    }
}
