package com.hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {


    @Id
    private Long id;

    private String diaryName;

    @OneToOne
    @JoinColumn
    private Student03 student;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getDiaryName () {
        return diaryName;
    }

    public void setDiaryName (String diaryName) {
        this.diaryName = diaryName;
    }

    public Student03 getStudent () {
        return student;
    }

    public void setStudent (Student03 student) {
        this.student = student;
    }

    public Diary () {
    }

    @Override
    public String toString () {
        return "Diary{" +
                "id=" + id +
                ", diaryName='" + diaryName + '\'' +
                ", student=" + student +
                '}';
    }
}
