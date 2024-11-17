package com.example.Student.service.impl;

import com.example.Student.Dto.StudentDetailsDto;
import com.example.Student.Model.StudentDetails;
import com.example.Student.Repository.StudentRepo;
import com.example.Student.service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public  class StudentDetailsServiceImpl implements StudentDetailsService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentDetailsServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Object> findAllStudentDetails() {
        // Fetch all student details and map them to DTOs
        List<StudentDetails> studentDetailsList = studentRepo.findAll();
        return studentDetailsList.stream()
                .map(this::mapToStudentDetailsDto)
                .collect(Collectors.toList());

    }

    private Object mapToStudentDetailsDto(StudentDetails studentDetails) {
        return StudentDetailsDto.builder()
                .Id(studentDetails.getId())
                .AdminNo(studentDetails.getAdminNo())
                .FirstName(studentDetails.getFirstName())
                .OtherName(studentDetails.getOtherName())
                .Gender(studentDetails.getGender())
                .Grade(studentDetails.getGrade())
                .DateCreated(studentDetails.getDateCreated())
                .build();
    }

    @Override
    public List<StudentDetails> findAllStudents() {
        // Fetch all student details as entities
        return studentRepo.findAll();

    }

    @Override
    public StudentDetails save(StudentDetails studentDetails) {
        return null;
    }

    @Override
    public void saveStudentDetails(StudentDetailsDto studentDetailsDto) {

    }

    @Override
    public StudentDetails findById(long id) {
        return null;
    }

    @Override
    public void updateStudentDetails(StudentDetailsDto studentDetailsDto) {

    }

    @Override
    public StudentDetailsDto findStudentDetailsById(long id) {
        return null;
    }
}