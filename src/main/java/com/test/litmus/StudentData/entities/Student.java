package com.test.litmus.StudentData.entities;

import javax.persistence.*;

@Entity
public class Student {
    private Integer id;
    private String name;

    @ManyToOne
    private College college;

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
