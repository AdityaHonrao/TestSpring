package com.test.litmus.StudentData;

import com.google.gson.Gson;
import com.test.litmus.StudentData.entities.College;
import com.test.litmus.StudentData.entities.Student;
import com.test.litmus.StudentData.services.CollegeServiceImplementation;
import com.test.litmus.StudentData.services.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    @Autowired
    private StudentServiceImplementation studentServiceImplementation;

    @Autowired
    private CollegeServiceImplementation collegeServiceImplementation;


    @PostMapping("/insertCollege")
    public ResponseEntity<HttpStatus> create(@RequestBody College college){
        try {
            this.collegeServiceImplementation.add(college);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insertStudent")
    public ResponseEntity<HttpStatus> createStudent(@RequestBody Student student){
        try {
            this.studentServiceImplementation.add(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getColleges")
    public String getCollegeData(){
        Gson gson = new Gson();

        return gson.toJson(collegeServiceImplementation.getData());
    }

    @GetMapping("/getStudents")
    public String getStudentData(){
        Gson gson = new Gson();

        return gson.toJson(studentServiceImplementation.getData());
    }
}
