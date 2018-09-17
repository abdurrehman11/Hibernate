package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class MergeUpdateClientTest {

    public static void main(String[] args) {

        Employee employee1 = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employee1 = session.get(Employee.class, 1);
            System.out.println(employee1);
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        employee1.setSalary(75000.00);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Employee employee2 = session.get(Employee.class, 2);
            employee2.setSalary(55000.00);

            // USE Update -> if we are dealing with any object in the same session then we
            // should use update() or saveOrUpdate() method.
            session.update(employee2);

            // USE Merge -> if you want to save your modifications at any time with out knowing about
            // the state of an session.
            session.merge(employee1);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}
