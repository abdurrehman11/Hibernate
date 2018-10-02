package com.infotech.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HibernateUtil {

    private  static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        if (sessionFactory == null) {
            try {
                // If we use config file name other than "hibernate.cfg.xml", we have to pass that
                // name to -> configure("myConfig.cfg.xml")
                standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Date getDoj(String doj) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(doj);
    }

}
