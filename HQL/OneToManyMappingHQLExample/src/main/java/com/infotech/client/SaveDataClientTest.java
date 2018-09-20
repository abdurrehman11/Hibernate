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

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Kamil Niazi");
        employee.setEmail("Kamil@gmail.com");
        employee.setSalary(90000.00);
        employee.setDoj(new Date());

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

        employee.getAddressList().add(address1);
        employee.getAddressList().add(address2);

        address1.setEmployee(employee);
        address2.setEmployee(employee);

        return employee;
    }

    private static void createEmployee(Session session) {
        session.beginTransaction();
        session.persist(getEmployee());
        session.getTransaction().commit();
    }
}
