package com.infotech.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    private  static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        // Hibernate Settings which is equivalent to "hibernate.cfg.xml"
        Map<String, String> dbSettings = new HashMap<>();
        dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/demo");
        dbSettings.put(Environment.USER, "root");
        dbSettings.put(Environment.PASS, "root");
        dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

        // Apply database settings
        registryBuilder.applySettings(dbSettings);

        // Creating Registry
        standardServiceRegistry = registryBuilder.build();

        // Creating MetaDataSources
        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

        // Creating Metadata
        Metadata metadata = metadataSources.getMetadataBuilder().build();

        // Creating SessionFactory
        sessionFactory = metadata.getSessionFactoryBuilder().build();

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
