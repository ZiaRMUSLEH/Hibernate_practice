package com.hb10.idgeneration;


import javax.persistence.*;

@Entity
@Table(name = "t_student10")
public class Student10 {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "sequence",
            sequenceName = "stu_id",
            initialValue = 1000,
            allocationSize = 10
    )
    private Long id;

    private String name;

    private int grade;

    public Student10 (Long id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Student10 () {
    }

    public Long getId () {
        return id;
    }

//    public void setId (Long id) {
//        this.id = id;
//    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getGrade () {
        return grade;
    }

    public void setGrade (int grade) {
        this.grade = grade;
    }
}
