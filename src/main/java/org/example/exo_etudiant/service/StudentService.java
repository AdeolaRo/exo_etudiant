package org.example.exo_etudiant.service;

import org.example.exo_etudiant.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private Long id = 1L;
    private List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    public Student findStudentByName(String name) {
        return students.stream().filter(student -> student.getFirstName().equals(name)).findFirst().orElse(null);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void createStudent(Student student) {
        student.setId(id++);
        students.add(student);
    }

    public void updateStudent(Student updatedStudent) {
        Optional<Student> student1 = students.stream()
                .filter(student -> student.getId() == updatedStudent.getId())
                .findFirst();

        if (student1.isEmpty())
            return;

        Student student = student1.get();
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setAge(updatedStudent.getAge());
        student.setEmail(updatedStudent.getEmail());

    }

    public void deleteStudent(Long studentId) {
        students.removeIf(student -> student.getId() == studentId);
    }

    public Student findById(Long id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }
}


