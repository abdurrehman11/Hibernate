package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.entities.Person;
import com.infotech.entities.Student;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

public class FetchDataClientTest {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Person person =  session.get(Person.class, 1);
            if (person instanceof Person && !(person instanceof Employee) && !(person instanceof Student)) {
                System.out.println(person);
            } else if (person instanceof Person && person instanceof Employee) {
                Employee employee = (Employee) person;
                System.out.println(employee);
            } else if (person instanceof Person && person instanceof Student) {
                Student student = (Student) person;
                System.out.println(student);
            }
            session.beginTransaction();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
