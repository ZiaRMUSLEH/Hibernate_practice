package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave11 {

    public static void main (String[] args) {

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student11.class);
        SessionFactory sessionFactory= con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();



        // Create 20 students, which got the name like: Student1, Student2,etc.     &&      Have their grades random, the limit is 100.
        Random random = new Random();

        for (int i = 1; i < 21; i++) {
            session.save(new Student11("Student"+i,random.nextInt(100)));
        }

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
