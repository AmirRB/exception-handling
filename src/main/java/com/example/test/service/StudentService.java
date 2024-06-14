package com.example.test.service;

import com.example.test.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO createStudent(StudentDTO student);

    StudentDTO updateStudent(Long id, StudentDTO studentDetails);

    void deleteStudent(Long id);

}
