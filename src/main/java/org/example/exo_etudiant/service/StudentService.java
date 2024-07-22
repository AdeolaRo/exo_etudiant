package org.example.exo_etudiant.service;

import org.example.exo_etudiant.model.Student;
import org.example.exo_etudiant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findStudentByName(String search) {
        Student student = studentRepository.findByFirstNameIgnoreCase(search);
        if (student == null) {
            student = studentRepository.findByLastNameIgnoreCase(search);
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(updatedStudent.getId());
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setAge(updatedStudent.getAge());
            student.setEmail(updatedStudent.getEmail());
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
