package com.example.Student.Repository;

import com.example.Student.Model.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<StudentDetails, Long> {
    Optional<StudentDetails> findByFirstName(String url);

}
