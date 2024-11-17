package com.example.Student.Dto;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.aspectj.bridge.Message;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetailsDto {
    private Long Id;
    private Integer AdminNo;
    private String FirstName;
    private String OtherName;
    private String Gender;
    private String Grade;
    private LocalDate DateCreated;

}
