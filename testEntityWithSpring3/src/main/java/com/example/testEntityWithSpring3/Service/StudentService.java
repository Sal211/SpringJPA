package com.example.testEntityWithSpring3.Service;

import com.example.testEntityWithSpring3.DAO.StudentDAO;
import com.example.testEntityWithSpring3.DTO.StudentCreateRequestDTO;
import com.example.testEntityWithSpring3.DTO.StudentUpdateRequestDTO;
import com.example.testEntityWithSpring3.Entity.StudentEntity;
import com.example.testEntityWithSpring3.Service.Contract.IStudentService;
import com.example.testEntityWithSpring3.Utils.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private   StudentDAO studentDAO;
    private <T> ResponseEntity<ServiceResponse<T>> HandleError(String msg,Exception ex){
        return ResponseEntity.status(500).body(new ServiceResponse<>(null ,ex.getMessage(),"Error When "+msg+" Customer",false));
    }
    @Override
    public ResponseEntity<ServiceResponse<List<StudentEntity>>> GetAllStudent() {
        try{
            List<StudentEntity> students = studentDAO.findAll();
            return ResponseEntity.ok().body(new ServiceResponse<>(students,null,"Getting Success",true));
        }catch (Exception ex){
            return HandleError( "Getting",ex);
        }
    }

    @Override
    public ResponseEntity<ServiceResponse< StudentEntity>> GetStudentById(String Id ) {
        try{
            StudentEntity student = studentDAO.findOneById(Id);
            return ResponseEntity.ok().body(new ServiceResponse<>(student,null,"Getting Success",true));
        }catch (Exception ex){
            return HandleError( "Getting",ex);
        }
    }

    @Override
    public ResponseEntity<ServiceResponse<StudentEntity>> CreateStudent(StudentCreateRequestDTO student) {
        try {
            StudentEntity newStudent = new StudentEntity();
            newStudent.setName(student.getName());
            newStudent.setGender(student.getGender());
            studentDAO.save(newStudent);
            return ResponseEntity.ok().body(new ServiceResponse<>(newStudent,null,"Creating Success",true));
        }catch (Exception ex){
            return HandleError( "Create",ex);
        }
    }

    @Override
    public ResponseEntity<ServiceResponse<StudentEntity>> UpdateStudent(StudentUpdateRequestDTO student) {
        try {
            StudentEntity existingStudent = studentDAO.findOneById(student.getId());
            if (existingStudent == null) {
                return ResponseEntity.status(404).body(new ServiceResponse<>(null,null,"Student Not Found",false));
            }
            existingStudent.setName(student.getName());
            existingStudent.setGender(student.getGender());
            studentDAO.save(existingStudent);
            return ResponseEntity.ok().body(new ServiceResponse<>(existingStudent,null,"Updating Success",true));
        }catch (Exception ex){
            return HandleError( "Update",ex);
        }
    }

    @Override
    public ResponseEntity<ServiceResponse<StudentEntity>> DeleteStudentById(String id) {
        try {
            StudentEntity existingStudent = studentDAO.findOneById(id);
            if (existingStudent == null) {
                return ResponseEntity.status(404).body(new ServiceResponse<>(null,null,"Student Not Found",false));
            }
            return ResponseEntity.ok().body(new ServiceResponse<>(null,null,"Deleting Success",true));
        }catch (Exception ex){
            return HandleError( "Delete",ex);
        }
    }
}
