package com.example.Student.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student_details")



public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long Id;
    private Integer AdminNo;
    private String firstName;
    private String OtherName;
    private String Gender;
    private String Grade;
    @CreationTimestamp
    private LocalDate DateCreated;
    @UpdateTimestamp
    private LocalDate updatedOn;

    public Long getId() {
        return Id;
    }

    public Integer getAdminNo() {
        return AdminNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getOtherName() {
        return OtherName;
    }

    public String getGender() {
        return Gender;
    }

    public String getGrade() {
        return Grade;
    }

    public LocalDate getDateCreated() {
        return DateCreated;
    }
}
