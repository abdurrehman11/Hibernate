package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.entities.Person;
import com.infotech.entities.Student;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.Date;

public class SaveDataClientTest {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Person person = new Person();
            person.setName("Waleed Ali");
            person.setGender("Male");

            Employee employee = new Employee();
            employee.setName("Ali Ahsan");
            employee.setGender("Male");
            employee.setSalary(80000.2872);
            employee.setDoj(HibernateUtil.getDoj("18/12/2014"));
            employee.setDeptName("IT");
            employee.setBonus(new BigDecimal("277.839"));
            employee.setEmail("ahsan@gmail.com");

            Student student = new Student();
            student.setName("Bilal Aamir");
            student.setGender("Male");
            student.setFee(2000.00f);
            student.setSchoolName("DPS");
            student.setSectionName("12th Std");

            session.beginTransaction();

            session.save(person);
            session.save(employee);
            session.save(student);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
