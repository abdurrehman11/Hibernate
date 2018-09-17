package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

public class DeleteDataClientTest {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            deleteEmployeeById(session);
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
        }
    }

}
