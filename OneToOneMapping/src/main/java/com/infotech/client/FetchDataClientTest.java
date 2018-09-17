package com.infotech.client;

import com.infotech.entities.Address;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

public class FetchDataClientTest {

    public static void main(String[] args) {

        getEmployeeAndAdressByEmployeeId();
        getEmployeeAndAdressByAddressId();
    }

    private static void getEmployeeAndAdressByEmployeeId() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee);
            Address address = employee.getAddress();
            System.out.println(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getEmployeeAndAdressByAddressId() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Address address = session.get(Address.class, 1);
            System.out.println(address);
            Employee employee = address.getEmployee();
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
