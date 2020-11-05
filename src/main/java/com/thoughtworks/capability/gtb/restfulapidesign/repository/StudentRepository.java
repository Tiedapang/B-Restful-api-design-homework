package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRepository {
    private static Map<Integer, Student> studentMap = new HashMap<>();

    public void addStudent(Student student) {
        student.setId(studentMap.size());
        studentMap.put(student.getId(),student);
    }

    public void deleteStudent(int id) {
        studentMap.remove(id);
    }

    public List<Student> findAll() {
        return new ArrayList<Student>(studentMap.values());
    }

    public List<Student> findStudentByGender(String gender) {
        return studentMap.values().stream().filter(student -> student.getGender()==gender).collect(Collectors.toList());
    }
}
