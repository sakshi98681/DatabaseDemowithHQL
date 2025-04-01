package com.tka.service;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class Studentservice {
	
	@Autowired
    private Repository studentRepository;

    public List<Student> getAllStudents() {
        return ((Studentservice) studentRepository).getAllStudents();
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = ((Object) studentRepository).findById(id);
        return student.orElse(null);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public int updateStudent(Long id, String name, int age, String course) {
        return ((Studentservice) studentRepository).updateStudent(id, name, age, course);
    }

    public int deleteStudent(Long id) {
        return studentRepository.deleteStudent(id);
    }

    public List<Student> getStudentsByCourse(String course) {
        return ((Studentservice) studentRepository).getStudentsByCourse(course);
    }

    public List<Student> getStudentsOlderThan(int age) {
        return ((Studentservice) studentRepository).getStudentsOlderThan(age);
    }
}


