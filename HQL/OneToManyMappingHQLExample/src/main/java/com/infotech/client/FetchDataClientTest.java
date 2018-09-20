package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import org.hibernate.query.Query;

import java.util.List;

public class FetchDataClientTest {

    public static void main(String[] args) {

//        getEmployeeAndAdressByEmployeeId();
        getEmployeeAndAdressFieldsByEmployeeId();
    }

    private static void getEmployeeAndAdressByEmployeeId() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "FROM Employee WHERE employeeId = :empId";
            Query<Employee> query =  session.createQuery(HQL, Employee.class);
            query.setParameter("empId", 1);
            Employee employee = query.uniqueResult();
            System.out.println(employee);

            if (employee != null) {
                employee.getAddressList().forEach(System.out::println);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getEmployeeAndAdressFieldsByEmployeeId() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "SELECT emp.employeeName, emp.salary, addr.city , addr.pincode FROM Employee emp LEFT JOIN emp.addressList addr WHERE emp.employeeId = :empId";
            Query<Object[]> query =  session.createQuery(HQL);
            query.setParameter("empId", 1);
            List<Object []> list = query.list();
            for (Object[] objects : list) {
                String name = (String) objects[0];
                Double salary = (Double) objects[1];
                String city = (String) objects[2];
                Long pincode = (Long) objects[3];
                System.out.println(name + "\t" + salary + "\t" + city + "\t" + pincode + "\t");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
