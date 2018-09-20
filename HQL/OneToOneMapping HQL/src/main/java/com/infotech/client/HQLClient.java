package com.infotech.client;

import com.infotech.entities.Address;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class HQLClient {

    public static void main(String[] args) {

//        getEmployeeAndAdressByEmployeeId();
//        getEmployeeAndAdressByAddressId();
        getEmployeeAndAdressFieldsByAddressId();
    }

    private static void getEmployeeAndAdressByEmployeeId() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "FROM Employee emp LEFT JOIN FETCH emp.address WHERE emp.employeeId = :empId";
            Query<Employee> query = session.createQuery(HQL, Employee.class);
            query.setParameter("empId", 1);
            Employee employee = query.uniqueResult();
            System.out.println(employee);
            Address address = employee.getAddress();
            System.out.println(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getEmployeeAndAdressByAddressId() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "FROM Address addr LEFT JOIN FETCH addr.employee WHERE addr.addressId = :addId";
            Query<Address> query = session.createQuery(HQL, Address.class);
            query.setParameter("addId", 1);
            Address address = query.uniqueResult();
            System.out.println(address);
            Employee employee = address.getEmployee();
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getEmployeeAndAdressFieldsByAddressId() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "SELECT emp.employeeName, emp.doj, emp.salary, addr.city, addr.pincode FROM Employee emp LEFT JOIN emp.address addr WHERE emp.employeeId = :empId";
            Query<Object []> query = session.createQuery(HQL);
            query.setParameter("empId", 1);
            List<Object[]> list = query.list();
            for (Object[] objects : list) {
                String name = (String) objects[0];
                Date doj = (Date) objects[1];
                Double salary = (Double) objects[2];
                String city = (String) objects[3];
                Long pincode = (Long) objects[4];
                System.out.println(name + "\t" + doj + "\t" + salary + "\t" + city + "\t" + pincode + "\t");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
