package com.test.litmus.StudentData.services;


import com.test.litmus.StudentData.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public List<Student> getData();

    public Optional<Student> getById(Long id);

    public void add(Student student);

    public List<Student> filterByName(String name);

    public int deleteById(Long id);

    public void update(Student student);
}
