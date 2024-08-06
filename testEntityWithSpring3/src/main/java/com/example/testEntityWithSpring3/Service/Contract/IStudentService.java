package com.example.testEntityWithSpring3.Service.Contract;

import com.example.testEntityWithSpring3.DTO.ListStudentDTO;
import com.example.testEntityWithSpring3.DTO.StudentCreateRequestDTO;
import com.example.testEntityWithSpring3.DTO.StudentUpdateRequestDTO;
import com.example.testEntityWithSpring3.Entity.StudentEntity;
import com.example.testEntityWithSpring3.Utils.ServiceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IStudentService {
    ResponseEntity<ServiceResponse<List<StudentEntity>>> GetAllStudent();
    ResponseEntity<ServiceResponse<StudentEntity>> GetStudentById(String Id) ;
    ResponseEntity<ServiceResponse<StudentEntity>> CreateStudent (StudentCreateRequestDTO student);
    ResponseEntity<ServiceResponse<StudentEntity>> UpdateStudent (StudentUpdateRequestDTO student);
    ResponseEntity<ServiceResponse<StudentEntity>> DeleteStudentById (String id);
}
 