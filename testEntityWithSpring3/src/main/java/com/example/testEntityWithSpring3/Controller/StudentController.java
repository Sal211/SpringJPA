package com.example.testEntityWithSpring3.Controller;

import com.example.testEntityWithSpring3.DTO.StudentCreateRequestDTO;
import com.example.testEntityWithSpring3.DTO.StudentUpdateRequestDTO;
import com.example.testEntityWithSpring3.Entity.StudentEntity;
import com.example.testEntityWithSpring3.Service.StudentService;
import com.example.testEntityWithSpring3.Utils.ServiceResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/GetAll")
    public ResponseEntity<ServiceResponse<List<StudentEntity>>> GetAllStudent() {
        return studentService.GetAllStudent();
    }
    @PostMapping("/Create")
    public ResponseEntity<ServiceResponse<StudentEntity>> AddStudent(@Valid @RequestBody StudentCreateRequestDTO student) {
        return studentService.CreateStudent(student);
    }
        @PostMapping("/Update")
    public ResponseEntity<ServiceResponse<StudentEntity>> UpdateStudent(@RequestBody StudentUpdateRequestDTO student) {
        return studentService.UpdateStudent(student);
    }
    @GetMapping( "/GetById/{Id}")
    public ResponseEntity<ServiceResponse<StudentEntity>> GetStudentById(@PathVariable("Id") String Id) {
        return studentService.GetStudentById(Id);
    }
    @PostMapping("/Delete/{Id}")
    public ResponseEntity<ServiceResponse<StudentEntity>> DeleteStudent(@PathVariable("Id") String Id) {
        return studentService.DeleteStudentById(Id);
    }
}
