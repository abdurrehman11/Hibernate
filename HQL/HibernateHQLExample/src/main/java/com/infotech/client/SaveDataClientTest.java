package com.infotech.client;

import com.infotech.entities.Backup;
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

            Backup backup1 = new Backup();
            backup1.setEmployeeName("Ali Ahsan");
            backup1.setSalary(80000.2872);
            backup1.setDoj(HibernateUtil.getDoj("18/12/2014"));
            backup1.setDeptName("IT");
            backup1.setBonus(new BigDecimal("277.839"));
            backup1.setEmail("ahsan@gmail.com");

            Backup backup2 = new Backup();
            backup2.setEmployeeName("Bilal Aamir");
            backup2.setSalary(70000.2872);
            backup2.setDoj(HibernateUtil.getDoj("18/12/2014"));
            backup2.setDeptName("IT");
            backup2.setBonus(new BigDecimal("277.839"));
            backup2.setEmail("bilal@gmail.com");

            session.save(employee1);
            session.save(employee2);

            session.save(backup1);
            session.save(backup2);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
