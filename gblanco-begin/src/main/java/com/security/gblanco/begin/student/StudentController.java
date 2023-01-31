package com.security.gblanco.begin.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("api/v1/students")
@RestController
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Gustavo Blanco"),
            new Student(2, "Katheryn Salamanca"),
            new Student(3, "Elsin Vila")
            );

    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable Integer id){
        return STUDENTS.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student with ID: "+id+" doesn't exists"));
    }

}
