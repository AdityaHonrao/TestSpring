package com.test.litmus.StudentData.services;

import com.test.litmus.StudentData.dao.CollegeDataDao;
import com.test.litmus.StudentData.entities.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Repository
public class CollegeServiceImplementation implements CollegeService{

    @Autowired
    CollegeDataDao collegeDataDao;

    @Override
    public List<College> getData() {
        return collegeDataDao.findAll();
    }

    @Override
    public Optional<College> getById(Long id) {
        return collegeDataDao.findById(id);
    }

    @Override
    public void add(College college) {
        collegeDataDao.save(college);
    }

    @Override
    public List<College> filterByName(String name) {
        return collegeDataDao.findAll().stream().filter(entry -> entry.getCollegeName().contains(name)).toList();
    }

    @Override
    public int deleteById(Long id) {
        try{
            collegeDataDao.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    @Override
    public void update(College college) {
        collegeDataDao.save(college);
    }
}
