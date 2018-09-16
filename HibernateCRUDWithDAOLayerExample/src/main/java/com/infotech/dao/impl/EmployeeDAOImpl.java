package com.infotech.dao.impl;

import com.infotech.dao.EmployeeDAO;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void addEmployee(Employee employee) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(employee);
            System.out.println("Employee created with id: " +id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee fetchEmployeeById(int employeeId) {

        Employee employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employee = session.get(Employee.class, employeeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateEmployeeById(int employeeId, double newSalary) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                employee.setSalary(newSalary);
                session.beginTransaction();
                session.update(employee);
                session.getTransaction().commit();
            } else {
                System.out.println("Employee does not exists with provided id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(int employeeId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                session.beginTransaction();
                session.delete(employee);
                session.getTransaction().commit();
            } else {
                System.out.println("Employee does not exists with provided id.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
