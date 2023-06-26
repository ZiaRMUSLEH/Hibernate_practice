package com.hb05.uni_manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class RunnerFetch05 {
    public static void main (String[] args) {

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student05.class)
                .addAnnotatedClass(University.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Get Method
        Student05 student1 = session.get(Student05.class, 1001L);
        System.out.println(student1);

        University university = session.get(University.class, 101L);
        System.out.println(university);

        // To access to the student's university
        System.out.println(student1.getUniversity());


        // Fetch the students whose university id is 101.
        System.out.println("\n******** Students with University ID: 101 ********");
        String hql1 = "FROM Student05 s WHERE s.university.id=101L";
        List<Object> students = session.createQuery(hql1).getResultList();
       // System.out.println(students);
        students.forEach(System.out::println);


        tx.commit();
        session.close();
        sf.close();


    }
}
