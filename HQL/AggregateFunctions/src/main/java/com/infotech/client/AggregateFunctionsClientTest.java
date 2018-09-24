package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.model.EmployeeStatistics;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import org.hibernate.query.Query;

import java.util.List;

public class AggregateFunctionsClientTest {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "SELECT new com.infotech.model.EmployeeStatistics (COUNT(e), AVG(e.salary), MIN(e.salary), SUM(e.salary))" +
                         " FROM Employee e";

            Query<EmployeeStatistics> query =  session.createQuery(HQL, EmployeeStatistics.class);
            EmployeeStatistics employeeStatistics = query.uniqueResult();

                System.out.println("Total no. of Employees: " + employeeStatistics.getEmpCount());
                System.out.println("Avg Salary: " + employeeStatistics.getAvgSalary());
                System.out.println("Min Salary: " + employeeStatistics.getMinSalary());
                System.out.println("Sum of Salary: " + employeeStatistics.getSumSalary());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
