package com.example.caffeine.service;

import com.example.caffeine.model.Student;
import com.example.caffeine.repository.StudentRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Cacheable(cacheNames = "students",key = "#id")
    public Student getStudentByIdCached(String id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student getStudentByIdNotCached(String id){
        return studentRepository.findById(id).orElse(null);
    }

    @CachePut(cacheNames = "students",key = "#result.id")
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @CachePut(cacheNames = "students",key="#id")
    public Student updateStudent(String id,Student student){
        if(!studentRepository.existsById(id)){
            throw new RuntimeException();
        }
        return studentRepository.save(student);
    }

    @CacheEvict(cacheNames = "students",key = "#id")
    public void deleteStudentByIdCached(String id){
        studentRepository.deleteById(id);
    }

    public void deleteStudentByIdNotCached(String id){
        studentRepository.deleteById(id);
    }
}
