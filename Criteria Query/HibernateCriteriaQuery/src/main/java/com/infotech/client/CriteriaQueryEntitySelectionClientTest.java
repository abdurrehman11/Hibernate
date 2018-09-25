package com.infotech.client;

import com.infotech.dto.EmployeeDTO;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaQueryEntitySelectionClientTest {

    public static void main(String[] args) {

//        getAllEmployees();
//        getEmployeeById(2L);
//        getAllEmployeeNames();
//        getEmployeeNameEmailAndSalary();
//        getEmployeeNameEmailAndSalaryByDTO();
        getEmployeeNameEmailAndSalaryByTuple();
    }

    public static void getEmployeeById(Long id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> root = criteriaQuery.from(Employee.class);
            criteriaQuery.select(root);

            criteriaQuery.where(criteriaBuilder.equal(root.get("employeeId"), id));

            Query<Employee> query = session.createQuery(criteriaQuery);
            List<Employee> employeeList = query.list();
            employeeList.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllEmployees() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> root = criteriaQuery.from(Employee.class);
            criteriaQuery.select(root);

            Query<Employee> query = session.createQuery(criteriaQuery);
            List<Employee> employeeList = query.list();
            employeeList.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllEmployeeNames() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
            Root<Employee> root = criteriaQuery.from(Employee.class);
            criteriaQuery.select(root.get("employeeName"));

            Query<String> query = session.createQuery(criteriaQuery);
            List<String> empNames = query.getResultList();
            empNames.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getEmployeeNameEmailAndSalary() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
            Root<Employee> root = criteriaQuery.from(Employee.class);

            Path<Object> employeeNamePath = root.get("employeeName");
            Path<Object> emailPath = root.get("email");
            Path<Object> salaryPath = root.get("salary");

//            criteriaQuery.select(criteriaBuilder.array(employeeNamePath, emailPath, salaryPath));
            criteriaQuery.multiselect(employeeNamePath, emailPath, salaryPath);

            Query<Object[]> query = session.createQuery(criteriaQuery);
            List<Object[]> list = query.getResultList();
            for (Object[] objects : list) {
                System.out.println("Employee Name : " + (String) objects[0]);
                System.out.println("Employee email : " + (String ) objects[1]);
                System.out.println("Employee salary : " + (Double) objects[2] + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getEmployeeNameEmailAndSalaryByDTO() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<EmployeeDTO> criteriaQuery = criteriaBuilder.createQuery(EmployeeDTO.class);
            Root<Employee> root = criteriaQuery.from(Employee.class);

            Path<Object> employeeNamePath = root.get("employeeName");
            Path<Object> emailPath = root.get("email");
            Path<Object> salaryPath = root.get("salary");

            // in case of DTO
            criteriaQuery.select(criteriaBuilder.construct(EmployeeDTO.class, employeeNamePath, emailPath, salaryPath));

            Query<EmployeeDTO> query = session.createQuery(criteriaQuery);
            List<EmployeeDTO> resultList = query.getResultList();
            for (EmployeeDTO employeeDTO : resultList) {
                System.out.println("Employee Name : " + employeeDTO.getEmployeeName());
                System.out.println("Employee email : " + employeeDTO.getEmail());
                System.out.println("Employee salary : " + employeeDTO.getSalary() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getEmployeeNameEmailAndSalaryByTuple() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
            Root<Employee> root = criteriaQuery.from(Employee.class);

            Path<Object> employeeNamePath = root.get("employeeName");
            Path<Object> emailPath = root.get("email");
            Path<Object> salaryPath = root.get("salary");

            criteriaQuery.multiselect(employeeNamePath, emailPath, salaryPath);
//            criteriaQuery.where(criteriaBuilder.equal(root.get("employeeId"), 1));

            Query<Tuple> query = session.createQuery(criteriaQuery);
            List<Tuple> resultList = query.getResultList();
            for (Tuple tuple : resultList) {
                String name = (String) tuple.get(employeeNamePath);
                String email = (String) tuple.get(emailPath);
                Double salary = (Double) tuple.get(salaryPath);
               System.out.println(name + "\t" + email + "\t" + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
