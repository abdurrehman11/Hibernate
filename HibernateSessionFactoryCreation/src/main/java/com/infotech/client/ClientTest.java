package com.infotech.client;

import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

public class ClientTest {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String SQL = "SELECT version();";
            String result = (String) session.createNativeQuery(SQL).getSingleResult();
            System.out.println("MySQL version :::");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
