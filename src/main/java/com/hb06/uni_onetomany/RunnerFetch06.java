package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main (String[] args) {

        Configuration con = new Configuration()
                .configure("Hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Student06.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        // Get the student with id: 1001
        Student06 student1 = session.get(Student06.class, 1001L);
        //System.out.println(student1);

        // Get/Fetch the book id&name with id: 101 using HQL
        String hql1 = "SELECT b.id,b.name FROM Book b WHERE id=101";
        List<Object[]> books = session.createQuery(hql1).getResultList();
        books.forEach(t-> System.out.println(Arrays.toString(t)));


        System.out.println("\n******** Get/Fetch the student's book with id: 1001 using HQL ********");
        String hql2 = "SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b WHERE  s.id=1001";
        List<Object[]> books1 = session.createQuery(hql2).getResultList();
        books1.forEach(t-> System.out.println(Arrays.toString(t)));
        // Another way
        List<Book> bookList = session.get(Student06.class,1001l).getBookList();
        bookList.forEach(System.out::println);


        System.out.println("\n******** Fetch the books of the student whose id is 1001. (Use the get method) ********");








        tx.commit();
        session.close();
        sf.close();


    }
}
