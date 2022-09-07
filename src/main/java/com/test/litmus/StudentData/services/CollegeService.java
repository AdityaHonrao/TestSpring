package com.test.litmus.StudentData.services;

import com.test.litmus.StudentData.entities.College;

import java.util.List;
import java.util.Optional;

public interface CollegeService {

    public List<College> getData();

    public Optional<College> getById(Long id);

    public void add(College college);

    public List<College> filterByName(String name);

    public int deleteById(Long id);
}
