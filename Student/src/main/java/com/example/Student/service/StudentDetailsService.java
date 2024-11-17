package com.example.Student.service;

import com.example.Student.Dto.StudentDetailsDto;
import com.example.Student.Model.StudentDetails;
import com.example.Student.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentDetailsService {
    List<Object> findAllStudentDetails();
    List<StudentDetails> findAllStudents();
    StudentDetails save(StudentDetails studentDetails);
    void saveStudentDetails(StudentDetailsDto studentDetailsDto);  // Make sure this method is declared
    StudentDetails findById(long id);

    void updateStudentDetails(StudentDetailsDto studentDetailsDto);

    StudentDetailsDto findStudentDetailsById(long id);



    @Service
    public class StudentService {

        @Autowired
        private StudentRepo studentRepo;  // Use your repository here
        public List<StudentDetails> findAllStudents() {
            return null;
        }

    }
}

