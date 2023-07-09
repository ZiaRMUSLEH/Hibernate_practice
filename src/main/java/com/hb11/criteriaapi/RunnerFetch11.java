package com.hb11.criteriaapi;

import com.hb01.annotations.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11 {
    public static void main (String[] args) {


        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student11.class);
        SessionFactory sessionFactory= con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        // Update An Existing Data
        Student11  student1 = session.get(Student11.class,1l);
        //student1.setName("updated "+student1.getName());
//        student1.setName("student1");
//        session.update(student1);

        // Update An Existing Data With Query
        // Update the grades that are less than 50, to 70.

        int previousGrade = 50;
        int newGrade = 70;

        String HQLquery1 = "UPDATE Student11  SET grade =:x WHERE grade <: y";
        Query query1 = session.createQuery(HQLquery1);
        query1.setParameter("x",previousGrade);
        query1.setParameter("y",newGrade);

       // int numOfUpdatedRows = query1.executeUpdate();
       // System.out.println("numOfUpdatedRows = " + numOfUpdatedRows);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery = criteriaBuilder.createQuery(Student11.class);
        Root<Student11> root =  criteriaQuery.from(Student11.class);


        // Select All Students
        criteriaQuery.select(root);
       // Query<Student11> query =
        List<Student11> list = session.createQuery(criteriaQuery.select(root)).getResultList();
        //list.forEach(t-> System.out.println(t));

        // Get the studentS whose name is "Student 5"
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"),"Student5"));
        Query<Student11> query2 = session.createQuery(criteriaQuery);
        List<Student11> list2 = query2.getResultList();
        //list2.forEach(System.out::println);

        // Get the students whose grade are bigger than 80.
        criteriaQuery.select(root).where(criteriaBuilder.greaterThan(root.get("grade"),80));
        List<Student11> list3 = session.createQuery(criteriaQuery).getResultList();
        //list3.forEach(System.out::println);

        // Get the students whose grade are less than 90.
        criteriaQuery.select(root).where(criteriaBuilder.lessThan(root.get("grade"),90));
        Query<Student11> query4 = session.createQuery(criteriaQuery);
        List<Student11> list4 = query4.getResultList();
        //list4.forEach(System.out::println);

        // Find the records whose id is equal to 1, or grade is greater than 75
        // Predicate

        Predicate predicateId = criteriaBuilder.equal(root.get("id"),1L);
        Predicate predicateGrade = criteriaBuilder.greaterThan(root.get("grade"),75);
        Predicate predicateOr = criteriaBuilder.or(predicateId,predicateGrade);
        criteriaQuery.where(predicateOr);
        List<Student11> list5 = session.createQuery(criteriaQuery).getResultList();
        list5.forEach(System.out::println);







        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
