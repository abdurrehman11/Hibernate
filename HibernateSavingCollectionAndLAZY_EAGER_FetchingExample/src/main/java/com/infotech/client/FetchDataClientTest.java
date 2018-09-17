package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

public class FetchDataClientTest {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = null;
        try {
            employee = session.get(Employee.class, 1);
            System.out.println(employee);

            // Do this, while Lazy Loading
//            if (employee != null) {
//                employee.getAddressList().forEach(System.out::println);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        // run only in case of EAGER Loading
        employee.getAddressList().forEach(System.out::println);
    }
}
