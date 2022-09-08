package com.test.litmus.StudentData;

import com.google.gson.Gson;
import com.test.litmus.StudentData.entities.College;
import com.test.litmus.StudentData.services.CollegeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CollegeController {


    @Autowired
    private CollegeServiceImplementation collegeServiceImplementation;


    @PostMapping("/addCollege")
    public ResponseEntity<HttpStatus> create(@RequestBody College college){
        try {
            this.collegeServiceImplementation.add(college);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateCollege")
    public ResponseEntity<HttpStatus> updateStudent(@RequestBody College college){
        try {
            this.collegeServiceImplementation.update(college);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/deleteCollege")
    public ResponseEntity<HttpStatus> delete(@RequestParam long id){

        try {
            this.collegeServiceImplementation.deleteById(id);
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

}
