package com.hb04.bi_onetoone.bi_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_diary1")
public class Diary {

    @Id
    private Long id;

    private String name;

    @OneToOne
    private Student04 student;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Student04 getStudent () {
        return student;
    }

    public void setStudent (Student04 student) {
        this.student = student;
    }

    @Override
    public String toString () {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
