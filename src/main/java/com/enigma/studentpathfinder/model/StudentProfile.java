package com.enigma.studentpathfinder.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "studentprofiles", indexes = {
        @Index(name = "idx_profile_phone_number", columnList = "phone_number")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "student")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id", unique = true)
    private Student student;

}
