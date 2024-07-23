package org.example.exo_etudiant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotNull(message = "Sé fiel !")
    @NotBlank
    private String lastName;


    @NotNull(message = "We need to bound!")
    @NotBlank
    @Column(name = "prenom")
    private String firstName;


    @Min(17)
    @Max(55)
    @Column(name = "age")
    private int age;


    @NotBlank
    @Email
    private String email;

}

