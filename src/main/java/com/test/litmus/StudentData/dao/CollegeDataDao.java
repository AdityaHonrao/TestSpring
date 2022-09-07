package com.test.litmus.StudentData.dao;

import com.test.litmus.StudentData.entities.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeDataDao extends JpaRepository<College, Long> {
}
