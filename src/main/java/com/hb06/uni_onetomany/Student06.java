package com.hb06.uni_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "t_student06")
public class Student06 {

    @Id
    private long id;

    @Column(name="stu_name",nullable = false)
    private String name;

    private int grade;

    @OneToMany
    @JoinColumn
    private List<Book> bookList = new ArrayList<>();

    @Override
    public String toString () {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
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

    public List<Book> getBookList () {
        return bookList;
    }

    public void setBookList (List<Book> bookList) {
        this.bookList = bookList;
    }
}
