package com.test.litmus.StudentData.services;

import com.test.litmus.StudentData.dao.StudentDataDao;
import com.test.litmus.StudentData.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Repository
public class StudentServiceImplementation implements StudentService {
    @Autowired
    StudentDataDao studentDataDao;

    @Override
    public List<Student> getData() {
        return studentDataDao.findAll();
    }

    @Override
    public Optional<Student> getById(Long id) {
        return studentDataDao.findById(id);
    }

    @Override
    public void add(Student student) {
        studentDataDao.save(student);
    }

    @Override
    public List<Student> filterByName(String name) {
        return studentDataDao.findAll().stream().filter(entry -> entry.getName().contains(name)).toList();
    }

    @Override
    public int deleteById(Long id) {
        try{
            studentDataDao.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
}
