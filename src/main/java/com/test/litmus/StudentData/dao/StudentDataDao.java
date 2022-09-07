package com.test.litmus.StudentData.dao;

import com.test.litmus.StudentData.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDataDao extends JpaRepository<Student, Long> {
}
