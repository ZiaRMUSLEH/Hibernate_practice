package com.hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_student03")
public class Student03 {


    @Id
    private Long id;

    private String name;

    private int grade;

    public Student03 () {
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    @Override
    public String toString () {
        return "Student03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

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
