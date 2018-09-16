package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class SavingEntityClientTest {

    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            createEmployee(session);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private static void createEmployee(Session session) {
        session.beginTransaction();
        Integer id = (Integer) session.save(getEmployee());
        System.out.println("Employee created with id: " +id);
        session.getTransaction().commit();
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Waleed Ahmand");
        employee.setEmail("waleed@gmail.com");
        employee.setSalary(76000.00);
        employee.setDoj(new Date());

        return employee;
    }
}
