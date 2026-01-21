package com.example.caffeine.controller;

import com.example.caffeine.model.Student;
import com.example.caffeine.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/{id}/cached")
    public long getStudentCached(@PathVariable String id) {
        long start = System.currentTimeMillis();
        Student student = studentService.getStudentByIdCached(id);
        long end = System.currentTimeMillis();
        long time=((end-start));
        IO.println(time);
        return time;
    }

    @GetMapping("/{id}/notcached")
    public long getStudentNotCached(@PathVariable String id) {
        long start = System.currentTimeMillis();
        Student student = studentService.getStudentByIdNotCached(id);
        long end = System.currentTimeMillis();
        long time=((end-start));
        IO.println(time);
        return time;

    }


}
