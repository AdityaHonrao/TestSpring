package com.test.litmus.StudentData;

import com.google.gson.Gson;
import com.test.litmus.StudentData.entities.Student;
import com.test.litmus.StudentData.services.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentController {


    @Autowired
    private StudentServiceImplementation studentServiceImplementation;

    @PostMapping("/addStudent")
    public ResponseEntity<HttpStatus> createStudent(@RequestBody Student student){
        try {
            this.studentServiceImplementation.add(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateStudent")
    public ResponseEntity<HttpStatus> updateStudent(@RequestBody Student student){
        try {
            this.studentServiceImplementation.update(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/deleteStudent")
    public ResponseEntity<HttpStatus> delete(@RequestParam long id){

        try {
            this.studentServiceImplementation.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getStudents")
    public String getStudentData(){
        Gson gson = new Gson();

        return gson.toJson(studentServiceImplementation.getData());
    }
}
