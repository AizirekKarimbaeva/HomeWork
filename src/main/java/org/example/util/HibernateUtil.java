package org.example.util;

import org.example.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
        private final static SessionFactory sessionFactory;

        static {
            try {
                sessionFactory = buildSessionFactory();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private static SessionFactory buildSessionFactory() throws Throwable {
            try {
                return new Configuration()
                        .configure()
                        .addAnnotatedClass(Company.class)
                        .addAnnotatedClass(Driver.class)
                        .addAnnotatedClass(Car.class)
                        .addAnnotatedClass(Shop.class)
                        .addAnnotatedClass(Phone.class)
                        .addAnnotatedClass(User.class)
                        .addAnnotatedClass(Farm.class)
                        .addAnnotatedClass(Animal.class)
                        .addAnnotatedClass(Plant.class)
                        .buildSessionFactory();
            }catch (Throwable e){
                throw e;
            }
        }

        public static SessionFactory getSessionFactory(){
            return sessionFactory;
        }

        public void close(){
            sessionFactory.close();
        }
    }


