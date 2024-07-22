package org.example.exo_etudiant.model;

import lombok.*;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private long id;
    private String lastName;
    private String firstName;
    private int age;
    private String email;

}

