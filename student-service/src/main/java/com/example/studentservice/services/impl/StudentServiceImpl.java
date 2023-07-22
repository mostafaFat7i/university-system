package com.example.studentservice.services.impl;

import com.example.studentservice.entities.Student;
import com.example.studentservice.repositories.StudentRepository;
import com.example.studentservice.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private static final Logger infoLogger = LoggerFactory.getLogger("infoLogger");
    private static final Logger errorLogger = LoggerFactory.getLogger("errorLogger");
    private static final Logger debugLogger = LoggerFactory.getLogger("debugLogger");

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String saveStudent(Student student) {
        if (isStudentExists(student.getStudentId())){
            return "This Student is already exists";
        }
        studentRepository.save(student);
        infoLogger.info("New student is added with id: " + student.getStudentId());
        return "Student is added successfully";
    }

    @Override
    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student updatedStudent = existingStudent.get();
            updatedStudent.setStudentName(student.getStudentName());
            updatedStudent.setAddress(student.getAddress());
            updatedStudent.setUsername(student.getUsername());
            updatedStudent.setPhone(student.getPhone());
            updatedStudent.setPassword(student.getPassword());
            updatedStudent.setDept(student.getDept());
            return studentRepository.save(updatedStudent);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            studentRepository.delete(existingStudent.get());
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    public boolean isStudentExists(Long studentId){
        return studentRepository.existsById(studentId);
    }
}