package com.hb13.getandloadmethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13 {

    public static void main(String[] args) {


        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        System.out.println("*********** get method start **************");
//        Student13 student1 = session.get(Student13.class,5L);
//        System.out.println(student1);
//        System.out.println("*********** get method end **************");
        System.out.println("*********** load method start **************");
        Student13 student2 = session.load(Student13.class,1L);
        System.out.println(student2);
        System.out.println("*********** load method end **************");

        if (student2!=null){
           System.out.println(student2.getName());}



        tx.commit();
        session.close();
        sf.close();
    }
}