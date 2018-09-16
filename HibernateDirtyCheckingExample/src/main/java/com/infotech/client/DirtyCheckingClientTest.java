package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;


public class DirtyCheckingClientTest {

    public static void main(String[] args) {

        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Employee employee = session.get(Employee.class, 1);
            if (employee != null) {
                // Hibernate keeps track of the state of object and if its change, it will update the object into database
                // State tracking remains from beginning to end of transaction

                // start of transaction
                session.beginTransaction();
                employee.setEmployeeName("Waleed Jajja");
                employee.setSalary(55000.00);
                session.getTransaction().commit();
                // end of transaction

                // no change will reflect into database because it is outside transaction
                employee.setEmail("waleedahman@gmail.com");
            } else {
                System.out.println("Employee does not exists with provided id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
