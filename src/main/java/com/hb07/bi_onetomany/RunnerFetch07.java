package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main (String[] args) {

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student07.class)
                .addAnnotatedClass(Book07.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Get the student with ID: 1001, using a method.
       // Student07 student1 = session.get(Student07.class, 1001l);
       // System.out.println(student1);


        // Get the books of student1.
        //List<Book07> books = student1.getBookList();
       // books.forEach(book-> System.out.println(book));

        // Get the book with ID: 101
        //Book07 book = session.get(Book07.class,101l);
        //System.out.println(book);
        // Get the student information from the book object
        //System.out.println(book.getStudent());
        // Fetch the assigned student name and book names, using SQL from Student
        //String sql1 = "SELECT s.stu_name, b.name  FROM t_student07 s INNER JOIN t_book07 b ON s.id=b.stu_id";
        //List<Object[]> resultList = session.createSQLQuery(sql1).getResultList();
        //resultList.forEach(name-> System.out.println(Arrays.toString(name)));

        // Do the upper task with HQL
        //String hql1 = "SELECT s.name, b.name FROM Student07 s INNER JOIN Book07 b ON s.id=b.student.id";
        //List<Object[]> resultList1 = session.createQuery(hql1).getResultList();
        //resultList1.forEach(names-> System.out.println(Arrays.toString(names)));

         //Delete all the records from Book07 with SQL
//        String sql2 = "DELETE FROM t_book07";
//        int deletedRows = session.createSQLQuery(sql2).executeUpdate();
//        System.out.println(deletedRows);

        // Delete all the records from Student07 with HQL.
        String hql2 = "DELETE FROM Student07";
        int deletedRows1 = session.createQuery(hql2).executeUpdate();
        System.out.println(deletedRows1);


        tx.commit();
        session.close();
        sf.close();



    }
}
