package com.example.Student.controller;

import com.example.Student.Dto.StudentDetailsDto;
import com.example.Student.Model.StudentDetails;
import com.example.Student.service.StudentDetailsService;
import com.example.Student.service.impl.StudentDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class StudentDetailsController {

    private final StudentDetailsService studentDetailsService;

    @Autowired
    public StudentDetailsController(StudentDetailsService studentDetailsService) {
        this.studentDetailsService = studentDetailsService;
    }

    @RequestMapping(value = "/StudentDetails")
    public String listStudentDetails(@RequestParam(name = "FirstName", required = false, defaultValue = "World") String name, Model model) {
        List<Object> studentDetails = studentDetailsService.findAllStudentDetails();
        model.addAttribute("FirstName", name);
        model.addAttribute("allstudentdetailslist", studentDetails);
        return "StudentDetails"; // This will render the StudentDetails.html template
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.GET)
    public String addNewStudentDetails(Model model) {
        StudentDetailsDto studentDetails = new StudentDetailsDto(); // Use DTO here for form
        model.addAttribute("studentDetails", studentDetails);
        return "AddStudent"; // This should point to your AddStudent.html form template
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute StudentDetailsDto studentDetails) {
        studentDetailsService.saveStudentDetails(studentDetails); // Save DTO to the database
        return "redirect:/StudentDetails"; // Redirect after saving
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        StudentDetailsDto studentDetailsDto = studentDetailsService.findStudentDetailsById(id); // Fetch DTO, not Entity
        model.addAttribute("studentDetails", studentDetailsDto); // Add DTO to model
        return "update"; // Return the update.html template
    }

    @PutMapping("/update")
    public String updateStudent(@ModelAttribute("studentDetails") StudentDetailsDto studentDetailsDto) {
        studentDetailsService.updateStudentDetails(studentDetailsDto); // Update using DTO
        return "redirect:/StudentDetails"; // Redirect after update
    }

    @GetMapping("/listStudents")
    public String listStudents(Model model) {
        List<StudentDetails> allStudents = studentDetailsService.findAllStudents(); // Fetch list of all students (Entities)
        model.addAttribute("allstudentdetailslist", allStudents);
        return "StudentDetails"; // This will render the StudentDetails.html template
    }

}


