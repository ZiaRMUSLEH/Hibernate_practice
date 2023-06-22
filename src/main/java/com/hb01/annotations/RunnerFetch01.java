package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main (String[] args) {

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        /*
        In order to fetch data from DB, there are three ways
        1. get();
        2. SQL
        3. HQL
         */

//        Student01 student01 = session.get(Student01.class,1);
//
//        Student01 student02 = session.get(Student01.class,2);
//
//        Student01 student03 = session.get(Student01.class,3);
//        System.out.println(student01);
//        System.out.println(student02);
//        System.out.println(student03);
        //SQL

//        String query1 = "SELECT * FROM t_student01 ";
//        List<Object[]> list = session.createSQLQuery(query1).getResultList();
//        for(Object[] stu: list){
//            System.out.println(Arrays.toString(stu));
//        }

        //HQL

//        String hqlQuery = "FROM Student01";
//        List<Student01> students =session.createQuery(hqlQuery,Student01.class).getResultList();
//
//        System.out.println(students);

//        for (Student01 st:students) {
//            System.out.println(st);
//        }
// TASKS
        // Get the student with the name John, as a unique result in SQL.
//       String task1 = "SELECT * FROM t_student01 WHERE student_name ='John'";
//       Object[] john = (Object[]) session.createSQLQuery(task1).uniqueResult();
//        System.out.println(Arrays.toString(john));

//        // Get the student with the name John, as a unique result in HQL. (With Aliases)
//        String task2 = "FROM Student01 s WHERE s.name = 'John'";
//        Student01 john1 = session.createQuery(task2, Student01.class).uniqueResult();
//        System.out.println(john1);



        // Get the name and id's of students whose ids are less than 3, in HQL, using aliases.
//        String task3 = "SELECT s.name, s.id FROM Student01 s WHERE s.id<3 ";
//         List<Object[]>list1 = session.createQuery(task3).getResultList();
//        for (Object[] stu: list1){
//            System.out.println(Arrays.toString(stu));
//        }


        tx.commit();
        session.close();
        sessionFactory.close();


    }
}
