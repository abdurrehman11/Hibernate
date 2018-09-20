package com.infotech.client;

import com.infotech.entities.Address;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import org.hibernate.query.Query;

public class HQLClient {

    public static void main(String[] args) {

//        getEmployeeAndAdressByEmployeeId();
        getEmployeeAndAdressByAddressId();
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
}
