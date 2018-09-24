package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import java.math.BigDecimal;

public class SaveDataClientTest {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            Employee employee1 = new Employee();
            employee1.setEmployeeName("Ali Ahsan");
            employee1.setSalary(80000.2872);
            employee1.setDoj(HibernateUtil.getDoj("18/12/2014"));
            employee1.setDeptName("IT");
            employee1.setBonus(new BigDecimal("277.839"));
            employee1.setEmail("ahsan@gmail.com");

            Employee employee2 = new Employee();
            employee2.setEmployeeName("Bilal Aamir");
            employee2.setSalary(70000.2872);
            employee2.setDoj(HibernateUtil.getDoj("18/12/2014"));
            employee2.setDeptName("IT");
            employee2.setBonus(new BigDecimal("277.839"));
            employee2.setEmail("bilal@gmail.com");

            session.save(employee1);
            session.save(employee2);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
