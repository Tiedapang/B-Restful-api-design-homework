package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public List<Student> findStudentsByGender(String gender) {
        return studentRepository.findStudentByGender(gender);

    }
}
