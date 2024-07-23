package org.example.exo_etudiant.repository;


import org.example.exo_etudiant.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByFirstNameIgnoreCase(String firstName);
    Student findByLastNameIgnoreCase(String lastName);
    s
}
