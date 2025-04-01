package com.tka.Controller;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {
	
	@Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
        @PostMapping
        public Student addStudent(@RequestBody Student student) {
            return studentService.saveStudent(student);
        }

        @PutMapping("/{id}")
        public String updateStudent(@PathVariable Long id, @RequestBody Student student) {
            int updated = studentService.updateStudent(id, student.getName(), student.getAge(), student.getCourse());
            return updated > 0 ? "Student updated successfully" : "Student not found";
        }

        @DeleteMapping("/{id}")
        public String deleteStudent(@PathVariable Long id) {
            int deleted = studentService.deleteStudent(id);
            return deleted > 0 ? "Student deleted successfully" : "Student not found";
        }
        @GetMapping("/course/{course}")
        public List<Student> getStudentsByCourse(@PathVariable String course) {
            return studentService.getStudentsByCourse(course);
        }

        @GetMapping("/age/{age}")
        public List<Student> getStudentsOlderThan(@PathVariable int age) {
            return studentService.getStudentsOlderThan(age);
        
    
    }

}
