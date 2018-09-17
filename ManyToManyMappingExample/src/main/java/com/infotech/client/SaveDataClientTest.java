package com.infotech.client;

import com.infotech.entities.Address;
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

    private static void createEmployee(Session session) {
        session.beginTransaction();
        Employee employee1 = new Employee();
        employee1.setEmployeeName("abc de");
        employee1.setEmail("abc@gmail.com");
        employee1.setSalary(80000.00);
        employee1.setDoj(new Date());

        Employee employee2 = new Employee();
        employee2.setEmployeeName("xy zk");
        employee2.setEmail("xyz@gmail.com");
        employee2.setSalary(70000.00);
        employee2.setDoj(new Date());

        Address address1 = new Address();
        address1.setCity("Lahore");
        address1.setStreet("Gulshan Town");
        address1.setState("Pakistan");
        address1.setPincode(123456L);

        Address address2 = new Address();
        address2.setCity("Fsd");
        address2.setStreet("Model Town");
        address2.setState("Pakistan");
        address2.setPincode(123456L);

        Address address3 = new Address();
        address3.setCity("Multan");
        address3.setStreet("Johar Town");
        address3.setState("Pakistan");
        address3.setPincode(126456L);


        employee1.getAddressList().add(address1);
        employee1.getAddressList().add(address2);
        employee1.getAddressList().add(address3);

        address1.getEmployeeList().add(employee1);
        address2.getEmployeeList().add(employee1);
        address3.getEmployeeList().add(employee1);

        employee2.getAddressList().add(address2);
        employee2.getAddressList().add(address3);

        address2.getEmployeeList().add(employee2);
        address3.getEmployeeList().add(employee2);

        session.persist(employee1);
        session.persist(employee2);

        session.getTransaction().commit();
    }

}
