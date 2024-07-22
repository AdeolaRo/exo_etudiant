package org.example.exo_etudiant.model;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id;
    @Column(name = "nom")
    private String lastName;
    @Column(name = "prenom")
    private String firstName;
    @Column(name = "age")
    private int age;
    private String email;

}

