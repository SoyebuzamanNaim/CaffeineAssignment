package com.example.caffeine;

import com.example.caffeine.model.Student;
import com.example.caffeine.service.StudentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTest {
    @Autowired
    public StudentService studentService;

    @Test
    void test1() {
        Student student = new Student();
        student.setName("Naim");
        student.setDept("CSE");
        Student savedStudent = studentService.saveStudent(student);
        IO.println(savedStudent.getId());
    }

    @Test
    void test2() {
        Student student = new Student();
        student.setName("Jihad");
        student.setDept("CSE");
        Student savedStudent = studentService.saveStudent(student);
        IO.println(savedStudent.getId());
    }

    @Test
    void test3() {
        Student student = new Student();
        student.setName("Samir");
        student.setDept("CSE");
        Student savedStudent = studentService.saveStudent(student);
        IO.println(savedStudent.getId());
    }

    @Test
    void test4(){

    }
}
