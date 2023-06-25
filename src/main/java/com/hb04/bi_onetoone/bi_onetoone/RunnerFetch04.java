package com.hb04.bi_onetoone.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main (String[] args) {

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Diary.class)
                .addAnnotatedClass(Student04.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Get Student with id: 1001 and Diary with id: 101.
        Student04 student04 = session.get(Student04.class, 1001l);
        System.out.println(student04);
        System.out.println("*********************\n");
        Diary diary = session.get(Diary.class,101l);
        System.out.println(diary);
        System.out.println("\n******** Get the Diary Object From Student ********");
        System.out.println(student04.getDiary());
        System.out.println("\n******** Get the Student Object From Diary ********");
        System.out.println(diary.getStudent());
        System.out.println("\n******** Get the Student Name Through the Diary ********");
        System.out.println(diary.getStudent().getName());
        System.out.println("\n******** INNER JOIN ********");
        // Get the Student Name and Diary Name with HQL. (by using INNER JOIN)
        String hql1 = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary d ON s.id=d.student.id";
        List<Object[]> resultList1 = session.createQuery(hql1).getResultList();
        resultList1.forEach(obj-> System.out.println(Arrays.toString(obj)));
        System.out.println("\n******** LEFT JOIN ********");
        // Get the Student Name and Diary Name with HQL. (by using LEFT JOIN)
        String hql2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary d ON s.id=d.student.id";
        List<Object[]> resultList2 =session.createQuery(hql2).getResultList();
        resultList2.forEach(t-> System.out.println(Arrays.toString(t)));

        System.out.println("\n******** RIGHT JOIN ********");
        String hql3 = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Diary d ON s.id=d.student.id";
        List<Object[]> resultList3 =session.createQuery(hql3).getResultList();
        resultList3.forEach(t-> System.out.println(Arrays.toString(t)));

        System.out.println("\n******** FULL JOIN ********");
        // Get the Student Name and Diary Name with HQL.
        String hql4 = "SELECT s.name, d.name FROM Student04 s FULL JOIN FETCH Diary d ON s.id=d.student.id";
        List<Object[]> resultList4 =session.createQuery(hql4).getResultList();
        resultList3.forEach(t-> System.out.println(Arrays.toString(t)));





        tx.commit();
        session.close();
        sf.close();




    }

}
