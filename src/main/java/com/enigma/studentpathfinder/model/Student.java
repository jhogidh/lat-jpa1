package com.enigma.studentpathfinder.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student", indexes = {
        //bikin index @Index(name, column)
        @Index(name = "idx_student_name", columnList = "name"),
        @Index(name = "idx_student_email", columnList = "email")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentProfile profile;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Project> project = new ArrayList<>();



}
