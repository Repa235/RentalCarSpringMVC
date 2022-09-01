package com.example.rentalcarspringmvc.config;

import com.example.rentalcarspringmvc.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class HibernateConfig {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
    /**
     * Utility class
     */
    private HibernateConfig() {}
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
    private static SessionFactory buildSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(dbSettings())
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Prenotazione.class)
                .addAnnotatedClass(Utente.class)
                .addAnnotatedClass(Veicolo.class)
                .buildMetadata();
        return metadata.buildSessionFactory();
    }

    private static Map<String, String> dbSettings() {
        Map<String, String> dbSettings = new HashMap<>();
        dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
        dbSettings.put(Environment.USER, "root");
        dbSettings.put(Environment.PASS, "root");
        dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        dbSettings.put(Environment.SHOW_SQL, "true");
        dbSettings.put(Environment.HBM2DDL_AUTO, "update");
        dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        return dbSettings;
    }
}