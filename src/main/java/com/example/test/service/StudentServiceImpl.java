package com.example.test.service;

import com.example.test.dto.StudentDTO;
import com.example.test.exception.StudentNotFoundException;
import com.example.test.entity.Student;
import com.example.test.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> convertToDTO(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return convertToDTO(student);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student(studentDTO.name(), studentDTO.family());
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
        student.setName(studentDetails.name());
        student.setFamily(studentDetails.family());
        Student updatedStudent = studentRepository.save(student);
        return convertToDTO(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
        studentRepository.delete(student);
    }

    private StudentDTO convertToDTO(Student student) {
        return new StudentDTO(student.getId(), student.getName(), student.getFamily());
    }
}