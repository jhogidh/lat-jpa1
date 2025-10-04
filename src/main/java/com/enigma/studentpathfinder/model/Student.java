package com.enigma.studentpathfinder.model;

import jakarta.persistence.*;
import lombok.*;

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

}
