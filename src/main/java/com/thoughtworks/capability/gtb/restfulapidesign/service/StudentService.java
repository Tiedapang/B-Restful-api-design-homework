package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotFoundException;
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

    public Student getStudentById(int id) {
        Student student = studentRepository.getStudentById(id);
        if (student == null){
            throw new StudentNotFoundException("用户不存在");
        }
        return studentRepository.getStudentById(id);
    }

    public void updateStudent(int id, Student student) {
        Student student1 = studentRepository.getStudentById(id);
        student.setNote(student1.getNote());
        studentRepository.updateStudent(student);
    }
}
