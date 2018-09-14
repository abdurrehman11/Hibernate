package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            session.beginTransaction();

            /*
            persist() -> This method is used to save an entity/object into database and return a void.
            It will throw an exception if an entity/object already exists in the database.
            */
            session.persist(getEmployee1());

            /*
            save() -> This method is used to save an entity/object into database and return generated primary key.
            It will throw an exception if an entity/object already exists in the database.
            */
            Integer id = (Integer) session.save(getEmployee2());
            System.out.println("Employee created with id: " +id);

            /*
            saveOrUpdate() -> This method is used to either save or update an entity in the database.
            If an entity already exists, it will update otherwise it will save into database.
            */
            session.saveOrUpdate(getEmployee3());

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static Employee getEmployee1() {
        Employee employee = new Employee();
        employee.setEmployeeName("Ali Ahsan");
        employee.setEmail("aliiahsan@gmail.com");
        employee.setSalary(90000.00);
        employee.setDoj(new Date());

        return employee;
    }

    private static Employee getEmployee2() {
        Employee employee = new Employee();
        employee.setEmployeeName("Bilal Aamir");
        employee.setEmail("bilalaamir@gmail.com");
        employee.setSalary(70000.00);
        employee.setDoj(new Date());

        return employee;
    }

    private static Employee getEmployee3() {
        Employee employee = new Employee();
        employee.setEmployeeId(4);
        employee.setEmployeeName("Waqar Ahmad");
        employee.setEmail("waqarnadir@gmail.com");
        employee.setSalary(60000.00);
        employee.setDoj(new Date());

        return employee;
    }
}
