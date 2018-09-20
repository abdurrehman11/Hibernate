package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;

import java.util.List;

public class HQLHibernate5ClientTest {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
//        getAllEmployees(sf);
//        getEmployeeById(sf);
//        getEmployeeByIdAndEmail(sf);
//        getAllEmployeeNames(sf);
//        getAllEmployeesIdAndNames(sf);
//        insertEmployeeRecord(sf);
//        updateEmployeeEmailById(sf);
        deleteEmployeeById(sf);
    }

    private static void deleteEmployeeById(SessionFactory sf) {
        int empId = 4;
        try (Session session = sf.openSession()) {

            String HQL = "DELETE FROM Employee WHERE employeeId = :empId";
            Query query = session.createQuery(HQL);
            query.setParameter("empId", empId);

            session.beginTransaction();
            int executeUpdate  = query.executeUpdate();
            if (executeUpdate > 0)
                System.out.println("Employeed deleted ..");
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateEmployeeEmailById(SessionFactory sf) {
        int empId = 2;
        String newEmail = "bilal123@gmail.com";
        try (Session session = sf.openSession()) {

            String HQL = "UPDATE Employee set email = :newEmail WHERE employeeId = :empId";
            Query query = session.createQuery(HQL);
            query.setParameter("newEmail", newEmail);
            query.setParameter("empId", empId);

            session.beginTransaction();
            int executeUpdate  = query.executeUpdate();
            if (executeUpdate > 0)
                System.out.println("Employeed email updated ..");
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertEmployeeRecord(SessionFactory sf) {
        try (Session session = sf.openSession()) {

            // Insertion can only be done by selection from some other table in Hibernate
            String HQL = "INSERT INTO Employee(employeeName, doj, salary, bonus, email, deptName)" +
                    "SELECT employeeName, doj, salary, bonus, email, deptName FROM Backup";

            Query query = session.createQuery(HQL);
            session.beginTransaction();
            int executeUpdate  = query.executeUpdate();
            if (executeUpdate > 0)
                System.out.println(executeUpdate + " recods are inserted successfully..");
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void getAllEmployees(SessionFactory sf) {
        try (Session session = sf.openSession()) {

            String HQL = "FROM Employee";
            Query<Employee> query = session.createQuery(HQL, Employee.class);
            List<Employee> employees = query.list();
            employees.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getEmployeeById(SessionFactory sf) {
        try (Session session = sf.openSession()) {

            int empId = 2;

            // Using placeHolders
            String HQL = "FROM Employee WHERE employeeId  = ?";
            Query<Employee> query = session.createQuery(HQL, Employee.class);
            query.setParameter(0, empId);
            Employee employee = query.uniqueResult();
            System.out.println(employee);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getEmployeeByIdAndEmail(SessionFactory sf) {
        try (Session session = sf.openSession()) {

            int empId = 2;
            String email = "bilal@gmail.com";

            // Using Named Parameters
            String HQL = "FROM Employee WHERE employeeId  = :empId AND email = :email";
            Query<Employee> query = session.createQuery(HQL, Employee.class);
            query.setParameter("empId", empId);
            query.setParameter("email", email);
            Employee employee = query.uniqueResult();
            System.out.println(employee);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getAllEmployeeNames(SessionFactory sf) {
        try (Session session = sf.openSession()) {

            String HQL = "SELECT employeeName FROM Employee";
            Query<String> query = session.createQuery(HQL);
            query.list().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getAllEmployeesIdAndNames(SessionFactory sf) {
        try (Session session = sf.openSession()) {

            String HQL = "SELECT employeeId, employeeName FROM Employee";
            Query query = session.createQuery(HQL);
            List<Object[]> list = query.list();
            for (Object[] objects : list) {
                Integer employeeId = (Integer) objects[0];
                String employeeName = (String) objects[1];
                System.out.println(employeeId + "\t" + employeeName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
