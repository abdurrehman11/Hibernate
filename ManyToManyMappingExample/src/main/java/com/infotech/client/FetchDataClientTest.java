package com.infotech.client;

import com.infotech.entities.Address;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

public class FetchDataClientTest {

    public static void main(String[] args) {

        //getEmployeeAndAdressByEmployeeId();
        getEmployeeAndAdressByAddressId();
    }

    private static void getEmployeeAndAdressByEmployeeId() {

        Employee employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employee = session.get(Employee.class, 1);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (employee != null) {
            employee.getAddressList().forEach(System.out::println);
        }
    }

    private static void getEmployeeAndAdressByAddressId() {

        Address address = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            address = session.get(Address.class, 2);
            System.out.println(address);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (address != null) {
            address.getEmployeeList().forEach(System.out::println);
        }
    }

}
